package com.emc.rpsp.config.auditing.annotations;

import java.lang.annotation.*;

/**
 * Created by morand3 on 11/23/2015.
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RpspAuditObject {
    String value();
}
