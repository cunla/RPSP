package com.emc.rpsp.dataloader.service.impl;

import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emc.rpsp.RpspException;
import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.accounts.service.AccountService;
import com.emc.rpsp.dataloader.domain.InternalData;
import com.emc.rpsp.dataloader.service.DataLoaderService;
import com.emc.rpsp.fal.Client;
import com.emc.rpsp.packages.domain.PackageDefinition;
import com.emc.rpsp.packages.service.PackageDefinitionService;
import com.emc.rpsp.rpsystems.ClusterSettings;
import com.emc.rpsp.rpsystems.SystemConnectionInfoRepository;
import com.emc.rpsp.rpsystems.SystemSettings;
import com.emc.rpsp.users.domain.User;
import com.emc.rpsp.users.service.UserService;
import com.emc.rpsp.vms.domain.VmOwnership;
import com.emc.rpsp.vms.service.VmOwnershipService;

@Service
public class DataLoaderServiceImpl implements DataLoaderService {

	@Autowired
	private SystemConnectionInfoRepository systemConnectionInfoRepository;

	@Autowired
	private PackageDefinitionService packageDefService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private VmOwnershipService vmOwnershipService;

	@Autowired
	private UserService userService;

	@Autowired
	private ResourcePatternResolver resourceLoader = null;

	private final String CLASSPATH_INTERNAL_DATA_EXPRESSION = "classpath:data-loader/internal-data.template";


	@Override
	public InternalData getInternalData() {
		InternalData internalData = new InternalData();
		internalData.setSystems(systemConnectionInfoRepository.findAll());
		internalData.setPackages(packageDefService.findAll());
		internalData.setTenants(accountService.findAll());
		internalData.setUsers(userService.findUsers());
		internalData.setVms(vmOwnershipService.findAll());
		return internalData;
	}
	

	@Override
	@Transactional("transactionManager")
	public InternalData populateInternalData(InternalData internalData) {
		
		//clean the configuration
		systemConnectionInfoRepository.deleteAll();
		
		//systems
		List<SystemSettings> systems = internalData.getSystems();
		Map<String, SystemSettings> systemsMap = systems.stream().collect(Collectors.toMap(SystemSettings::getName, (p) -> p));
		for(SystemSettings systemSettings : systems){
			propagateClusterData(systemSettings);
		}
		
		//packages
		List<PackageDefinition> packages = internalData.getPackages();
		Map<String, PackageDefinition> packagesMap = packages.stream().collect(Collectors.toMap(PackageDefinition::getName, (p) -> p));
		for(PackageDefinition packageDefinition : packages){
			SystemSettings currSystem = systemsMap.get(packageDefinition.getSystemName());
			packageDefinition.setSystemSettings(currSystem);
			currSystem.addPackage(packageDefinition);
			
		}
		
		//accounts
		List<Account> tenants = internalData.getTenants();
		Map<String, Account> accountsMap = tenants.stream().collect(Collectors.toMap(Account::getName, (p) -> p));
		for(Account tenant : tenants){
			for(String packageName : tenant.getPackageNames()){
				PackageDefinition currPackage = packagesMap.get(packageName);
				tenant.addPackage(currPackage);
				currPackage.addAccount(tenant);
			}
		}
		
		//users
		List<User> users = internalData.getUsers();
		for(User user : users){
			if(user.getId() == null){
				user.setCreatedBy("admin");
	            user.setCreatedDate(new DateTime());
	            user.setPermission("USER");
	            user.setEncodedPassword(user.getPassword());
				Account tenant = accountsMap.get(user.getTenantName());
				user.setAccount(tenant);
				tenant.addUser(user);
			}
		}
		
		//vms
		List<VmOwnership> vms = internalData.getVms();
		if(vms != null){
			for(VmOwnership vmOwnership : vms){
				Account tenant = accountsMap.get(vmOwnership.getTenantName());
				vmOwnership.setAccount(tenant);
				tenant.addVm(vmOwnership);
			}
		}
		
		//save new configuration
		for(SystemSettings systemSettings : systems){
			systemConnectionInfoRepository.saveAndFlush(systemSettings);
		}
		InternalData res = getInternalData();
		return res;
	}
	
	@Override
	public String getInternalDataTemplate() {
		String template = null;
		InputStream is = null;
		try {
			Resource resource = resourceLoader
					.getResource(CLASSPATH_INTERNAL_DATA_EXPRESSION);
			is = resource.getInputStream();
			template = IOUtils.toString(is, "UTF-8");
		} catch (Exception e) {
			throw new RpspException("Couldn't read internal data configuration");
		} finally {
			IOUtils.closeQuietly(is);
		}
		return template;
	}
	
	
	@Override
	public void deleteInternalData() {
		//clean the configuration
		systemConnectionInfoRepository.deleteAll();
		
	}

	
	
	private void propagateClusterData(SystemSettings systemSettings) {
    	Map<String, Object> clusterFriendlyNames = new HashMap<String, Object>();
    	List<ClusterSettings> clustersParams = systemSettings.getClusters();    	
    	for(ClusterSettings currClusterSettings : clustersParams){
    		clusterFriendlyNames.put(currClusterSettings.getClusterName(), currClusterSettings.getFriendlyName());
    	}
    	systemSettings.setClusters(new LinkedList<>());
        Client client = new Client(systemSettings, systemConnectionInfoRepository);
        Map<Long, String> clusters = client.getClusterNames();
        for (Map.Entry<Long, String> entry : clusters.entrySet()) {
            ClusterSettings cluster = new ClusterSettings(entry.getKey(), entry.getValue(),
            systemSettings);

            Object clusterFriendlyName = clusterFriendlyNames.get(entry.getValue());
            if (null != clusterFriendlyName) {
                cluster.setFriendlyName(clusterFriendlyName.toString());
                systemSettings.addCluster(cluster);
            }

        }
    }



}
