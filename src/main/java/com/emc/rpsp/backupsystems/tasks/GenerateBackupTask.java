package com.emc.rpsp.backupsystems.tasks;

import com.emc.rpsp.backupsystems.BackupApi;
import com.emc.rpsp.backupsystems.VmBackup;

/**
 * Created by morand3 on 1/4/2016.
 */
public class GenerateBackupTask extends Task {

    private final BackupApi backupApi;
    private final VmBackup backup;

    public GenerateBackupTask(BackupApi backupApi, VmBackup backup) {
        this.backupApi = backupApi;
        this.backup = backup;
    }

    public void run() {
        super.run();
        try {
            backupApi.backupVm(backup);
            super.success();
        } catch (Exception e) {
            super.failed(e);
        }
    }

    @Override
    public String toString() {
        return "GenerateBackupTask{" + backup.getVmName() + '}';
    }
}
