package com.emc.rpsp.editcg.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emc.rpsp.core.service.impl.BaseServiceImpl;
import com.emc.rpsp.editcg.domain.ConsistencyGroupChanges;
import com.emc.rpsp.editcg.service.EditGroupService;
import com.emc.rpsp.fal.Client;
import com.emc.rpsp.groupset.service.GroupSetService;
import com.emc.rpsp.packages.domain.PackageConfig;
import com.emc.rpsp.packages.domain.PackageDefinition;
import com.emc.rpsp.vmstructure.domain.ConsistencyGroup;
import com.emc.rpsp.vmstructure.domain.GroupSet;
import com.emc.rpsp.vmstructure.domain.VmContainer;
import com.emc.rpsp.vmstructure.domain.VmDefinition;

@Service
public class EditGroupServiceImpl extends BaseServiceImpl implements EditGroupService {
	
	@Autowired
	private GroupSetService groupSetService = null;

	
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
    		
    		Map<String, VmDefinition> origVmsMap = origGroup
    													.getVms()
    													.stream()
    													.collect(Collectors.toMap(VmDefinition::getId, v -> v));
    		
    		for(VmDefinition currVmDefinition : modifiedGroup.getVms()){
    			VmDefinition origVm = origVmsMap.get(currVmDefinition.getId());
    			if(origVm == null 
    					|| origVm.isCritical() != currVmDefinition.isCritical()
    							|| origVm.getSequenceNumber() != currVmDefinition.getSequenceNumber()){
    				client.changeVmsPowerUpSequence(currVmDefinition.getId(), 
    													groupId, currVmDefinition.isCritical(), 
    															currVmDefinition.getSequenceNumber());
    			}
    		}
    		
    		
    		handleGroupSetMembership(client, origGroup, modifiedGroup);
    		
    		
    		if(origGroup.isEnableProtection() != modifiedGroup.isEnableProtection()){
    			client.setCgProtectionState(groupId, modifiedGroup.isEnableProtection());
    		}
    		
    		
    		

    	}
		
	}
	
	
	private void handleGroupSetMembership(Client client, ConsistencyGroup origGroup, ConsistencyGroup modifiedGroup){
		GroupSet origGroupsSet = origGroup.getParentGroupSet();
		GroupSet modifiedGroupSet = modifiedGroup.getParentGroupSet();
		if(origGroupsSet == null && modifiedGroupSet == null) {
			return;
		}
		if((origGroupsSet != null && modifiedGroupSet != null)
				&& (origGroupsSet.getId().equals(modifiedGroupSet.getId()))) {
			return;
		}
		//handle source GS
		if(origGroupsSet != null){
			GroupSet groupSetToRemoveFrom = client.getAllGroupSets()
														.stream()
														.filter(gs -> gs.getId().equals(origGroupsSet.getId()))
														.findFirst().get();
			//last group of GS
			if(groupSetToRemoveFrom.getConsistencyGroups().size() == 1){
				client.removeGroupSet(groupSetToRemoveFrom.getId());
			}
			else
			{
				groupSetToRemoveFrom.getConsistencyGroups()
						.removeIf(group -> ((ConsistencyGroup)group).getId().equals(origGroup.getId()));				
				client.updateGroupSet(groupSetToRemoveFrom);
			}
		}
		//handle target GS
		if(modifiedGroupSet != null){
			if(modifiedGroupSet.getId() == null){
    			List<VmContainer> groups = new LinkedList<VmContainer>();
    			groups.add(modifiedGroup);
    			modifiedGroupSet.setConsistencyGroups(groups);
    			groupSetService.createGroupSet(modifiedGroupSet);
			}
			else{
				GroupSet groupSetToAddTo = client.getAllGroupSets()
						.stream()
						.filter(gs -> gs.getId().equals(modifiedGroupSet.getId()))
						.findFirst().get();
				List<VmContainer> groups = new LinkedList<VmContainer>();
    			groups.add(modifiedGroup);
    			groupSetToAddTo.getConsistencyGroups().add(modifiedGroup);
    			client.updateGroupSet(groupSetToAddTo);
			}
		}
	}
	
	

}
