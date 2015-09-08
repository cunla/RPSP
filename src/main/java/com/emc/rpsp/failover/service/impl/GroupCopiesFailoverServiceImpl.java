package com.emc.rpsp.failover.service.impl;

import org.springframework.stereotype.Service;

import com.emc.rpsp.core.service.impl.BaseServiceImpl;
import com.emc.rpsp.failover.service.GroupCopiesFailoverService;
import com.emc.rpsp.fal.Client;

@Service
public class GroupCopiesFailoverServiceImpl extends BaseServiceImpl implements GroupCopiesFailoverService {

	@Override
	public void failOver(Long clusterId, Long groupId, int copyId) {
		Client client = getClient();
    	if(client != null){
            client.failOver(clusterId, groupId, copyId);
    	}
	}

}
