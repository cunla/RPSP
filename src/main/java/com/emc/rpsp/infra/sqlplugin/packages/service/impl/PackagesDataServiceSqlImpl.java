package com.emc.rpsp.infra.sqlplugin.packages.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.infra.common.packages.service.PackagesDataService;
import com.emc.rpsp.packages.domain.PackageDefinition;
import com.emc.rpsp.packages.repository.PackageDefinitionRepository;

@Service
public class PackagesDataServiceSqlImpl implements PackagesDataService {
	
	@Autowired
	private PackageDefinitionRepository packageDefinitionRepository;

	@Override
	public List<PackageDefinition> findAll() {
		List<PackageDefinition> accounts = packageDefinitionRepository.findAll();
		return accounts;
	}
	
	
	@Override
	public PackageDefinition findPackageById(Long id) {
		return packageDefinitionRepository.findOne(id);
	}


	@Override
	public List<PackageDefinition> findPackagesByAccount(Account account) {
		return account.getPackages();
	}






}
