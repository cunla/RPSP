package com.emc.rpsp.protect.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.core.service.impl.BaseServiceImpl;
import com.emc.rpsp.fal.Client;
import com.emc.rpsp.packages.domain.PackageConfig;
import com.emc.rpsp.packages.domain.PackageDefinition;
import com.emc.rpsp.protect.service.GroupsProtectionService;
import com.emc.rpsp.rpsystems.ClusterSettings;
import com.emc.rpsp.rpsystems.SystemSettings;

@Service
public class GroupsProtectionServiceImpl extends BaseServiceImpl implements GroupsProtectionService {


	@Override
	public void createConsistencyGroup(String cgName, List<String> vmIds, boolean startReplication, long packageId) {
		Client client = getClient();
    	if(client != null){
    		PackageDefinition packageDefinition = findPackageById(packageId);
    		int rpo = packageDefinition.getRpo();
    		List<PackageConfig> packageConfigs = findPackageConfigsByPackageId(packageId);
    		setAdditionalClusterData(client, packageConfigs);
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
	
	private void setAdditionalClusterData(Client client, List<PackageConfig> packageConfigs){
		SystemSettings system = client.getSystemSettings();
		List<ClusterSettings> clusters = findClustersBySystem(system);
		Map<Long, ClusterSettings> clustersMap = clusters.stream()
		        .collect(Collectors.toMap(ClusterSettings::getClusterId, (p) -> p));
		for(PackageConfig currPackageConfig : packageConfigs){
			ClusterSettings clusterSettings = clustersMap.get(currPackageConfig.getClusterId());
			if(clusterSettings != null){
				currPackageConfig.setClusterName(clusterSettings.getClusterName());
				currPackageConfig.setClusterFriendlyName(clusterSettings.getFriendlyName());
			}
		}
	}





}
