package com.emc.rpsp.config.auditing;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by morand3 on 8/30/2015.
 */
@Target(value = ElementType.METHOD) @Retention(RetentionPolicy.RUNTIME)
public @interface RpspAudited {
}
