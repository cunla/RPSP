package com.emc.rpsp.protect.service;



public interface GroupsProtectionService {
	public void addVmToCG(String vmId, Long groupId, boolean isCritical, int sequenceNumber);
	public void removeVmsFromCG(String vmId, Long groupId);
}
