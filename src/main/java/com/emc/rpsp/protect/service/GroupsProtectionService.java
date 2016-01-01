package com.emc.rpsp.protect.service;

import java.util.List;



public interface GroupsProtectionService {
	public void createConsistencyGroup(String cgName, List<String> vmIds, boolean startReplication, long packageId);
	public void addVmToCG(String vmId, Long groupId, boolean isCritical, int sequenceNumber);
	public void removeVmsFromCG(String vmId, Long groupId);
}
