package com.emc.rpsp.infra.common.systems.service;

import java.util.List;

import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.rpsystems.ClusterSettings;
import com.emc.rpsp.rpsystems.SystemSettings;

public interface SystemsDataService {
	public List<SystemSettings> findAll();
	public List<SystemSettings> findByAccount(Account account);
	public List<ClusterSettings> findClustersBySystem(SystemSettings systemSettings);
}
