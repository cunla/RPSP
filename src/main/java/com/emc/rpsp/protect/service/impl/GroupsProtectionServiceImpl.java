package com.emc.rpsp.protect.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.core.service.impl.BaseServiceImpl;
import com.emc.rpsp.fal.Client;
import com.emc.rpsp.packages.domain.PackageConfig;
import com.emc.rpsp.protect.service.GroupsProtectionService;

@Service
public class GroupsProtectionServiceImpl extends BaseServiceImpl implements GroupsProtectionService {


	@Override
	public void createConsistencyGroup(String cgName, List<String> vmIds, int rpo, boolean startReplication) {
		Client client = getClient();
    	if(client != null){
    		Account account = getCurrentUser().getAccount();
    		List<PackageConfig> accountConfigs = findPackageConfigsByAccount(account);
    		client.createConsistencyGroup(cgName, vmIds, accountConfigs, rpo, startReplication);
    	}
	}

	@Override
	public void addVmToCG(String vmId, Long groupId, boolean isCritical, int sequenceNumber) {
		Client client = getClient();
    	if(client != null){
    		Account account = getCurrentUser().getAccount();
    		List<PackageConfig> accountConfigs = findPackageConfigsByAccount(account);
    		client.addVmToCG(vmId, groupId, accountConfigs);
            client.changeVmsPowerUpSequence(vmId, groupId, isCritical, sequenceNumber);
    	}
	}

	@Override
	public void removeVmsFromCG(String vmId, Long groupId) {
		Client client = getClient();
    	if(client != null){
    		Account account = getCurrentUser().getAccount();
    		List<PackageConfig> accountConfigs = findPackageConfigsByAccount(account);
    		client.removeVmsFromCG(vmId, groupId, accountConfigs);
    	}


	}





}
