package com.emc.rpsp.virtualconfig.service;

import com.emc.rpsp.virtualconfig.domain.VcenterConfig;

public interface VirtualConfigurationService {

	public VcenterConfig getVirtualConfiguration(Long clusterId);
	
}
