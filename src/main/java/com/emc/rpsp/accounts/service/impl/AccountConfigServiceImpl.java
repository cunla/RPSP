package com.emc.rpsp.accounts.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.accounts.domain.AccountConfig;
import com.emc.rpsp.accounts.repository.AccountConfigsRepository;
import com.emc.rpsp.accounts.repository.AccountRepository;
import com.emc.rpsp.accounts.service.AccountConfigService;
import com.emc.rpsp.repository.SystemConnectionInfoRepository;

@Service public class AccountConfigServiceImpl implements AccountConfigService {

    @Autowired private AccountRepository accountRepository;
    
    @Autowired private AccountConfigsRepository accountConfigRepository;

    @Autowired private SystemConnectionInfoRepository systemConnectionInfoRepository;

    @PersistenceContext private EntityManager entityManager;



	@Override
	public List<AccountConfig> findAllAccountConfigs(Long accountId) {
		List<AccountConfig> accountConfigs = accountConfigRepository.findAccountConfigs(accountId);
		return accountConfigs;
	}

	@Override
	public AccountConfig findAccountConfig(Long accountConfigId) {
		AccountConfig accountConfig = accountConfigRepository.findOne(accountConfigId);
		return accountConfig;
	}

	@Override
	@Transactional
	public AccountConfig createAccountConfig(AccountConfig accountConfig,
			Long accountId) {
		entityManager.persist(accountConfig);
        entityManager.flush();
        Account account = accountRepository.findOne(accountId);
        accountConfig.addAccount(account);
        AccountConfig newAccountConfig = entityManager.merge(accountConfig);
        entityManager.flush();
        return newAccountConfig;
	}


	@Override
	@Transactional
	public void deleteAccountConfig(Long accountConfigId) {
		accountConfigRepository.delete(accountConfigId);
		
	}

}
