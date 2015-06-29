package com.emc.rpsp.accounts.service;

import java.util.List;

import com.emc.rpsp.accounts.domain.Account;

public interface AccountService {
    public List<Account> findAll();

    public Account findById(Long id);

    public Account create(Account account, Long systemId);

    public Account update(Account user);

    public void delete(Long id);

    public Account findByName(String name);
}
