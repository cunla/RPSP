package com.emc.rpsp.imageaccess.service;

import com.emc.rpsp.vmstructure.domain.CopySnapshot;

public interface GroupSetImageAccessService {

    public void disableImageAccessForGroupSetSubset(Long clusterId, Long groupSetId);

    public void enableImageAccessForGroupSetSubset(Long clusterId, Long groupSetId, 
    		CopySnapshot copySnapshot);
}
