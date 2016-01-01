package com.emc.rpsp.infra.sqlplugin.systems.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.infra.common.systems.service.SystemsDataService;
import com.emc.rpsp.packages.domain.PackageDefinition;
import com.emc.rpsp.rpsystems.SystemConnectionInfoRepository;
import com.emc.rpsp.rpsystems.ClusterSettings;
import com.emc.rpsp.rpsystems.SystemSettings;

@Service
public class SystemsDataServiceSqlImpl implements SystemsDataService {

	@Autowired
	private SystemConnectionInfoRepository systemConnectionInfoRepository;

	@Override
	public List<SystemSettings> findAll() {
		List<SystemSettings> systemsSettings = systemConnectionInfoRepository.findAll();
		return systemsSettings;
	}

	@Override
	public List<SystemSettings> findByAccount(Account account) {
		List<SystemSettings> systems = new LinkedList<SystemSettings>();
		PackageDefinition packageDef = account.getPackages().get(0);
		systems.add(packageDef.getSystemSettings());
		return systems;
	}

	@Override
	public List<ClusterSettings> findClustersBySystem(
			SystemSettings systemSettings) {
		return systemSettings.getClusters();
	}

}
