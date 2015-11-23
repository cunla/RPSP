package com.emc.rpsp.config.auditing;

import com.emc.rpsp.config.auditing.annotations.RpspAudited;
import com.emc.rpsp.users.service.UserService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Annotation;
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

    //    @PersistenceContext(unitName = "audit") @Qualifier("auditEmFactory")
    //    private EntityManager entityManager;

    @Around("@annotation(com.emc.rpsp.config.auditing.annotations.RpspAudited)")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Date date = new Date();
        String action = getActionName(joinPoint);
        String subject = getSubjectType(joinPoint);

        if (log.isDebugEnabled()) {
            log.debug("Enter: {}.{}() with argument[s] = {}",
            joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(),
            Arrays.toString(joinPoint.getArgs()));
        }
        try {
            Object result = joinPoint.proceed();
            writeAuditToDb(date, action, Arrays.toString(joinPoint.getArgs()), result.toString());
            if (log.isDebugEnabled()) {
                log.debug("Exit: {}.{}() with result = {}",
                joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(),
                result);
            }
            return result;
        } catch (IllegalArgumentException e) {
            writeAuditToDb(date, action, Arrays.toString(joinPoint.getArgs()),
            "Exception" + e.getMessage());
            log.error("Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
            joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());

            throw e;
        }
    }

    private String getActionName(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        RpspAudited auditAnnotation = method.getAnnotation(RpspAudited.class);
        String action = auditAnnotation.action();
        String subject = getSubjectType(joinPoint);
        if ("".equals(action)) {
            action = signature.getName();
        }
        return action;
    }

    private String getSubjectType(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Parameter[] parameters = method.getParameters();
        Object[] paramValues = joinPoint.getArgs();
        for (int i = 0; i < parameters.length; ++i) {
            Parameter parameter = parameters[i];
            String paramName = parameter.getName();
            String paramValue = paramValues[i].toString();
            Annotation[][] annotations = method.getParameterAnnotations();
            for (Annotation annotation : annotations[i]) {
                String annotationName = annotation.annotationType().getName();

            }
        } return "";
    }


    @Transactional(value = "auditTransactionManager")
    private void writeAuditToDb(Date date, String action, String args, String result) {
        String username = userService.findCurrentUser().getUsername();
        AuditEntry auditEntry = new AuditEntry(date, username, action, args, result);
        auditRepository.save(auditEntry);
        //        auditRepository.flush();
    }

}
