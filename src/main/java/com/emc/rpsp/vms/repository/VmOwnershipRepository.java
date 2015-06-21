package com.emc.rpsp.vms.repository;

import com.emc.rpsp.vms.domain.VmOwnership;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the User entity.
 */
public interface VmOwnershipRepository extends JpaRepository<VmOwnership, Long> {
    VmOwnership findOneByVmId(String vmId);
}
