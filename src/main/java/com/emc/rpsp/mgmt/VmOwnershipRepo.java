package com.emc.rpsp.mgmt;

import com.emc.rpsp.rpsystems.SystemSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by morand3 on 4/26/2015.
 */
@RepositoryRestResource(collectionResourceRel = "vmOwner", path = "vmOwner")
public interface VmOwnershipRepo extends JpaRepository<VmOwnership, Long> {

	@Query("select v from VmOwnership v where v.vmId = ?1")
	public VmOwnership findVmOwner(String vmId);
}
