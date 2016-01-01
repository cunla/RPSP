package com.emc.rpsp.infra.common.packages.service;

import java.util.List;

import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.packages.domain.PackageDefinition;

public interface PackagesDataService {
	public List<PackageDefinition> findAll();	
	public PackageDefinition findPackageById(Long id);
	public List<PackageDefinition> findPackagesByAccount(Account account);
}
