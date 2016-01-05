package com.emc.rpsp.backupsystems;

import com.emc.rpsp.backupsystems.tasks.BackupWorker;
import com.emc.rpsp.backupsystems.tasks.GenerateBackupTask;
import com.emc.rpsp.core.service.impl.BaseServiceImpl;
import com.emc.rpsp.exceptions.RpspBackupSystemNotSetException;
import com.emc.rpsp.exceptions.RpspParamsException;
import com.emc.rpsp.fal.Client;
import com.emc.rpsp.fal.GeneralFalConsts;
import com.emc.rpsp.vmstructure.domain.VmDefinition;
import com.emc.rpsp.vmwal.VSphereApi;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by morand3 on 1/3/2016.
 */
@Service
public class BackupApi extends BaseServiceImpl {
    public static final String EVERY_MINUTE = "1 * * * * *";
    private final Logger log = LoggerFactory.getLogger(BackupApi.class);
    @Autowired
    private BackupSystemsRepository repository;
    @Autowired
    private VmBackupRepository vmBackupRepo;

    public List<String> getBackupsList(BackupSystem system) {
        VSphereApi vSphereApi = new VSphereApi(system.getVcenterUrl(), system.getUsername(), system.getRealPassword());
        List<String> vms = vSphereApi.vmsInFolder(system.getBackupFolder());
        return vms;
    }

    @Scheduled(cron = EVERY_MINUTE)
    public void addTasksFromDb() {
        log.info("Adding tasks from DB");
        List<VmBackup> backups = vmBackupRepo.findAll();
        for (VmBackup backup : backups) {
            if(!backup.getHasTask()) {
                backup.setHasTask(true);
                vmBackupRepo.save(backup);
                GenerateBackupTask task = new GenerateBackupTask(this, backup, vmBackupRepo);
                BackupWorker.addTask(task);
            }
        }

    }

    public List<String> getBackupsList(String vmName) {
        VmBackup vm = repository.findVmByName(vmName);
        List<String> vms = getBackupsList(vm.getBackupSystem());
        return fetchVmBackupsList(vms, vmName);
    }

    public List<String> fetchVmBackupsList(List<String> backups, String vmName) {
        List<String> res = new LinkedList<>();
        for (String backup : backups) {
            if (backup.startsWith(vmName))
                res.add(backup);
        }
        return res;
    }

    public void addVmsToBackupSchedule(List<VmDefinition> vmDefs, String schedule) {
    	for(VmDefinition currVmDef : vmDefs){
    		 addVmToBackupSchedule(currVmDef.getId(), currVmDef.getName(), schedule);
    	}
    }

    public void addVmToBackupSchedule(String vmId, String vmName, String schedule) {
        List<BackupSystem> backupSystems = repository.findAll();
        if (backupSystems.isEmpty()) {
            throw new RpspBackupSystemNotSetException();
        }
        BackupSystem system = backupSystems.get(0);
        Client client = getClient();
        VmBackup backup = new VmBackup(system, client.getSystemSettings(), vmId, vmName, schedule);
        vmBackupRepo.saveAndFlush(backup);
    }


    public void backupVm(VmBackup vm) {
//        VmBackup vm = repository.findVmByName(vmName);
        String vmName = vm.getVmName();
        Client client = new Client(vm.getSystemSettings());
        BackupImageAccessParams params = getImageAccessParams(client, vm.getVmId());
        client.enableLatestImageAccess(params.getClusterId(), params.getGroupId(), params.getCopyId());
        client.verifyCopyImageAccessActivation(params.getClusterId(), params.getGroupId(), params.getCopyId(), GeneralFalConsts.IMAGE_ACCESS_STATUS_RETRY_ATTEMPTS);
        String vmDrTestName = params.getReplicaName();
        BackupSystem system = vm.getBackupSystem();
        VSphereApi vSphereApi = new VSphereApi(system.getVcenterUrl(), system.getUsername(), system.getRealPassword());
        try {
            vSphereApi.cloneVM(vmDrTestName, system.getBackupFolder(), currentBackupName(vmName), system.getBackupDatastore(), false);
        } catch (Exception e) {
            log.warn("Failed to backup/clone VM {}", vmName);
        }
        client.disableImageAccess(params.getClusterId(), params.getGroupId(), params.getCopyId());
    }

    public void enableAccessBackup(BackupSystem system, String backupName) throws Exception {
        if (null == system || null == backupName) {
            log.warn("Called enable access backup with no params");
            throw new RpspParamsException();
        }
        try {
            VSphereApi vSphereApi = new VSphereApi(system.getVcenterUrl(), system.getUsername(), system.getRealPassword());
            vSphereApi.cloneVM(backupName,
                system.getAccessBackupFolder(),
                accessBackupName(backupName),
                system.getAccessBackupDatastore(),
                true);
        } catch (Exception e) {
            log.warn("Failed to enable access to backup {}", backupName);
            throw e;
        }
    }

    public void disableAccessBackup(BackupSystem system, String backupName) throws Exception {
        if (null == system || null == backupName) {
            log.warn("Called enable access backup with no params");
            throw new RpspParamsException();
        }
        try {
            VSphereApi vSphereApi = new VSphereApi(system.getVcenterUrl(), system.getUsername(), system.getRealPassword());
            vSphereApi.removeVM(accessBackupName(backupName));
        } catch (Exception e) {
            log.warn("Failed to disable backup access VM {}", backupName);
            throw e;
        }
    }

    private BackupImageAccessParams getImageAccessParams(Client client, String productionVmId) {
        BackupImageAccessParams backupImageAccessParams = null;
        Map<String, Map<String, Object>> vmsInfo = client.getVmInfoMap();
        Map<String, Object> replicaInfo = vmsInfo.get(productionVmId);
        if (replicaInfo != null) {
            backupImageAccessParams = new BackupImageAccessParams(
                Long.parseLong(replicaInfo.get(BackupConsts.REPLICA_GROUP_ID).toString()),
                Long.parseLong(replicaInfo.get(BackupConsts.REPLICA_CLUSTER_ID).toString()),
                Integer.parseInt(replicaInfo.get(BackupConsts.REPLICA_COPY_ID).toString()),
                replicaInfo.get(BackupConsts.REPLICA_VM_NAME).toString());
        }
        return backupImageAccessParams;
    }
    
   


    private String accessBackupName(String backup) {
        return backup + "_restore";
    }

    private String currentBackupName(String vmName) {
        return vmName + DateFormatUtils.format(new Date(), "_yyyy-MM-dd");
    }

    public void disableBackupForVmId(String vmId) {
        VmBackup backup = vmBackupRepo.findByVmId(vmId);
        if (null != backup) {
            vmBackupRepo.delete(backup);
        }
    }
}
