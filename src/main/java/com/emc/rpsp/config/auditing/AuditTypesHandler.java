package com.emc.rpsp.config.auditing;

import com.emc.rpsp.config.auditing.cache.AuditedMethodDescriptor;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Date;

/**
 * Created by morand3 on 12/3/2015.
 */
public interface AuditTypesHandler {
    public AuditEntry getAuditEntry(Date date, String username, ProceedingJoinPoint joinPoint,
        Object resultValue);

    public String getAuditText(String paramType, Object paramValue);

    public void writeRecordToAudit(Date date, String username, ProceedingJoinPoint joinPoint,
        Object resultValue);
}
