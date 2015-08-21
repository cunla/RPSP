package com.emc.rpsp.imageaccess.service.impl;

import org.springframework.stereotype.Service;

import com.emc.rpsp.core.service.impl.BaseServiceImpl;
import com.emc.rpsp.fal.Client;
import com.emc.rpsp.imageaccess.service.GroupCopiesImageAccessService;
import com.emc.rpsp.vmstructure.domain.CopySnapshot;

@Service public class GroupCopiesImageAccessServiceImpl extends BaseServiceImpl implements GroupCopiesImageAccessService {


    @Override public void enableLatestImageAccess(Long clusterId, Long groupId, Integer copyId) {
    	Client client = getClient();
    	if(client != null){
    		client.enableLatestImageAccess(clusterId, groupId, copyId);
    	}
    }

    @Override public void enableSnapshotImageAccess(Long clusterId, Long groupId, int copyId,
    CopySnapshot copySnapshot) {
    	Client client = getClient();
    	if(client != null){
    		client.enableSnapshotImageAccess(clusterId, groupId, copyId, copySnapshot);
    	}
    }

    @Override public void disableImageAccess(Long clusterId, Long groupId, Integer copyId) {
    	Client client = getClient();
    	if(client != null){
    		client.disableImageAccess(clusterId, groupId, copyId);
    	}
    }

}
