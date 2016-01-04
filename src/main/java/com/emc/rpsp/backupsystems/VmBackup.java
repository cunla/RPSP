package com.emc.rpsp.backupsystems;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

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
    private BackupSystem backupSystem;
    @Column
    private String vmName;
    @Column
    private String vmId;
    @Column
    private Boolean enabled;
    @Column
    private String schedule;
    @Column
    private Date lastBackup;

    public VmBackup() {
    }

    public VmBackup(BackupSystem system, String vmId, String vmName, String schedule) {
        this.backupSystem = system;
        this.vmName = vmName;
        this.vmId = vmId;
        this.schedule = schedule;
        this.enabled = true;
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

    public Date getLastBackup() {
        return lastBackup;
    }

    public void setLastBackup(Date lastBackup) {
        this.lastBackup = lastBackup;
    }
}
