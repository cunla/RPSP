package com.emc.rpsp.config.auditing.rp4vm;

import com.emc.rpsp.config.auditing.AuditEntry;
import com.emc.rpsp.config.auditing.RpspAuditException;
import com.emc.rpsp.config.auditing.cache.AuditedMethodDescriptor;
import com.emc.rpsp.config.auditing.cache.AuditingCache;
import com.emc.rpsp.fal.Client;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import javax.persistence.criteria.CriteriaBuilder;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by morand3 on 11/25/2015.
 */
public class Rp4vmAuditTypesHandler {
    private Client client;

    public Rp4vmAuditTypesHandler(Client client) {
        this.client = client;
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
        if (null == client) {
            return paramType + paramValue;
        }
        if ("cg".equals(paramType)) {
            return getCgName(paramValue);
        } else if ("vm".equals(paramType)) {
            return getVmName(paramValue);
        } else if ("groupSet".equals(paramType)) {
            return getGroupSetName(paramValue);
        }
        throw new RpspAuditException("Couldn't get text for audit type {" + paramType + "}");
    }

    private String getGroupSetName(Object groupSetId) {
        return "groupSet: " + groupSetId;
    }

    private String getVmName(Object vmId) {
        return "VM: " + vmId;
    }

    private String getCgName(Object cgId) {
        return "CG: " + cgId;
    }
}
