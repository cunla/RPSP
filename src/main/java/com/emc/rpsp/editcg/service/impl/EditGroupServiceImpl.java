package com.emc.rpsp.editcg.service.impl;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.emc.rpsp.core.service.impl.BaseServiceImpl;
import com.emc.rpsp.editcg.domain.ConsistencyGroupChanges;
import com.emc.rpsp.editcg.service.EditGroupService;
import com.emc.rpsp.fal.Client;
import com.emc.rpsp.packages.domain.PackageConfig;
import com.emc.rpsp.packages.domain.PackageDefinition;
import com.emc.rpsp.vmstructure.domain.ConsistencyGroup;
import com.emc.rpsp.vmstructure.domain.VmDefinition;

@Service
public class EditGroupServiceImpl extends BaseServiceImpl implements EditGroupService {

	
	@Override
	public void editConsistencyGroup(
			ConsistencyGroupChanges consistencyGroupChanges) {
		
		Client client = getClient();
    	if(client != null){   	
    		
    		ConsistencyGroup origGroup = consistencyGroupChanges.getOriginalConsistencyGroup();
    		ConsistencyGroup modifiedGroup = consistencyGroupChanges.getCurrentConsistencyGroup();
    		Long groupId = Long.parseLong(modifiedGroup.getId());
    		Long packageId = Long.parseLong(modifiedGroup.getPackageId());
    		List<PackageConfig> packageConfigs = findPackageConfigsByPackageId(packageId);
    		
    		if(!origGroup.getName().equals(modifiedGroup.getName())){
    			client.renameGroup(groupId, modifiedGroup.getName());
    		}
    		if(!origGroup.getPackageName().equals(modifiedGroup.getPackageName())){
    			client.setGroupPackage(groupId, packageId);
    			PackageDefinition packageDefinition = findPackageById(packageId);
    			int rpo = packageDefinition.getRpo();
    			client.setRpoPolicy(groupId, rpo, packageDefinition);
    		}    		
    		for(VmDefinition currVmDefinition : modifiedGroup.getVms()){
    			Stream<VmDefinition> origVmsStream = origGroup.getVms().stream();
    			boolean isNewVm = origVmsStream.noneMatch(vm -> vm.getId().equals(currVmDefinition.getId()));
    			if(isNewVm){
    				client.addVmToCG(currVmDefinition.getId(), groupId, packageConfigs);
    			}
    		}
    		for(VmDefinition currVmDefinition : origGroup.getVms()){
    			Stream<VmDefinition> modifiedVmsStream = modifiedGroup.getVms().stream();
    			boolean isDeletedVm = modifiedVmsStream.noneMatch(vm -> vm.getId().equals(currVmDefinition.getId()));
    			if(isDeletedVm){
    				client.removeVmsFromCG(currVmDefinition.getId(), groupId, packageConfigs);
    			}
    		}
    	}
		
	}


	/*@Override
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
    		if(packageConfigs == null){
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
*/




}
