package com.emc.rpsp.config.auditing;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by morand3 on 11/16/2015.
 */
@RepositoryRestResource(collectionResourceRel = "audit", path = "audit")
public interface AuditRepository extends CrudRepository<AuditEntry, Long> {
}
