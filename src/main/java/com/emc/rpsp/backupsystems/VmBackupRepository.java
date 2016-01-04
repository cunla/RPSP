package com.emc.rpsp.backupsystems;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by morand3 on 1/4/2016.
 */
public interface VmBackupRepository extends JpaRepository<VmBackup, Long> {
    @Query("select v from VmBackup v where v.vmName=:vmName")
    VmBackup findByName(@Param("vmName") String vmName);

    @Query("select v from VmBackup v where v.vmId=:vmId")
    VmBackup findByVmId(@Param("vmId") String vmId);
}
