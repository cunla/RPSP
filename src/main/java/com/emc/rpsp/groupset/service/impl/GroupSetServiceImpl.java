package com.emc.rpsp.groupset.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emc.rpsp.core.service.impl.BaseServiceImpl;
import com.emc.rpsp.fal.Client;
import com.emc.rpsp.groupset.service.GroupSetService;
import com.emc.rpsp.vmstructure.domain.GroupSet;

@Service
public class GroupSetServiceImpl extends BaseServiceImpl implements GroupSetService {
	
	
	@Override
	public void createGroupSet(GroupSet groupSet) {		
		Client client = getClient();
    	if(client != null){
    		client.createGroupSet(groupSet);
    	}		
	}

	@Override
	public List<GroupSet> getAllGroupSets() {
		List<GroupSet> res = null;
		Client client = getClient();
    	if(client != null){
    		res = client.getAllGroupSets();
    	}
    	return res;
	}

	@Override
	public void updateGroupSet(GroupSet groupSet) {
		Client client = getClient();
    	if(client != null){
    		client.updateGroupSet(groupSet);
    	}			
	}

	@Override
	public void removeGroupSet(String groupSetId) {
		Client client = getClient();
    	if(client != null){
    		client.removeGroupSet(groupSetId);
    	}	
		
	}


}
