package com.emc.rpsp.backupsystems.tasks;

import com.emc.rpsp.backupsystems.BackupApi;
import com.emc.rpsp.backupsystems.VmBackup;
import com.emc.rpsp.backupsystems.VmBackupRepository;

import java.util.Date;

/**
 * Created by morand3 on 1/4/2016.
 */
public class GenerateBackupTask extends Task {

    private final BackupApi backupApi;
    private final VmBackup backup;
    private final VmBackupRepository repo;

    public GenerateBackupTask(BackupApi backupApi, VmBackup backup, VmBackupRepository repo) {
        this.backupApi = backupApi;
        this.backup = backup;
        this.repo = repo;
    }

    public void run() {
        super.run();
        try {
            Date lastBackup = backup.getLastBackup();
            Date now = new Date();
            long delta = now.getTime()-lastBackup.getTime();
            if(delta>milisForPackage()) {
                backupApi.backupVm(backup);
                backup.setLastBackup(new Date());
                repo.save(backup);
            }
            super.success();
        } catch (Exception e) {
            super.failed(e);
        }
    }

    private long milisForPackage() {
        return 1000*60*60*24*7;//WEEK
    }

    @Override
    public String toString() {
        return "GenerateBackupTask{" + backup.getVmName() + '}';
    }
}
