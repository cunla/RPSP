package com.emc.rpsp.core.service;

import java.util.List;

import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.fal.Client;
import com.emc.rpsp.infra.common.auth.domain.AbstractCurrentUser;
import com.emc.rpsp.packages.domain.PackageConfig;
import com.emc.rpsp.packages.domain.PackageDefinition;
import com.emc.rpsp.rpsystems.SystemSettings;
import com.emc.rpsp.vms.domain.VmOwnership;

public interface BaseService {
	public Client getClient();
	public AbstractCurrentUser getCurrentUser();	
	public List<Account> findAllAccounts();
	public List<SystemSettings> findAllSystems();
	public List<SystemSettings> findSystemsByAccount(Account account);
	public List<VmOwnership> findAllVms();
	public List<VmOwnership> findVmsByAccount(Account account);
	public List<PackageConfig> findPackageConfigsByAccount(Account account);
	public List<PackageConfig> findPackageConfigsByPackageId(Long id);
	public PackageDefinition findPackageById(Long id);
	public List<PackageDefinition> findPackagesByAccount(Account account);
}
