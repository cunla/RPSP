package com.emc.rpsp.dataloader.service;

import com.emc.rpsp.dataloader.domain.InternalData;

public interface DataLoaderService {
    public InternalData getInternalData(Boolean includeVirtualConfig);
    public InternalData populateInternalData(InternalData internalData);
    public String getInternalDataTemplate();
    public void deleteInternalData();
}
