package com.emc.rpsp.protect.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.core.service.impl.BaseServiceImpl;
import com.emc.rpsp.fal.Client;
import com.emc.rpsp.packages.domain.PackageConfig;
import com.emc.rpsp.packages.domain.PackageDefinition;
import com.emc.rpsp.protect.service.GroupsProtectionService;

@Service
public class GroupsProtectionServiceImpl extends BaseServiceImpl implements GroupsProtectionService {


	@Override
	public void createConsistencyGroup(String cgName, List<String> vmIds, boolean startReplication, long packageId) {
		Client client = getClient();
    	if(client != null){
    		PackageDefinition packageDefinition = findPackageById(packageId);
    		int rpo = packageDefinition.getRpo();
    		List<PackageConfig> packageConfigs = findPackageConfigsByPackageId(packageId);
    		Long groupId = client.createConsistencyGroup(cgName, vmIds, packageConfigs, rpo, startReplication);
    		setGroupPackage(groupId, packageId);
    	}
	}

	@Override
	public void addVmToCG(String vmId, Long groupId, boolean isCritical, int sequenceNumber) {
		Client client = getClient();
    	if(client != null){
    		List<PackageConfig> packageConfigs = obtainGroupPackageConfigs(groupId);
    		client.addVmToCG(vmId, groupId, packageConfigs);
            client.changeVmsPowerUpSequence(vmId, groupId, isCritical, sequenceNumber);
    	}
	}

	@Override
	public void removeVmsFromCG(String vmId, Long groupId) {
		Client client = getClient();
    	if(client != null){
    		List<PackageConfig> packageConfigs = obtainGroupPackageConfigs(groupId);
    		client.removeVmsFromCG(vmId, groupId, packageConfigs);
    	}

	}
	
	private List<PackageConfig> obtainGroupPackageConfigs(Long groupId){
		Client client = getClient();
		List<PackageConfig> packageConfigs = null;
    	if(client != null){
    		Long packageId = getGroupPackage(groupId);    		
    		if(packageId != null){
    			packageConfigs = findPackageConfigsByPackageId(packageId);
    		}
    		//CG without specific package - fall back on account packages
    		else{
    			Account account = getCurrentUser().getAccount();
        		packageConfigs = findPackageConfigsByAccount(account);
    		}  		
    	}
    	return packageConfigs;
	}





}
