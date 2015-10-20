package com.emc.rpsp.recover.service.impl;

import org.springframework.stereotype.Service;

import com.emc.rpsp.core.service.impl.BaseServiceImpl;
import com.emc.rpsp.fal.Client;
import com.emc.rpsp.recover.service.GroupSetRecoverService;

@Service
public class GroupSetRecoverServiceImpl extends BaseServiceImpl implements GroupSetRecoverService {

	@Override
	public void recoverProduction(Long clusterId, Long groupSetId) {
		Client client = getClient();
    	if(client != null){
            client.recoverProductionForGroupSetSubset(clusterId, groupSetId);
    	}
	}

}
