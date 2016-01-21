package com.emc.rpsp.core.service.impl;

import com.emc.rpsp.RpspException;
import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.core.service.BaseService;
import com.emc.rpsp.fal.Client;
import com.emc.rpsp.infra.common.accounts.service.AccountsDataService;
import com.emc.rpsp.infra.common.auth.domain.AbstractCurrentUser;
import com.emc.rpsp.infra.common.packages.service.PackagesDataService;
import com.emc.rpsp.infra.common.systems.service.SystemsDataService;
import com.emc.rpsp.infra.common.vms.service.VmsDataService;
import com.emc.rpsp.packages.domain.PackageConfig;
import com.emc.rpsp.packages.domain.PackageDefinition;
import com.emc.rpsp.rpsystems.ClusterSettings;
import com.emc.rpsp.rpsystems.SystemSettings;
import com.emc.rpsp.users.service.UserService;
import com.emc.rpsp.vms.domain.VmOwnership;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BaseServiceImpl implements BaseService {

    @Autowired
    private UserService userService = null;

    @Autowired
    private AccountsDataService accountsDataService = null;

    @Autowired
    private SystemsDataService systemsDataService = null;

    @Autowired
    private VmsDataService vmsDataService = null;

    @Autowired
    private PackagesDataService packagesDataService = null;


    @Override
    public Client getClient() {
        Account account = userService.findCurrentUser().getAccount();
        Client client = null;
        if (account != null) {
            List<SystemSettings> systemSettings = findSystemsByAccount(account);
            client = new Client(systemSettings.get(0));
        }
        return client;
    }
    
    
    @Override
    public Client getClient(SystemSettings systemSettings) {
        Client client = new Client(systemSettings);
        return client;
    }


    @Override
    public AbstractCurrentUser getCurrentUser() {
        AbstractCurrentUser currentUser = userService.findCurrentUser();
        return currentUser;
    }


    @Override
    public List<Account> findAllAccounts() {
        return accountsDataService.findAll();
    }

    @Override
    public PackageDefinition findPackageById(Long id) {
        return packagesDataService.findPackageById(id);
    }

    @Override
    public List<PackageDefinition> findPackagesByAccount(Account account) {
        return packagesDataService.findPackagesByAccount(account);
    }


    @Override
    public List<PackageConfig> findPackageConfigsByAccount(Account account) {
        List<PackageConfig> res = new LinkedList<PackageConfig>();
        List<PackageDefinition> packageDefs = packagesDataService.findPackagesByAccount(account);
        for (PackageDefinition currPackageDefinition : packageDefs) {
            res.addAll(getPackageConfigs(currPackageDefinition));
        }
        return res;

    }

    @Override
    public List<PackageConfig> findPackageConfigsByPackageId(Long id) {
        List<PackageConfig> res = null;
        PackageDefinition packageDefinition = packagesDataService.findPackageById(id);
        if(packageDefinition != null){
        	res = new LinkedList<PackageConfig>();
        	res.addAll(getPackageConfigs(packageDefinition));
        }
        return res;

    }


    @Override
    public List<SystemSettings> findAllSystems() {
        return systemsDataService.findAll();
    }

    @Override
    public List<SystemSettings> findSystemsByAccount(Account account) {
        return systemsDataService.findByAccount(account);
    }

    public List<ClusterSettings> findClustersBySystem(SystemSettings systemSettings) {
        return systemsDataService.findClustersBySystem(systemSettings);
    }
    
    public SystemSettings findSystemByCluster(Long clusterId) {
    	List<SystemSettings> systems = systemsDataService.findAll();
    	Stream<SystemSettings> systemsStream =  systems
				    								.stream()
				    								.filter(s -> s.getClusters()
					    									.stream()
					    									.map(ClusterSettings::getClusterId)
					    									.collect(Collectors.toList())
					    									.contains(clusterId));
    	
    	return systemsStream.collect(Collectors.toList()).get(0);
    	
    }

    @Override
    public List<VmOwnership> findAllVms() {
        return vmsDataService.findAll();
    }

    @Override
    public List<VmOwnership> findVmsByAccount(Account account) {
        return vmsDataService.findByAccount(account);
    }


    @Override
    public Long getGroupPackage(Long groupId) {
        Client client = getClient();
        return client.getGroupPackage(groupId);
    }


    @Override
    public void setGroupPackage(Long groupId, Long packageId) {
        Client client = getClient();
        client.setGroupPackage(groupId, packageId);
    }


    @Override
    public Map<String, String> getCustomProperties() {
        Client client = getClient();
        return (null == client) ? null : client.getUserPropertiesMap();
    }


    private List<PackageConfig> getPackageConfigs(PackageDefinition packageDefinition) {
        List<PackageConfig> res = new LinkedList<PackageConfig>();

        if (null == packageDefinition) {
            throw new RpspException("No package defined");
        }
        PackageConfig prodConfig = new PackageConfig();
        prodConfig.setIsProductionCluster(true);
        prodConfig.setClusterId(packageDefinition.getSourceClusterId());
        prodConfig.setVcId(packageDefinition.getSourceVcId());
        prodConfig.setDataCenterId(packageDefinition.getSourceDataCenterId());
        prodConfig.setEsxClusterId(packageDefinition.getSourceEsxClusterId());
        prodConfig.setEsxId(packageDefinition.getSourceEsxId());
        prodConfig.setDatastoreId(packageDefinition.getSourceDatastoreId());
        res.add(prodConfig);

        PackageConfig replicaConfig = new PackageConfig();
        replicaConfig.setIsProductionCluster(false);
        replicaConfig.setClusterId(packageDefinition.getTargetClusterId());
        replicaConfig.setVcId(packageDefinition.getTargetVcId());
        replicaConfig.setDataCenterId(packageDefinition.getTargetDataCenterId());
        replicaConfig.setEsxClusterId(packageDefinition.getTargetEsxClusterId());
        replicaConfig.setEsxId(packageDefinition.getTargetEsxId());
        replicaConfig.setDatastoreId(packageDefinition.getTargetDatastoreId());
        res.add(replicaConfig);

        return res;
    }


}
