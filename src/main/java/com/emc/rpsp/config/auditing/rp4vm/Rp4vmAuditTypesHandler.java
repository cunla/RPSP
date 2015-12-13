package com.emc.rpsp.config.auditing.rp4vm;

import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.config.auditing.AuditConsts;
import com.emc.rpsp.config.auditing.AuditEntry;
import com.emc.rpsp.config.auditing.AuditRepository;
import com.emc.rpsp.config.auditing.AuditTypesHandler;
import com.emc.rpsp.config.auditing.RpspAuditException;
import com.emc.rpsp.config.auditing.cache.AuditedMethodDescriptor;
import com.emc.rpsp.config.auditing.cache.AuditingCache;
import com.emc.rpsp.fal.Client;
import com.emc.rpsp.infra.common.auth.domain.AbstractCurrentUser;
import com.emc.rpsp.infra.common.auth.domain.CurrentUser;
import com.emc.rpsp.infra.common.systems.service.SystemsDataService;
import com.emc.rpsp.rpsystems.ClusterSettings;
import com.emc.rpsp.rpsystems.SystemSettings;
import com.emc.rpsp.users.domain.User;
import com.emc.rpsp.users.service.UserService;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.persistence.criteria.CriteriaBuilder;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by morand3 on 11/25/2015.
 */
public class Rp4vmAuditTypesHandler implements AuditTypesHandler {
    @Autowired 
    private AuditRepository auditRepository;
    @Autowired 
    private UserService userService;
    @Autowired
	private SystemsDataService systemsDataService = null;
    
    private Client client = null;

    public Rp4vmAuditTypesHandler() {
    }

    public AuditEntry getAuditEntry(Date date, String username, ProceedingJoinPoint joinPoint,
        Object resultValue) {
        AuditedMethodDescriptor descriptor = getAuditMethodDescriptor(joinPoint);
        String actionName = descriptor.getAction();
        Object[] args = joinPoint.getArgs();
        String subject = getSubject(descriptor, args);
        String resultText = getResultText(descriptor, resultValue);
        String objects = getObjectsText(descriptor, args);
        AuditEntry auditEntry = new AuditEntry(date, username, actionName, subject, resultText,
            objects);
        return auditEntry;
    }

    private String getObjectsText(AuditedMethodDescriptor descriptor, Object[] args) {
        List<String> objectText = new LinkedList<>();
        Map<Integer, String> objectsType = descriptor.getObjects();
        for (Map.Entry<Integer, String> entry : objectsType.entrySet()) {
            String objectType = entry.getValue();
            Object objectValue = args[entry.getKey()];
            objectText.add(getAuditText(objectType, objectValue));
        }
        return StringUtils.join(objectText, ", ");
    }

    private String getResultText(AuditedMethodDescriptor descriptor, Object resultValue) {
        if (null == resultValue || !descriptor.hasResult()) {
            return null;
        }
        return getAuditText(descriptor.getResultType(), resultValue);
    }

    private String getSubject(AuditedMethodDescriptor descriptor, Object[] args) {
        String subject = null;
        if (descriptor.hasSubject()) {
            Object subjectValue = args[descriptor.getSubjectIndex()];
            subject = getAuditText(descriptor.getSubjectType(), subjectValue);
        }
        return subject;
    }

    private AuditedMethodDescriptor getAuditMethodDescriptor(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        AuditedMethodDescriptor methodDescriptor = AuditingCache.instance()
            .getAuditDescriptor(method);
        return methodDescriptor;
    }

    public String getAuditText(String paramType, Object paramValue) {
    	client = getClientForAccount();
        if (null == client) {
            return paramType + paramValue;
        }
        if (AuditConsts.CG.equals(paramType)) {
            return getCgName(paramValue);
        } else if (AuditConsts.VM.equals(paramType)) {
            return getVmName(paramValue);
        } else if (AuditConsts.GS.equals(paramType)) {
            return getGroupSetName(paramValue);
        }
        else if (AuditConsts.COPY.equals(paramType)){
        	return getCopyName(paramValue);
        }
        else if (AuditConsts.CLUSTER.equals(paramType)){
        	return getClusterName(paramValue);
        }
        else if (AuditConsts.BOOKMARK_PARAMS.equals(paramType)){
        	return "Bookmark: " + ((Map<String, String>)paramValue).get("name");
        }
        else if (AuditConsts.ADD_VM_TO_CG_PARAMS.equals(paramType)){
        	return "VM: " + getVmName(((Map<String, String>)paramValue).get("id"));
        }
        else if(AuditConsts.DR_TEST_RESULT.equals(paramType) 
        		|| AuditConsts.DISABLE_DR_TEST_RESULT.equals(paramType)
        		|| AuditConsts.CREATE_BOOKMARK_RESULT.equals(paramType)
        		|| AuditConsts.FAILOVER_RESULT.equals(paramType)
        		|| AuditConsts.RECOVER_PRODUCTION_RESULT.equals(paramType)
        		|| AuditConsts.CREATE_CG_RESULT.equals(paramType)
        		|| AuditConsts.ADD_VM_TO_CG_RESULT.equals(paramType)
        		|| AuditConsts.REMOVE_VM_FROM_CG_RESULT.equals(paramType)){
        	ResponseEntity<HttpStatus> response = (ResponseEntity<HttpStatus>)paramValue;
        	return response.getStatusCode().name();
        }
        else{
        	return paramType + paramValue;
        }
        //throw new RpspAuditException("Couldn't get text for audit type {" + paramType + "}");
    }

    @Override
    public void writeRecordToAudit(Date date, String username, ProceedingJoinPoint joinPoint,
        Object resultValue) {
        AuditEntry entry = getAuditEntry(date, username, joinPoint, resultValue);
        auditRepository.save(entry);
        auditRepository.flush();
    }
    
    @Override
    public void writeRecordToAudit(AuditEntry entry) {
        auditRepository.save(entry);
        auditRepository.flush();
    }

    private Client getClientForAccount() {
        AbstractCurrentUser user = userService.findCurrentUser();
        Account account = user.getAccount();
        if (null != account) {
            return account.getSystemSettings().isEmpty() ?
                null :
                new Client(account.getSystemSettings().get(0));
        }
        return null;
    }

    private String getGroupSetName(Object groupSetId) {    	
        return "GroupSet: " + client.getGroupSetNames().get(groupSetId);
    }

    private String getVmName(Object vmId) {
    	for(Entry<Long, Map<String, String>>  currEntry : client.getVmNamesAllClusters().entrySet()){
    		if(currEntry.getValue().get(vmId) != null){
    			return "VM: " + client.getVmNamesAllClusters().get(vmId); 
    		}
    	}
        return null;
    }

    private String getCgName(Object cgId) {
        return "Group: " + client.getGroupNames().get(cgId);
    }
    
    private String getCopyName(Object copyId) {
        return "Copy: " + copyId;
    }
    
    private String getClusterName(Object clusterId) {
    	AbstractCurrentUser user = userService.findCurrentUser();
        Account account = user.getAccount();
        String clusterFriendlyName = null;
        if(account != null){
        	SystemSettings system = systemsDataService.findByAccount(account).get(0);
        	Map<String, ClusterSettings> nameToFriendlyClusterNamesMap = system.getNameToClusterMap();
        	String clusterName = client.getClusterNames().get(clusterId);
        	clusterFriendlyName = nameToFriendlyClusterNamesMap.get(clusterName).getFriendlyName();
        }
    	
        return "Cluster: " + clusterFriendlyName;
    }
}
