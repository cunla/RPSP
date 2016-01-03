package com.emc.rpsp.backupsystems;

import com.emc.rpsp.config.Consts;
import com.emc.rpsp.tools.StringXORer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

/**
 * Created by morand3 on 1/3/2016.
 */
@Entity
@Table(name = "T_BACKUP_SYSTEMS")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BackupSystem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String vcenterUrl = "https://10.64.125.35/sdk";
    @Column
    private String username = "administrator@vsphere.local";
    @Column
    private String password = "DmBU@EMC!2014";
    @Column
    private String backupDatastore = "DDVE-2_backup";
    @Column
    private String backupFolder = "DD-backup";
    @Column
    private String accessBackupFolder = "backup-access";

    @Column
    private String accessBackupDatastore = "DevA2-DS04-NFS02";

    @JsonIgnore
    @OneToMany(mappedBy = "backupSystem")
    private List<VmBackup> vms;

    public BackupSystem() {

    }

    public String getAccessBackupDatastore() {
        return accessBackupDatastore;
    }

    public void setAccessBackupDatastore(String accessBackupDatastore) {
        this.accessBackupDatastore = accessBackupDatastore;
    }

    public String getAccessBackupFolder() {
        return accessBackupFolder;
    }

    public void setAccessBackupFolder(String accessBackupFolder) {
        this.accessBackupFolder = accessBackupFolder;
    }

    public String getVcenterUrl() {
        return vcenterUrl;
    }

    public void setVcenterUrl(String vcenterUrl) {
        this.vcenterUrl = vcenterUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBackupDatastore() {
        return backupDatastore;
    }

    public void setBackupDatastore(String backupDatastore) {
        this.backupDatastore = backupDatastore;
    }

    public String getBackupFolder() {
        return backupFolder;
    }

    public void setBackupFolder(String backupFolder) {
        this.backupFolder = backupFolder;
    }

    @JsonIgnore
    public String getRealPassword() {
        return StringXORer.decrypt(Consts.ENCRYPT_KEY1, Consts.ENCRYPT_KEY2, password);
    }

    public String getPassword() {
        return "*****";
    }

    public void setPassword(String password) {
        this.password = StringXORer.encrypt(Consts.ENCRYPT_KEY1, Consts.ENCRYPT_KEY2, password);
    }
}
