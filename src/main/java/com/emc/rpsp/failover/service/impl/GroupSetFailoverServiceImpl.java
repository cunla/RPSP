package com.emc.rpsp.failover.service.impl;

import org.springframework.stereotype.Service;

import com.emc.rpsp.core.service.impl.BaseServiceImpl;
import com.emc.rpsp.failover.service.GroupSetFailoverService;
import com.emc.rpsp.fal.Client;

@Service
public class GroupSetFailoverServiceImpl extends BaseServiceImpl implements GroupSetFailoverService {

	@Override
	public void failoverGroupSetSubset(Long clusterId, Long groupSetId) {
		Client client = getClient();
    	if(client != null){
            client.failoverGroupSetSubset(clusterId, groupSetId);
    	}
	}

}
