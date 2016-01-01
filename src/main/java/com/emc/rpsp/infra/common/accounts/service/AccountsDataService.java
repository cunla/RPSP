package com.emc.rpsp.infra.common.accounts.service;

import java.util.List;

import com.emc.rpsp.accounts.domain.Account;

public interface AccountsDataService {
	public List<Account> findAll();	
}
