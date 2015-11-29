package com.emc.rpsp.config.auditing;

import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.config.auditing.annotations.RpspAuditObject;
import com.emc.rpsp.config.auditing.annotations.RpspAuditSubject;
import com.emc.rpsp.config.auditing.annotations.RpspAudited;
import com.emc.rpsp.config.auditing.rp4vm.Rp4vmAuditTypesHandler;
import com.emc.rpsp.fal.Client;
import com.emc.rpsp.infra.common.auth.domain.CurrentUser;
import com.emc.rpsp.rpsystems.SystemSettings;
import com.emc.rpsp.users.service.UserService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by morand3 on 8/30/2015.
 */

@Aspect public class AuditAspect {
    private final Logger log = LoggerFactory.getLogger(AuditAspect.class);

    @Autowired private AuditRepository auditRepository;
    @Autowired private UserService userService;

    @Around("@annotation(com.emc.rpsp.config.auditing.annotations.RpspAudited)")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Date date = new Date();
        if (log.isDebugEnabled()) {
            log.debug("Enter: {}.{}() with argument[s] = {}",
            joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(),
            Arrays.toString(joinPoint.getArgs()));
        }
        try {
            Object result = joinPoint.proceed();
            writeAuditToDb(date, joinPoint, result);
            if (log.isDebugEnabled()) {
                log.debug("Exit: {}.{}() with result = {}",
                joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(),
                result);
            }
            return result;
        } catch (IllegalArgumentException e) {
            writeAuditToDb(date, joinPoint, "Exception" + e.getMessage());
            log.error("Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
            joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());

            throw e;
        }
    }

    @Transactional(value = "auditTransactionManager")
    private void writeAuditToDb(Date date, ProceedingJoinPoint joinPoint, Object result) {
        CurrentUser user = userService.findCurrentUser();
        String username = user.getUser().getLogin();
        //TODO change to support multiple systems per account
        Client client = getClientForAccount(user);
        Rp4vmAuditTypesHandler auditHandler = new Rp4vmAuditTypesHandler(client);
        AuditEntry auditEntry = auditHandler.getAuditEntry(date, username, joinPoint, result);
        auditRepository.save(auditEntry);
        auditRepository.flush();
    }

    private Client getClientForAccount(CurrentUser user) {
        Account account = user.getAccount();
        if (null != account) {
            SystemSettings systemSettings = account.getSystemSettings().get(0);
            return account.getSystemSettings().isEmpty() ?
            null :
            new Client(account.getSystemSettings().get(0));
        }
        return null;
    }

}
