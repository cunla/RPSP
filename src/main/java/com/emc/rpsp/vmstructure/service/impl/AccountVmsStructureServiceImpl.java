package com.emc.rpsp.vmstructure.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emc.fapi.jaxws.ConsistencyGroupCopyUID;
import com.emc.fapi.jaxws.ConsistencyGroupSettings;
import com.emc.fapi.jaxws.FullRecoverPointSettings;
import com.emc.fapi.jaxws.VmReplicationSetSettings;
import com.emc.fapi.jaxws.VmReplicationSettings;
import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.fal.Client;
import com.emc.rpsp.rpsystems.SystemSettings;
import com.emc.rpsp.users.service.UserService;
import com.emc.rpsp.vms.domain.VmOwnership;
import com.emc.rpsp.vmstructure.domain.AccountVmsStructure;
import com.emc.rpsp.vmstructure.domain.ClusterDefinition;
import com.emc.rpsp.vmstructure.domain.ConsistencyGroup;
import com.emc.rpsp.vmstructure.domain.VmContainer;
import com.emc.rpsp.vmstructure.domain.VmDefinition;
import com.emc.rpsp.vmstructure.service.AccountVmsStructureService;

@Service
public class AccountVmsStructureServiceImpl implements
		AccountVmsStructureService {
	
	
	@Autowired
	private UserService userService = null;

	
	@Override
	public AccountVmsStructure getAccountVmsStrucure() {
		AccountVmsStructure accountVmsStructure = new AccountVmsStructure();
		Account account = userService.findCurrentUser().getUser().getAccount();
		if(account != null){
			SystemSettings rpSystem = account.getSystemSettings();
			Client client = new Client(rpSystem);
			accountVmsStructure = getAccountVmsStrucure(client, account);
		}
		return accountVmsStructure;
	}

	
	private AccountVmsStructure getAccountVmsStrucure(Client client, Account account){
		
		AccountVmsStructure accountVmsStructure = new AccountVmsStructure();
		List<VmContainer> protectedVms = new LinkedList<VmContainer>();
		accountVmsStructure.setProtectedVms(protectedVms);
		
		FullRecoverPointSettings rpSettings = client.getFullRecoverPointSettings();
		
		Map<String, VmOwnership> vmsMap = getVmsMap(account);
		Map<Long, String> clusterNames = client.getClusterNames();
		Map<Long, Map<String, String>> vmNamesAllClusters = client.getVmNamesAllClusters();


		List<ConsistencyGroupSettings> groupSettingsList = rpSettings
		        .getGroupsSettings();
		for (ConsistencyGroupSettings groupSettings : groupSettingsList) {
			
			ConsistencyGroup consistencyGroup = new ConsistencyGroup();
			String groupId = groupSettings.getGroupUID().toString();
			String groupName = groupSettings.getName();			
			consistencyGroup.setId(groupId);
			consistencyGroup.setName(groupName);
			
			
			
			List<VmReplicationSetSettings> vmReplicationSetSettingsList = groupSettings
			        .getVmReplicationSetsSettings();
			
			ClusterDefinition productionCluster = null;
			List<ClusterDefinition> replicaClusters = new LinkedList<ClusterDefinition>();
			consistencyGroup.setReplicaClusters(replicaClusters);
			List<VmDefinition> vmsList = new LinkedList<VmDefinition>();
			consistencyGroup.setVms(vmsList);
			
			
			
			for (VmReplicationSetSettings vmReplicationSet : vmReplicationSetSettingsList) {
				
				
				List<VmReplicationSettings> vmReplicationSettingsList = vmReplicationSet
				        .getReplicatedVMs();
				
				
				for (VmReplicationSettings vmReplication : vmReplicationSettingsList) {					
					String vmId = vmReplication.getVmUID().getUuid();
					ConsistencyGroupCopyUID copyId = vmReplication.getGroupCopyUID();
					Long clusterId = copyId.getGlobalCopyUID().getClusterUID().getId();
					String clusterName = clusterNames.get(clusterId);
					String vmName = vmNamesAllClusters.get(clusterId).get(vmId);
					List<ConsistencyGroupCopyUID> production = groupSettings.getProductionCopiesUID();
					//this vm belongs to production
					if (production.contains(copyId)) {
						//process vm only if it belongs to account
						if(vmsMap.get(vmId) != null){
							vmsMap.remove(vmId);
							VmDefinition currVm = new VmDefinition(vmId, vmName);
							vmsList.add(currVm);
							productionCluster = new ClusterDefinition(clusterId.toString(), clusterName);
							consistencyGroup.setProductionCluster(productionCluster);
						}
					} 
					//this vm belongs to replica					
					else {
						ClusterDefinition replicaCluster = new ClusterDefinition(clusterId.toString(), clusterName);
						replicaClusters.add(replicaCluster);
					}
					
				}	
				
			}
			
			if(!consistencyGroup.getVms().isEmpty()){
				protectedVms.add(consistencyGroup);
			}
		}
		List<VmDefinition> unprotectedVms = getVmDefinitionsList(vmsMap);
		accountVmsStructure.setUnprotectedVms(unprotectedVms);
		return accountVmsStructure;
	}
	
	
	private Map<String, VmOwnership> getVmsMap(Account account){
		List<VmOwnership> vms = account.getVms();
		Map<String, VmOwnership> vmsMap = vms.stream().collect(Collectors.toMap(VmOwnership::getVmId, (p) -> p));
		return vmsMap;
	}
	
	
	private List<VmDefinition> getVmDefinitionsList(Map<String, VmOwnership> vmsMap){
		List<VmDefinition> vmsList = new LinkedList<VmDefinition>();
		if(vmsMap != null && !vmsMap.isEmpty()){
			for(String vmId : vmsMap.keySet()){
				VmDefinition vmDefinition = new VmDefinition(vmId, vmsMap.get(vmId).getVmName());
				vmsList.add(vmDefinition);
			}
		}
		return vmsList;
	}

}
