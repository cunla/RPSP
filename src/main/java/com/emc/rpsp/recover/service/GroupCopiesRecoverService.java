package com.emc.rpsp.recover.service;

public interface GroupCopiesRecoverService {
	public void recoverProduction(Long clusterId, Long groupId, int copyId);
}
