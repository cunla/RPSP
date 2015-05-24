package com.emc.rpsp.dataloader.service;

import java.util.List;
import java.util.Map;

import com.emc.rpsp.rpsystems.SystemSettings;

public interface DataLoaderService {
	List<SystemSettings> populateInternalData(List<Map<String, Object>> fullSettings);
	public String getInternalDataTemplate();
}
