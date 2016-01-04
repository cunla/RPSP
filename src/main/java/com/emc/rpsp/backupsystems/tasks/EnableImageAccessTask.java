package com.emc.rpsp.backupsystems.tasks;

import com.emc.rpsp.backupsystems.BackupApi;
import com.emc.rpsp.backupsystems.BackupSystem;
import com.emc.rpsp.backupsystems.VmBackup;

/**
 * Created by morand3 on 1/4/2016.
 */
public class EnableImageAccessTask extends Task {

    private final BackupApi backupApi;
    private final BackupSystem backupSystem;
    private final String backupName;

    public EnableImageAccessTask(BackupApi backupApi, BackupSystem backupSystem, String backupName) {
        super();
        this.backupApi = backupApi;
        this.backupSystem = backupSystem;
        this.backupName = backupName;
    }

    public void run() {
        super.run();
        try {
            backupApi.enableAccessBackup(backupSystem, backupName);
            super.success();
        } catch (Exception e) {
            super.failed(e);
        }
    }

    @Override
    public String toString() {
        return "EnableImageAccessTask{" + backupName + '}';
    }
}
