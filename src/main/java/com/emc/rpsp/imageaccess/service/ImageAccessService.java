package com.emc.rpsp.imageaccess.service;

public interface ImageAccessService {
	public void enableImageAccess(Long clusterId, Long groupId);
	public void disableImageAccess(Long clusterId, Long groupId);
}
