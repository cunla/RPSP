package com.emc.rpsp.backupsystems;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

/**
 * Created by morand3 on 1/3/2016.
 */
@Entity
@Table(name = "T_BACKUP_VMS")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class VmBackup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn
    private BackupSystem backupSystem;
    @Column
    private String vmName;
    @Column
    private String vmId;
    @Column
    private Boolean enabled;

    public VmBackup() {
    }

    public BackupSystem getBackupSystem() {
        return backupSystem;
    }

    public void setBackupSystem(BackupSystem backupSystem) {
        this.backupSystem = backupSystem;
    }

    public String getVmName() {
        return vmName;
    }

    public void setVmName(String vmName) {
        this.vmName = vmName;
    }

    public String getVmId() {
        return vmId;
    }

    public void setVmId(String vmId) {
        this.vmId = vmId;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
