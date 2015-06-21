package com.emc.rpsp.rpsystems;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

/**
 * Created by morand3 on 2/8/2015.
 */
@Entity @Table(name = "T_CLUSTERS") @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ClusterSettings {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) private long id;

    @Column private String country;
    @Column private Long clusterId;
    @Column private String clusterName;
    @Column private String friendlyName;

    @JsonIgnore @ManyToOne(fetch = FetchType.LAZY) private SystemSettings systemSettings;

    public ClusterSettings() {
    }

    public ClusterSettings(Long clusterId, String clusterName, SystemSettings systemSettings) {
        this.clusterId = clusterId;
        this.clusterName = clusterName;
        this.systemSettings = systemSettings;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getClusterId() {
        return clusterId;
    }

    public void setClusterId(Long clusterId) {
        this.clusterId = clusterId;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public long getId() {
        return id;
    }

    public SystemSettings getSystemSettings() {
        return systemSettings;
    }

    public void setSystemSettings(SystemSettings systemSettings) {
        this.systemSettings = systemSettings;
    }

}
