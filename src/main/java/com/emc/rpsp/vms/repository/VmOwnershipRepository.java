package com.emc.rpsp.vms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emc.rpsp.vms.domain.VmOwnership;

/**
 * Spring Data JPA repository for the User entity.
 */
public interface VmOwnershipRepository extends JpaRepository<VmOwnership, Long> {
	VmOwnership findOneByVmId(String vmId);
}
