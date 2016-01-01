package com.emc.rpsp.infra.sqlplugin.accounts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.accounts.repository.AccountRepository;
import com.emc.rpsp.infra.common.accounts.service.AccountsDataService;

@Service
public class AccountsDataServiceSqlImpl implements AccountsDataService {
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public List<Account> findAll() {
		List<Account> accounts = accountRepository.findAll();
		return accounts;
	}

}
