package com.emc.rpsp.config.auditing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by morand3 on 11/16/2015.
 */
@RepositoryRestResource(collectionResourceRel = "audit", path = "audit")
public interface AuditRepository extends JpaRepository<AuditEntry, Long> {
}
