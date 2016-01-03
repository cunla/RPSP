package com.emc.rpsp.backupsystems;

import com.emc.rpsp.rpsystems.ClusterSettings;
import com.emc.rpsp.rpsystems.SystemSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by morand3 on 1/14/2015.
 */
@RepositoryRestResource(collectionResourceRel = "backupsystems", path = "backupsystems")
public interface BackupSystemsRepository extends JpaRepository<BackupSystem, Long> {

}
