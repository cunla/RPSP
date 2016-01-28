package com.emc.rpsp.backupsystems;

import com.emc.rpsp.backupsystems.tasks.BackupWorker;
import com.emc.rpsp.backupsystems.tasks.GenerateBackupTask;
import com.emc.rpsp.core.service.impl.BaseServiceImpl;
import com.emc.rpsp.exceptions.RpspBackupFailedException;
import com.emc.rpsp.exceptions.RpspBackupSystemNotSetException;
import com.emc.rpsp.exceptions.RpspBackupVmNotFoundException;
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

import javax.annotation.PostConstruct;
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
        List<String> accessed = new LinkedList<>();
        for (String vm : vms) {
            if (vm.contains("_restore")) {
                accessed.add(vm);
            }
        }
        vms.removeAll(accessed);
        return vms;
    }


    public String getVmBackupStatus(String vmName) {
        VmBackup vm = repository.findVmByName(vmName);
        if (null == vm) {
            throw new RpspBackupVmNotFoundException(vmName);
        }
        BackupSystem system = vm.getBackupSystem();
        VSphereApi vSphereApi = new VSphereApi(system.getVcenterUrl(), system.getUsername(), system.getRealPassword());
        List<String> vms = vSphereApi.vmsInFolder(system.getAccessBackupFolder());
        for (String _vm : vms) {
            if (_vm.contains(vmName) && _vm.contains("_restore")) {
                return _vm;
            }
        }
        return null;
    }

    @PostConstruct
    public void init() {
        List<VmBackup> backups = vmBackupRepo.findAll();
        for (VmBackup backup : backups) {
            backup.setHasTask(false);
        }
        vmBackupRepo.save(backups);
    }

    @Scheduled(cron = EVERY_MINUTE)
    public void addTasksFromDb() {
        log.info("Adding tasks from DB");
        List<VmBackup> backups = vmBackupRepo.findAll();
        for (VmBackup backup : backups) {
            boolean hasTask = backup.getHasTask();
            boolean enabled = backup.getEnabled();
            if (!hasTask && enabled) {
                backup.setHasTask(true);
                vmBackupRepo.save(backup);
                GenerateBackupTask task = new GenerateBackupTask(this, backup, vmBackupRepo);
                BackupWorker.addTask(task);
            }
        }

    }

    public List<String> getBackupsList(String vmName) {
        VmBackup vm = repository.findVmByName(vmName);
        if (null == vm) {
            throw new RpspBackupVmNotFoundException(vmName);
        }
        List<String> vms = getBackupsList(vm.getBackupSystem());
        return fetchVmBackupsList(vms, vmName);
    }

    public List<String> fetchVmBackupsList(List<String> backups, String vmName) {
        List<String> res = new LinkedList<>();
        for (String backup : backups) {
            if (backup.startsWith(vmName + "_"))
                res.add(backup);
        }
        return res;
    }

    public void addVmsToBackupSchedule(List<VmDefinition> vmDefs, String schedule) {
        for (VmDefinition currVmDef : vmDefs) {
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
        VmBackup backup = vmBackupRepo.findByName(vmName);
        if (null == backup) {
            backup = new VmBackup(system, client.getSystemSettings(), vmId, vmName, schedule);
        } else {
            backup.setBackupSystem(system);
            backup.setSystemSettings(client.getSystemSettings());
            backup.setSchedule(schedule);
            backup.setVmId(vmId);
        }
        vmBackupRepo.saveAndFlush(backup);
    }

    public void backupVm(VmBackup vm) {
        String vmName = vm.getVmName();
        Client client = new Client(vm.getSystemSettings());
        BackupImageAccessParams params = getImageAccessParams(client, vm.getVmId());
        log.debug("Enabling image access for CG {} to backup vm {}", params.getGroupId(), vm.getVmName());
        client.enableLatestImageAccess(params.getClusterId(), params.getGroupId(), params.getCopyId());
        client.verifyCopyImageAccessActivation(params.getClusterId(), params.getGroupId(), params.getCopyId(), GeneralFalConsts.IMAGE_ACCESS_STATUS_RETRY_ATTEMPTS);
        String vmDrTestName = vmReplicaName(client, vm.getVmId());
        log.debug("Image access for CG {} enabled, cloning vm {}", params.getGroupId(), vmDrTestName);
        BackupSystem system = vm.getBackupSystem();
        VSphereApi vSphereApi = new VSphereApi(system.getVcenterUrl(), system.getUsername(), system.getRealPassword());
        for (int i = 0; i < 5; ++i) {
            if (vSphereApi.vmNames().contains(vmDrTestName)) {
                log.debug("Image access VM {} exists, proceeding to clone", vmDrTestName);
                break;
            }
            try {
                log.debug("Image access VM {} does not exist, waiting...", vmDrTestName);
                Thread.sleep(60000);
            } catch (InterruptedException e) {
            }
        }
        List<String> vmNames = vSphereApi.vmNames();
        String backupVmName = currentBackupName(vmName);
        if (!vmNames.contains(vmDrTestName)) {
            throw new RpspBackupFailedException(vmName);
        }
        if (vmNames.contains(backupVmName)) {
            backupVmName = backupVmName + "_2";
        }
        try {
            log.debug("Cloning VM {} to VM {}", vmDrTestName, backupVmName);
            vSphereApi.cloneVM(vmDrTestName, system.getBackupFolder(), backupVmName, system.getBackupDatastore(), false);
            log.debug("Finished cloning VM {} to VM {}", vmDrTestName, backupVmName);
        } catch (Exception e) {
            log.warn("Failed to backup/clone VM {}", vmName);
            throw new RpspBackupFailedException(vmName);
        } finally {
            client.disableImageAccess(params.getClusterId(), params.getGroupId(), params.getCopyId());
        }
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
            vSphereApi.powerOffVM(accessBackupName(backupName));
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
                Long.parseLong(replicaInfo.get(GeneralFalConsts.REPLICA_GROUP_ID).toString()),
                Long.parseLong(replicaInfo.get(GeneralFalConsts.REPLICA_CLUSTER_ID).toString()),
                Integer.parseInt(replicaInfo.get(GeneralFalConsts.REPLICA_COPY_ID).toString()),
                replicaInfo.get(GeneralFalConsts.REPLICA_VM_NAME).toString());
        }
        return backupImageAccessParams;
    }

    private String vmReplicaName(Client client, String productionVmId) {
        BackupImageAccessParams backupImageAccessParams = null;
        Map<String, Map<String, Object>> vmsInfo = client.getVmInfoMap();
        Map<String, Object> replicaInfo = vmsInfo.get(productionVmId);
        return (replicaInfo != null) ? replicaInfo.get(GeneralFalConsts.REPLICA_VM_NAME).toString() : null;
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
