package com.emc.rpsp.accounts.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.accounts.repository.AccountRepository;
import com.emc.rpsp.accounts.service.AccountService;
import com.emc.rpsp.packages.domain.PackageDefinition;
import com.emc.rpsp.packages.repository.PackageDefinitionRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	
	@Autowired
	private PackageDefinitionRepository packageDefinitionRepository;


    @PersistenceContext(unitName = "rpsp")
    @Qualifier("entityManagerFactory")
	private EntityManager entityManager;

	@Override
	public List<Account> findAll() {
		List<Account> accounts = accountRepository.findAll();
		setAdditionalValues(accounts);
		return accounts;
	}

	@Override
	public Account findById(Long id) {
		Account account = accountRepository.findOne(id);
		account.setAdditionalValues();
		return account;
	}

	@Override
	public Account findByName(String name) {
		Account account = accountRepository.findOneByName(name);
		if(account != null){
			account.setAdditionalValues();
		}
		return account;
	}

	@Override
	@Transactional("transactionManager")
	public Account create(Account account) {
		entityManager.persist(account);
		entityManager.flush();
		for(Long currPackageId : account.getPackageIds()){
			PackageDefinition packageDef = packageDefinitionRepository
					.findOne(currPackageId);
			account.addPackage(packageDef);
		}
		Account newAccount = entityManager.merge(account);
		entityManager.flush();
		return newAccount;
	}

	@Override
	public Account update(Account account) {
		Account existingAccount = accountRepository.findOne(account.getId());
		existingAccount.setName(account.getName());
		existingAccount.setLabel(account.getLabel());
		Account updatedAccount = accountRepository.save(existingAccount);
		return updatedAccount;
	}

	@Override
	public void delete(Long id) {
		accountRepository.delete(id);

	}
	
	private void setAdditionalValues(List<Account> accounts){
		if(accounts != null){
			for(Account currAccount : accounts){
				currAccount.setAdditionalValues();
			}
		}
	}

}
