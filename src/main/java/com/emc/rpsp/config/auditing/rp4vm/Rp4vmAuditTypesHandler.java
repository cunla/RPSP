package com.emc.rpsp.config.auditing.rp4vm;

import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.config.auditing.AuditConsts;
import com.emc.rpsp.config.auditing.AuditEntry;
import com.emc.rpsp.config.auditing.AuditRepository;
import com.emc.rpsp.config.auditing.AuditTypesHandler;
import com.emc.rpsp.config.auditing.cache.AuditedMethodDescriptor;
import com.emc.rpsp.config.auditing.cache.AuditingCache;
import com.emc.rpsp.infra.common.auth.domain.AbstractCurrentUser;
import com.emc.rpsp.users.service.UserService;
import com.emc.rpsp.vmstructure.domain.*;
import com.emc.rpsp.vmstructure.service.AccountVmsStructureService;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by morand3 on 11/25/2015.
 */
public class Rp4vmAuditTypesHandler implements AuditTypesHandler {
    @Autowired
    private AuditRepository auditRepository;
    @Autowired
    private UserService userService;

    @Autowired
    private AccountVmsStructureService accountVmsStructureService = null;

    private Map<Long, AccountVmsStructure> accountIdToStructureMap =
        new HashMap<Long, AccountVmsStructure>();


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

    @SuppressWarnings("unchecked")
    public String getAuditText(String paramType, Object paramValue) {
        if (AuditConsts.CG.equals(paramType)) {
            return "Group: " + getCgName(paramValue);
        }
        if (AuditConsts.VM.equals(paramType)) {
            return "VM: " + getVmName(paramValue);
        }
        if (AuditConsts.GS.equals(paramType)) {
            return "GroupSet: " + getGroupSetName(paramValue);
        }
        if (AuditConsts.COPY.equals(paramType)) {
            return getCopyName(paramValue);
        }
        if (AuditConsts.CLUSTER.equals(paramType)) {
            return "Cluster: " + getClusterName(paramValue);
        }
        if (AuditConsts.BOOKMARK_PARAMS.equals(paramType)) {
            return "Bookmark: " + ((Map<String, String>) paramValue).get("name");
        }
        if (AuditConsts.ADD_VM_TO_CG_PARAMS.equals(paramType)) {
            return "VM: " + getVmName(((Map<String, String>) paramValue).get("id"));
        }
        if (AuditConsts.CREATE_CG_SUBJ_PARAMS.equals(paramType)) {
            Map<String, Object> params = (Map<String, Object>) paramValue;
            return "Group: " + params.get("groupName").toString();
        }
        if (AuditConsts.CREATE_CG_OBJ_PARAMS.equals(paramType)) {
            Map<String, Object> params = (Map<String, Object>) paramValue;
            List<Object> vmIdsObj = (List<Object>) params.get("vms");
            List<String> vmIds = new LinkedList<String>();
            vmIdsObj.forEach((obj) -> vmIds.add(String.valueOf(obj)));
            String res = "VMS:";
            for (String vmId : vmIds) {
                res += " " + getVmName(vmId);
            }
            return res;
        }
        if (AuditConsts.DR_TEST_RESULT.equals(paramType)
            || AuditConsts.DISABLE_DR_TEST_RESULT.equals(paramType)
            || AuditConsts.CREATE_BOOKMARK_RESULT.equals(paramType)
            || AuditConsts.FAILOVER_RESULT.equals(paramType)
            || AuditConsts.RECOVER_PRODUCTION_RESULT.equals(paramType)
            || AuditConsts.CREATE_CG_RESULT.equals(paramType)
            || AuditConsts.ADD_VM_TO_CG_RESULT.equals(paramType)
            || AuditConsts.REMOVE_VM_FROM_CG_RESULT.equals(paramType)) {
            ResponseEntity<HttpStatus> response = (ResponseEntity<HttpStatus>) paramValue;
            return response.getStatusCode().name();
        }

        return paramType + paramValue;

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

/*    private Client getClientForAccount() {
        AbstractCurrentUser user = userService.findCurrentUser();
        Account account = user.getAccount();
        if (null != account) {
            return account.getSystemSettings().isEmpty() ?
                null :
                new Client(account.getSystemSettings().get(0));
        }
        return null;
    }*/

    private AccountVmsStructure getAccountVmsStructure() {
        AccountVmsStructure res = null;
        AbstractCurrentUser user = userService.findCurrentUser();
        Account account = user.getAccount();
        if (accountIdToStructureMap.get(account.getId()) == null) {
            updateAccountVmsStructure();
        }
        res = accountIdToStructureMap.get(account.getId());
        return res;
    }


    private void updateAccountVmsStructure() {
        AbstractCurrentUser user = userService.findCurrentUser();
        Account account = user.getAccount();
        AccountVmsStructure accountVmsStructure = accountVmsStructureService.getAccountVmsStrucure();
        accountIdToStructureMap.put(account.getId(), accountVmsStructure);
    }


    private String getGroupSetName(Object groupSetId) {
        String groupSetName = null;
        GroupSet groupSet = getGroupSetData(groupSetId);
        if (groupSet == null) {
            updateAccountVmsStructure();
        }
        groupSet = getGroupSetData(groupSetId);
        if (groupSet != null) {
            groupSetName = groupSet.getName();
        }
        return groupSetName;
    }


    private GroupSet getGroupSetData(Object groupSetId) {
        AccountVmsStructure accountVmsStructure = getAccountVmsStructure();
        for (VmContainer currVmContainer : accountVmsStructure.getProtectedVms()) {
            if (currVmContainer instanceof GroupSet) {
                GroupSet currGs = (GroupSet) currVmContainer;
                if (currGs.getId().equals(groupSetId.toString())) {
                    return currGs;
                }
            }
        }
        return null;
    }


    private String getVmName(Object vmId) {
        String vmName = null;
        VmDefinition vmDefinition = getVmData(vmId);
        if (vmDefinition == null) {
            updateAccountVmsStructure();
        }
        vmDefinition = getVmData(vmId);
        if (vmDefinition != null) {
            vmName = vmDefinition.getName();
        }
        return vmName;
    }

    private VmDefinition getVmData(Object vmId) {
        AccountVmsStructure accountVmsStructure = getAccountVmsStructure();
        for (VmDefinition currVmdeDefinition : accountVmsStructure.getUnprotectedVms()) {
            if (currVmdeDefinition.getId().equals(vmId)) {
                return currVmdeDefinition;
            }
        }
        for (VmContainer currVmContainer : accountVmsStructure.getProtectedVms()) {
            //CG
            if (currVmContainer instanceof ConsistencyGroup) {
                List<VmDefinition> vms = ((ConsistencyGroup) currVmContainer).getVms();
                for (VmDefinition currVmdeDefinition : vms) {
                    if (currVmdeDefinition.getId().equals(vmId)) {
                        return currVmdeDefinition;
                    }
                }
            } else {
                GroupSet currGs = (GroupSet) currVmContainer;
                List<VmContainer> groups = currGs.getConsistencyGroups();
                for (VmContainer currCg : groups) {
                    List<VmDefinition> vms = ((ConsistencyGroup) currCg).getVms();
                    for (VmDefinition currVmdeDefinition : vms) {
                        if (currVmdeDefinition.getId().equals(vmId)) {
                            return currVmdeDefinition;
                        }
                    }
                }
            }

        }
        return null;
    }


    private String getCgName(Object cgId) {
        String cgName = null;
        ConsistencyGroup cg = getCgData(cgId);
        if (cg == null) {
            updateAccountVmsStructure();
        }
        cg = getCgData(cgId);
        if (cg != null) {
            cgName = cg.getName();
        }
        return cgName;
    }


    private ConsistencyGroup getCgData(Object cgId) {
        AccountVmsStructure accountVmsStructure = getAccountVmsStructure();

        for (VmContainer currVmContainer : accountVmsStructure.getProtectedVms()) {
            //CG
            if (currVmContainer instanceof ConsistencyGroup) {
                ConsistencyGroup currCg = (ConsistencyGroup) currVmContainer;
                if (currCg.getId().equals(cgId.toString())) {
                    return currCg;
                }
            }
            //Nested CG
            else {
                GroupSet currGs = (GroupSet) currVmContainer;
                List<VmContainer> groups = currGs.getConsistencyGroups();
                for (VmContainer currCg : groups) {
                    ConsistencyGroup currNestedCg = (ConsistencyGroup) currCg;
                    if (currNestedCg.getId().equals(cgId.toString())) {
                        return currNestedCg;
                    }
                }
            }

        }
        return null;
    }


    private String getClusterName(Object clusterId) {
        String clusterName = null;
        ClusterDefinition clusterDefinition = getClusterData(clusterId);
        if (clusterDefinition == null) {
            updateAccountVmsStructure();
        }
        clusterDefinition = getClusterData(clusterId);
        if (clusterDefinition != null) {
            clusterName = clusterDefinition.getName();
        }
        return clusterName;
    }


    private ClusterDefinition getClusterData(Object clusterId) {
        AccountVmsStructure accountVmsStructure = getAccountVmsStructure();
        SystemInfo sysInfo = accountVmsStructure.getSystemInfo();
        if (sysInfo.getProductionCluster().getId().equals(clusterId.toString())) {
            return sysInfo.getProductionCluster();
        } else {
            for (ClusterDefinition currReplicaCluster : sysInfo.getReplicaClusters()) {
                if (currReplicaCluster.getId().equals(clusterId.toString())) {
                    return currReplicaCluster;
                }
            }
        }
        return null;
    }


    private String getCopyName(Object copyId) {
        return "Copy: " + copyId;
    }
}
