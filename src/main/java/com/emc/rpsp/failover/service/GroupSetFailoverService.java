package com.emc.rpsp.failover.service;

public interface GroupSetFailoverService {
	public void failoverGroupSetSubset(Long clusterId, Long groupSetId);
}
