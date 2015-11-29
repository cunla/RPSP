package com.emc.rpsp.config.auditing.cache;

import com.emc.rpsp.config.auditing.annotations.RpspAuditObject;
import com.emc.rpsp.config.auditing.annotations.RpspAuditResult;
import com.emc.rpsp.config.auditing.annotations.RpspAuditSubject;
import com.emc.rpsp.config.auditing.annotations.RpspAudited;
import javafx.util.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by morand3 on 11/23/2015.
 */
public class AuditedMethodDescriptor {
    private final Logger log = LoggerFactory.getLogger(AuditedMethodDescriptor.class);
    private String name;
    //Map param index -> paramRpspType
    private Map<Integer, String> objects;
    // subject param index -> Rpsp type
    private Pair<Integer, String> subject;
    //result rpsp type
    private String resultType;

    public AuditedMethodDescriptor(Method method) {
        this.name = getActionName(method);
        this.resultType = getResultType(method);
        log.debug("Creating descriptor for {}", this.name);
        this.objects = new HashMap<>();
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < parameters.length; ++i) {
            Parameter parameter = parameters[i];
            String paramName = parameter.getName();
            RpspAuditSubject subjectAnnotation = parameter.getAnnotation(RpspAuditSubject.class);
            if (subjectAnnotation != null) {
                log.debug("Descriptor {}: Added param {} as subject with type {}", this.name,
                paramName, subjectAnnotation.value());
                this.subject = new Pair<>(i, subjectAnnotation.value());
            } else {
                RpspAuditObject objectAnnotation = parameter.getAnnotation(RpspAuditObject.class);
                if (null != objectAnnotation) {
                    log.debug("Descriptor {}: Added param {} as subject with type {}", this.name,
                    paramName, objectAnnotation.value());
                    this.objects.put(i, objectAnnotation.value());
                } else { //No RpspAudit annotation on param
                    log.debug("Descriptor {}: Ignored param {}", this.name, paramName);
                }
            }
        }
    }

    public Integer getSubjectIndex() {
        return subject.getKey();
    }

    public String getSubjectType() {
        return subject.getValue();
    }

    public String getResultType() {
        return resultType;
    }

    public Map<Integer, String> getObjects() {
        return objects;
    }

    public String getAction() {
        return name;
    }

    public boolean hasSubject() {
        return subject != null;
    }

    private static String getActionName(Method method) {
        RpspAudited auditAnnotation = method.getAnnotation(RpspAudited.class);
        String action = auditAnnotation.action();
        if ("".equals(action)) {
            action = method.getName();
        }
        return action;
    }

    private static String getResultType(Method method) {
        RpspAuditResult resultAnnotation = method.getAnnotation(RpspAuditResult.class);
        return (null == resultAnnotation) ? null : resultAnnotation.value();
    }

    public boolean hasResult() {
        return null != resultType;
    }
}
