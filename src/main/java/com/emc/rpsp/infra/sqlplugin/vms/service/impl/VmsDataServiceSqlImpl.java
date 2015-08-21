package com.emc.rpsp.infra.sqlplugin.vms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.infra.common.vms.service.VmsDataService;
import com.emc.rpsp.vms.domain.VmOwnership;
import com.emc.rpsp.vms.repository.VmOwnershipRepository;

@Service
public class VmsDataServiceSqlImpl implements VmsDataService {
	
	@Autowired
	private VmOwnershipRepository vmOwnershipRepository;

	@Override
	public List<VmOwnership> findAll() {
		List<VmOwnership> vmOwnership = vmOwnershipRepository.findAll();
		return vmOwnership;
	}

	@Override
	public List<VmOwnership> findByAccount(Account account) {
		return account.getVms();
	}

}
