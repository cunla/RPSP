package com.emc.rpsp.failover.service;

public interface GroupCopiesFailoverService {
	public void failOver(Long clusterId, Long groupId, int copyId);
}
