package com.emc.rpsp.protect.service;

import com.emc.rpsp.accounts.domain.Account;


public interface ProtectService {
	public void addVmToCG(String vmId, Long groupId);
	public void removeVmsFromCG(String vmId, Long groupId);
}
