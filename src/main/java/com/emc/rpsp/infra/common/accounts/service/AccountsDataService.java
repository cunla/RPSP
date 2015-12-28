package com.emc.rpsp.infra.common.accounts.service;

import java.util.List;

import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.packages.domain.PackageConfig;

public interface AccountsDataService {
	public List<Account> findAll();
	public List<PackageConfig> findPackageConfigsByAccount(Account account);
}
