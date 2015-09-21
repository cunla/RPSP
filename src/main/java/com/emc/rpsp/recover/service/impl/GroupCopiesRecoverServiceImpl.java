package com.emc.rpsp.recover.service.impl;

import org.springframework.stereotype.Service;

import com.emc.rpsp.core.service.impl.BaseServiceImpl;
import com.emc.rpsp.fal.Client;
import com.emc.rpsp.recover.service.GroupCopiesRecoverService;

@Service
public class GroupCopiesRecoverServiceImpl extends BaseServiceImpl implements GroupCopiesRecoverService {

	@Override
	public void recoverProduction(Long clusterId, Long groupId, int copyId) {
		Client client = getClient();
    	if(client != null){
            client.recoverProduction(clusterId, groupId, copyId);
    	}
	}

}
