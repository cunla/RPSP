package com.emc.rpsp.groupset.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emc.rpsp.core.service.impl.BaseServiceImpl;
import com.emc.rpsp.fal.Client;
import com.emc.rpsp.groupset.domain.GroupSet;
import com.emc.rpsp.groupset.service.GroupSetService;

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
	public void removeGroupSet(GroupSet groupSet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGroupSet(GroupSet groupSet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<GroupSet> getGroupSets() {
		// TODO Auto-generated method stub
		return null;
	}
	


}
