package com.emc.rpsp.config.auditing;

import com.emc.rpsp.rpsystems.SystemSettings;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by morand3 on 11/16/2015.
 */
public interface AuditRepository extends JpaRepository<SystemSettings, Long> {
}
