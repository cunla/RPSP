package com.emc.rpsp.rpsystems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.emc.rpsp.backupsystems.VmBackup;
import com.emc.rpsp.config.Consts;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.emc.rpsp.packages.domain.PackageDefinition;
import com.emc.rpsp.tools.StringXORer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by morand3 on 1/13/2015.
 */
@Entity @Table(name = "T_SYSTEMS") @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SystemSettings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @JsonProperty("ip")
    @Column
    private String systemIp;

    @Column
    private String user;

    @Column
    // @JsonIgnore
    private String password;

    @Column
    private Boolean isDrttc;

    @Column
    private Boolean isMultiTenanctEnabled;

    @Column
    private Boolean testResult;

    @Column
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime lastTested;


    @Column
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime lastCollected;


    @Column
    private String systemVersion;

    @Column
    @OneToMany(mappedBy = "systemSettings", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonProperty("clusters")
    private List<ClusterSettings> clusters;

    @JsonIgnore
	@Column
	@OneToMany(mappedBy = "systemSettings", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<PackageDefinition> packages;
    
    @JsonIgnore
    @OneToMany(mappedBy = "systemSettings")
    private List<VmBackup> vms;


    public static enum TestResult {
        OK, AUTH_FAILED, FAILED
    }

    public SystemSettings() {
        clusters = new LinkedList<>();
        packages = new LinkedList<>();
    }

    public SystemSettings(String systemIp, String user, String password) {
        this();
        this.systemIp = systemIp;
        this.user = user;
        setPassword(password);
    }

    public void addCluster(ClusterSettings cluster) {
        clusters.add(cluster);
    }

    public String getSystemIp() {
        return systemIp;
    }

    @JsonProperty("id") public Long getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    @JsonIgnore public String getRealPassword() {
        return StringXORer.decrypt(Consts.ENCRYPT_KEY1, Consts.ENCRYPT_KEY2, password);
    }

    public String getPassword() {
        return "*****";
    }

    public Boolean getTestResult() {
        return testResult;
    }

    public DateTime getLastTested() {
        return new DateTime(lastTested);
    }

    public void setTestResult(Boolean result) {
        this.testResult = result;
        this.lastTested = DateTime.now();// .toString();
    }

    public void setSystemIp(String systemIp) {
        this.systemIp = systemIp;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = StringXORer.encrypt(Consts.ENCRYPT_KEY1, Consts.ENCRYPT_KEY2, password);
    }

    public DateTime getLastCollected() {
        return lastCollected;
    }

    public void setLastCollected(DateTime lastCollected) {
        this.lastCollected = lastCollected;
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public void setSystemVersion(String systemVersion) {
        this.systemVersion = systemVersion;
    }

    public List<ClusterSettings> getClusters() {
        return clusters;
    }



    public List<PackageDefinition> getPackages() {
		return packages;
	}

	public void setPackages(List<PackageDefinition> packages) {
		this.packages = packages;
	}

	public void setId(Long id) {
        this.id = id;
    }

    public void addPackage(PackageDefinition packageParam) {
    	packages.add(packageParam);
    }



    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsDrttc() {
		return isDrttc;
	}

	public void setIsDrttc(Boolean isDrttc) {
		this.isDrttc = isDrttc;
	}

	public Boolean getIsMultiTenanctEnabled() {
		return isMultiTenanctEnabled;
	}

	public void setIsMultiTenanctEnabled(Boolean isMultiTenanctEnabled) {
		this.isMultiTenanctEnabled = isMultiTenanctEnabled;
	}

	@JsonIgnore
	public Map<String, ClusterSettings> getNameToClusterMap() {
        Map<String, ClusterSettings> clustersMap = new HashMap<String, ClusterSettings>();
        for (ClusterSettings clusterSettings : clusters) {
            clustersMap.put(clusterSettings.getClusterName(), clusterSettings);
        }
        return clustersMap;
    }

}
