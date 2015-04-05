package com.emc.rpsp.repository;

import com.emc.rpsp.domain.ClusterSettings;
import com.emc.rpsp.domain.SystemSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by morand3 on 1/14/2015.
 */
@RepositoryRestResource(collectionResourceRel = "systems", path = "systems" )
public interface SystemConnectionInfoRepository extends JpaRepository<SystemSettings, Long> {

    @Query("select system from SystemSettings system where system.systemIp = ?1")
    public List<SystemSettings> findClustersWithIpAddress(String ipAddress);

    @Query("select cluster from ClusterSettings cluster where cluster.clusterId=?1")
    public List<ClusterSettings> findCluster(Long clusterId);

    @Query("select cluster.country from ClusterSettings cluster where cluster.clusterId=?1")
    public String clusterCountry(Long clusterId);

    @Query("select cluster.clusterId from ClusterSettings cluster")
    List<Long> clusterIds();

    @Query("select cluster from ClusterSettings cluster where cluster.clusterId=?1")
    public ClusterSettings clusterById(long clusterId);
}
