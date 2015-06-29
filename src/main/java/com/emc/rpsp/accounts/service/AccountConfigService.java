package com.emc.rpsp.accounts.service;

import java.util.List;

import com.emc.rpsp.accounts.domain.AccountConfig;

public interface AccountConfigService {
    
    public List<AccountConfig> findAllAccountConfigs(Long accountId);
    
    public AccountConfig findAccountConfig(Long accountConfigId);
    
    public AccountConfig createAccountConfig(AccountConfig account, Long accountId);
    
    public void deleteAccountConfig(Long accountConfigId);
}
