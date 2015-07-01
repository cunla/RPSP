package com.emc.rpsp.imageaccess.service;

import com.emc.rpsp.vmstructure.domain.CopySnapshot;

public interface GroupCopiesImageAccessService {
    public void enableLatestImageAccess(Long clusterId, Long groupId, Integer copyId);

    public void disableImageAccess(Long clusterId, Long groupId, Integer copyId);

    public void enableSnapshotImageAccess(Long clusterId, Long groupId, int copyId,
    CopySnapshot copySnapshot);
}
