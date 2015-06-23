package com.emc.rpsp.protect.service;

public interface ProtectService {
	public void addVmToCG(String vmId, Long clusterId, Long groupId);
}
