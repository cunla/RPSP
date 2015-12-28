package com.emc.rpsp.packages.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emc.rpsp.packages.domain.PackageDefinition;
import com.emc.rpsp.packages.repository.PackageDefinitionRepository;
import com.emc.rpsp.packages.service.PackageDefinitionService;
import com.emc.rpsp.rpsystems.SystemConnectionInfoRepository;
import com.emc.rpsp.rpsystems.SystemSettings;

@Service
public class PackageDefinitionServiceImpl implements PackageDefinitionService {

	@Autowired
	private PackageDefinitionRepository packageDefinitionRepository;


	@Autowired
	private SystemConnectionInfoRepository systemConnectionInfoRepository;

    @PersistenceContext(unitName = "rpsp")
    @Qualifier("entityManagerFactory")
	private EntityManager entityManager;

	@Override
	public List<PackageDefinition> findAll() {
		List<PackageDefinition> packageDefs = packageDefinitionRepository.findAll();
		setAdditionalValues(packageDefs);
		return packageDefs;
	}

	@Override
	public PackageDefinition findById(Long id) {
		PackageDefinition packageDef = packageDefinitionRepository.findOne(id);
		packageDef.setAdditionalValues();
		return packageDef;
	}


	@Override
	@Transactional("transactionManager")
	public PackageDefinition create(PackageDefinition packageDef) {
		entityManager.persist(packageDef);
		entityManager.flush();
		SystemSettings systemSettings = systemConnectionInfoRepository
				.findOne(packageDef.getSystemId());
		packageDef.setSystemSettings(systemSettings);
		PackageDefinition newPackageDef = entityManager.merge(packageDef);
		entityManager.flush();
		return newPackageDef;
	}


	@Override
	public void delete(Long id) {
		packageDefinitionRepository.delete(id);

	}
	
	private void setAdditionalValues(List<PackageDefinition> packageDefs){
		if(packageDefs != null){
			for(PackageDefinition currPackageDefinition : packageDefs){
				currPackageDefinition.setAdditionalValues();
			}
		}
	}

}
