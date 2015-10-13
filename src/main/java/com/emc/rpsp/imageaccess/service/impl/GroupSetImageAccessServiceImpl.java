package com.emc.rpsp.imageaccess.service.impl;

import org.springframework.stereotype.Service;

import com.emc.rpsp.core.service.impl.BaseServiceImpl;
import com.emc.rpsp.fal.Client;
import com.emc.rpsp.imageaccess.service.GroupSetImageAccessService;
import com.emc.rpsp.vmstructure.domain.CopySnapshot;

@Service
public class GroupSetImageAccessServiceImpl extends BaseServiceImpl implements
		GroupSetImageAccessService {

	@Override
	public void enableImageAccessForGroupSetSubset(Long clusterId, Long groupSetId,
			CopySnapshot copySnapshot) {
		Client client = getClient();
		if (client != null) {
			client.enableImageAccessForGroupSetSubset(clusterId, groupSetId, 
					copySnapshot);
		}
	}

	@Override
	public void disableImageAccessForGroupSetSubset(Long clusterId, Long groupSetId) {
		Client client = getClient();
		if (client != null) {
			client.disableImageAccessForGroupSetSubset(clusterId, groupSetId);
		}
	}

}
