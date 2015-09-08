package com.emc.rpsp.config;

import com.emc.rpsp.config.auditing.AuditAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration @EnableAspectJAutoProxy public class AuditAspectConfiguration {
    @Bean public AuditAspect loggingAspect() {
        return new AuditAspect();
    }
}
