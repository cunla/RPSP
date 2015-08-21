package com.emc.rpsp.infra.common.vms.service;

import java.util.List;

import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.vms.domain.VmOwnership;

public interface VmsDataService {
	public List<VmOwnership> findAll();
	public List<VmOwnership> findByAccount(Account account);
}
