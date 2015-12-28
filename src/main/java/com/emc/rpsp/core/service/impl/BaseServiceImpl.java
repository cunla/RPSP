package com.emc.rpsp.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.core.service.BaseService;
import com.emc.rpsp.fal.Client;
import com.emc.rpsp.infra.common.accounts.service.AccountsDataService;
import com.emc.rpsp.infra.common.auth.domain.AbstractCurrentUser;
import com.emc.rpsp.infra.common.systems.service.SystemsDataService;
import com.emc.rpsp.infra.common.vms.service.VmsDataService;
import com.emc.rpsp.packages.domain.PackageConfig;
import com.emc.rpsp.rpsystems.ClusterSettings;
import com.emc.rpsp.rpsystems.SystemSettings;
import com.emc.rpsp.users.service.UserService;
import com.emc.rpsp.vms.domain.VmOwnership;

@Service
public class BaseServiceImpl implements BaseService{
	
	@Autowired 
	private UserService userService = null;
	
	@Autowired
	private AccountsDataService accountsDataService = null;
	
	@Autowired
	private SystemsDataService systemsDataService = null;
	
	@Autowired
	private VmsDataService vmsDataService = null;
	
	
	@Override
	public Client getClient() {
		Account account = userService.findCurrentUser().getAccount();		
		Client client = null;
		if(account != null){
			List<SystemSettings> systemSettings = findSystemsByAccount(account);
			client = new Client(systemSettings.get(0));
		}
		return client;
	}
	
	
	@Override
	public AbstractCurrentUser getCurrentUser() {
		AbstractCurrentUser currentUser = userService.findCurrentUser();
		return currentUser;
	}
		

	@Override
	public List<Account> findAllAccounts() {
		return accountsDataService.findAll();
	}
	
	
	@Override
	public List<PackageConfig> findAccountConfigsByAccount(Account account) {
		return accountsDataService.findAccountConfigsByAccount(account);
	}

	@Override
	public List<SystemSettings> findAllSystems() {
		return systemsDataService.findAll();
	}

	@Override
	public List<SystemSettings> findSystemsByAccount(Account account) {
		return systemsDataService.findByAccount(account);
	}
	
	public List<ClusterSettings> findClustersBySystem(SystemSettings systemSettings){
		return systemsDataService.findClustersBySystem(systemSettings);
	}

	@Override
	public List<VmOwnership> findAllVms() {
		return vmsDataService.findAll();
	}

	@Override
	public List<VmOwnership> findVmsByAccount(Account account) {
		return vmsDataService.findByAccount(account);
	}

}
