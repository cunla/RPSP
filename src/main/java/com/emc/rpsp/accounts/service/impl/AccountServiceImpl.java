package com.emc.rpsp.accounts.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.accounts.repository.AccountConfigsRepository;
import com.emc.rpsp.accounts.repository.AccountRepository;
import com.emc.rpsp.accounts.service.AccountService;
import com.emc.rpsp.repository.SystemConnectionInfoRepository;
import com.emc.rpsp.rpsystems.SystemSettings;

@Service public class AccountServiceImpl implements AccountService {

    @Autowired private AccountRepository accountRepository;
    
    @Autowired private AccountConfigsRepository accountConfigRepository;

    @Autowired private SystemConnectionInfoRepository systemConnectionInfoRepository;

    @PersistenceContext private EntityManager entityManager;

    @Override public List<Account> findAll() {
        List<Account> accounts = accountRepository.findAll();
        return accounts;
    }

    @Override public Account findById(Long id) {
        Account account = accountRepository.findOne(id);
        return account;
    }

    @Override public Account findByName(String name) {
        Account account = accountRepository.findOneByName(name);
        return account;
    }

    @Override @Transactional public Account create(Account account, Long systemId) {
        entityManager.persist(account);
        entityManager.flush();
        SystemSettings systemSettings = systemConnectionInfoRepository.findOne(systemId);
        account.addSystem(systemSettings);
        Account newAccount = entityManager.merge(account);
        entityManager.flush();
        return newAccount;
    }

    @Override public Account update(Account account) {
        Account existingAccount = accountRepository.findOne(account.getId());
        existingAccount.setName(account.getName());
        existingAccount.setLabel(account.getLabel());
        Account updatedAccount = accountRepository.save(existingAccount);
        return updatedAccount;
    }

    @Override public void delete(Long id) {
        accountRepository.delete(id);

    }

	

}
