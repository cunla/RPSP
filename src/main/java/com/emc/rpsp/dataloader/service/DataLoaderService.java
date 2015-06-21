package com.emc.rpsp.dataloader.service;

import com.emc.rpsp.rpsystems.SystemSettings;

import java.util.List;
import java.util.Map;

public interface DataLoaderService {
    List<SystemSettings> populateInternalData(List<Map<String, Object>> fullSettings);

    public String getInternalDataTemplate();
}
