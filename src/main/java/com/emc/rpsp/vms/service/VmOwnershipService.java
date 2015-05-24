package com.emc.rpsp.vms.service;

import java.util.List;

import com.emc.rpsp.vms.domain.VmOwnership;

public interface VmOwnershipService {
	public List<VmOwnership> findAll();
	public VmOwnership findById(Long id);
	public VmOwnership findByVmId(String vmId);
	public VmOwnership create(VmOwnership vmOwnership, Long accountId);
	public List<VmOwnership> bulkCreate(List<VmOwnership> vmOwnership);
	public void delete(Long id);
	
}
