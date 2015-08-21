package com.emc.rpsp.core.service;

import java.util.List;

import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.accounts.domain.AccountConfig;
import com.emc.rpsp.fal.Client;
import com.emc.rpsp.infra.common.auth.domain.AbstractCurrentUser;
import com.emc.rpsp.rpsystems.SystemSettings;
import com.emc.rpsp.vms.domain.VmOwnership;

public interface BaseService {
	public Client getClient();
	public AbstractCurrentUser getCurrentUser();	
	public List<Account> findAllAccounts();
	public List<AccountConfig> findAccountConfigsByAccount(Account account);
	public List<SystemSettings> findAllSystems();
	public List<SystemSettings> findSystemsByAccount(Account account);
	public List<VmOwnership> findAllVms();
	public List<VmOwnership> findVmsByAccount(Account account);
}
