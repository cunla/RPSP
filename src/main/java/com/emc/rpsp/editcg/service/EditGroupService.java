package com.emc.rpsp.editcg.service;

import com.emc.rpsp.editcg.domain.ConsistencyGroupChanges;



public interface EditGroupService {
	
	public void editConsistencyGroup(ConsistencyGroupChanges consistencyGroupChanges);
	
/*	public void createConsistencyGroup(String cgName, List<String> vmIds, boolean startReplication, long packageId);
	public void addVmToCG(String vmId, Long groupId, boolean isCritical, int sequenceNumber);
	public void removeVmsFromCG(String vmId, Long groupId);*/
}
