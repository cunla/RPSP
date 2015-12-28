package com.emc.rpsp.packages.service;

import java.util.List;

import com.emc.rpsp.packages.domain.PackageDefinition;

public interface PackageDefinitionService {
    public List<PackageDefinition> findAll();

    public PackageDefinition findById(Long id);

    public PackageDefinition create(PackageDefinition packageDef);

    public void delete(Long id);

}
