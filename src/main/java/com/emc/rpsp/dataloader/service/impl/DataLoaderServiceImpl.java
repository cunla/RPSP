package com.emc.rpsp.dataloader.service.impl;

import com.emc.rpsp.RpspException;
import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.accounts.domain.AccountConfig;
import com.emc.rpsp.accounts.service.AccountService;
import com.emc.rpsp.dataloader.service.DataLoaderService;
import com.emc.rpsp.fal.Client;
import com.emc.rpsp.repository.SystemConnectionInfoRepository;
import com.emc.rpsp.rpsystems.ClusterSettings;
import com.emc.rpsp.rpsystems.SystemSettings;
import com.emc.rpsp.users.domain.User;
import com.emc.rpsp.users.service.UserService;
import com.emc.rpsp.vms.domain.VmOwnership;
import com.emc.rpsp.vms.service.VmOwnershipService;

import org.apache.commons.io.IOUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service public class DataLoaderServiceImpl implements DataLoaderService {

    @Autowired private SystemConnectionInfoRepository systemConnectionInfoRepository;

    @Autowired private AccountService accountService;

    @Autowired private VmOwnershipService vmOwnershipService;

    @Autowired private UserService userService;

    @Autowired private ResourcePatternResolver resourceLoader = null;

    private final String CLASSPATH_INTERNAL_DATA_EXPRESSION = "classpath:data-loader/internal-data.template";

    @SuppressWarnings("unchecked") @Override @Transactional
    public List<SystemSettings> populateInternalData(List<Map<String, Object>> fullSettings) {

        systemConnectionInfoRepository.deleteAll();
        List<SystemSettings> createdSettingsList = new LinkedList<SystemSettings>();

        for (Map<String, Object> currSettings : fullSettings) {
            SystemSettings settings = new SystemSettings();

            //system data
            String userName = currSettings.get("user").toString();
            String ip = currSettings.get("ip").toString();
            String password = currSettings.get("password").toString();
            Map<String, Object> clusterFriendlyNames = (Map<String, Object>) currSettings
            .get("clusterFriendlyNames");

            settings.setUser(userName);
            settings.setPassword(password);
            settings.setSystemIp(ip);
            propagateClusterData(settings, clusterFriendlyNames);

            //accounts data
            List<Map<String, Object>> accounts = (List<Map<String, Object>>) currSettings
            .get("accounts");
            for (Map<String, Object> currAccount : accounts) {
                Account account = new Account();
                settings.addAccount(account);
                account.setName(currAccount.get("name").toString());
                account.setLabel(currAccount.get("label").toString());
                account.addSystem(settings);

                //vms data
                List<Map<String, Object>> vms = (List<Map<String, Object>>) currAccount.get("vms");
                for (Map<String, Object> currVm : vms) {
                    VmOwnership vmOwnership = new VmOwnership();
                    account.addVm(vmOwnership);
                    vmOwnership.setVmId(currVm.get("vmId").toString());
                    vmOwnership.setVmName(currVm.get("vmName").toString());
                    vmOwnership.setAccount(account);
                }

                //users data
                List<Map<String, Object>> users = (List<Map<String, Object>>) currAccount
                .get("users");
                for (Map<String, Object> currUser : users) {
                    User user = new User();
                    account.addUser(user);
                    user.setCreatedBy("Anonimous");
                    user.setCreatedDate(new DateTime());
                    user.setLogin(currUser.get("login").toString());
                    user.setEncodedPassword(currUser.get("password").toString());
                    user.setPermission("USER");
                    user.setFirstName(currUser.get("firstName").toString());
                    user.setLastName(currUser.get("lastName").toString());
                    user.setAccount(account);
                }
                
                //account configurations data
                List<Map<String, Object>> accountConfigs = (List<Map<String, Object>>) currAccount
                .get("accountConfigs");
                for (Map<String, Object> currAccountConfig : accountConfigs) {
                	AccountConfig accountConfig = new AccountConfig();
                	account.addAccountConfig(accountConfig);
                	accountConfig.setClusterId(Long.parseLong(currAccountConfig.get("clusterId").toString()));
                	accountConfig.setDatastoreId(currAccountConfig.get("datastoreId").toString());
                	accountConfig.setEsxId(currAccountConfig.get("esxId").toString());
                	accountConfig.setVcId(currAccountConfig.get("vcId").toString());
                	accountConfig.setTestNetworkId(currAccountConfig.get("testNetworkId").toString());
                	accountConfig.setAccount(account);
                }

            }

            SystemSettings createdSettings = systemConnectionInfoRepository.saveAndFlush(settings);
            createdSettingsList.add(createdSettings);
        }
        return createdSettingsList;

    }

    @Override public String getInternalDataTemplate() {
        String template = null;
        InputStream is = null;
        try {
            Resource resource = resourceLoader.getResource(CLASSPATH_INTERNAL_DATA_EXPRESSION);
            is = resource.getInputStream();
            template = IOUtils.toString(is, "UTF-8");
        } catch (Exception e) {
            throw new RpspException("Couldn't read internal data configuration");
        } finally {
            IOUtils.closeQuietly(is);
        }
        return template;
    }

    private void propagateClusterData(SystemSettings systemSettings,
    Map<String, Object> clusterFriendlyNames) {
        Client client = new Client(systemSettings, systemConnectionInfoRepository);
        Map<Long, String> clusters = client.getClusterNames();
        for (Map.Entry<Long, String> entry : clusters.entrySet()) {
            ClusterSettings cluster = new ClusterSettings(entry.getKey(), entry.getValue(),
            systemSettings);
            cluster.setFriendlyName(clusterFriendlyNames.get(entry.getValue()).toString());
            systemSettings.addCluster(cluster);
        }
    }

}
