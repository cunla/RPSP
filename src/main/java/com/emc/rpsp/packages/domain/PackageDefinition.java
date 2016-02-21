package com.emc.rpsp.packages.domain;

import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.rpsystems.SystemSettings;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "T_PACKAGE")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class PackageDefinition implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(PackageDefinition.class);
    @Id
    @GeneratedValue
    private Long id;

    @Transient
    @JsonProperty
    private Long systemId;
    
    @Transient
    @JsonProperty
    private String systemName;

    @Size(min = 0, max = 100)
    @Column(name = "name", length = 100)
    private String name;

    @Size(min = 0, max = 100)
    @Column(name = "displayName", length = 100)
    private String displayName;

    @Size(min = 0, max = 300)
    @Column(name = "description", length = 300)
    private String description;


    @Column(name = "rpo")
    private Integer rpo;

    //cluster
    @Column(name = "source_cluster_id")
    private Long sourceClusterId;


    //vCenter ID the cluster is on
    @Size(min = 0, max = 100)
    @Column(name = "source_vc_id", length = 100)
    private String sourceVcId;
    
    @Size(min = 0, max = 100)
    @Column(name = "source_vc_name", length = 100)
    private String sourceVcName;


    //Datacenter to access for DR2C
    @Size(min = 0, max = 100)
    @Column(name = "source_datacenter_id", length = 100)
    private String sourceDataCenterId;
    
    
    @Size(min = 0, max = 100)
    @Column(name = "source_datacenter_name", length = 100)
    private String sourceDataCenterName;


    //Used with DR2C - ESX cluster under data center
    @Size(min = 0, max = 100)
    @Column(name = "source_esx_cluster_id", length = 100)
    private String sourceEsxClusterId;
    
    
    @Size(min = 0, max = 100)
    @Column(name = "source_esx_cluster_name", length = 100)
    private String sourceEsxClusterName;


    //ESX the generated VM on protect operation will be created on
    @Size(min = 0, max = 100)
    @Column(name = "source_esx_id", length = 100)
    private String sourceEsxId;
    
    
    @Size(min = 0, max = 100)
    @Column(name = "source_esx_name", length = 100)
    private String sourceEsxName;

    //Datastore the generated VM on protect operation will be created on
    @Size(min = 0, max = 100)
    @Column(name = "source_datastore_id", length = 100)
    private String sourceDatastoreId;
    
    @Size(min = 0, max = 100)
    @Column(name = "source_datastore_name", length = 100)
    private String sourceDatastoreName;

    //cluster
    @Column(name = "target_cluster_id")
    private Long targetClusterId;

    //vCenter ID the cluster is on
    @Size(min = 0, max = 100)
    @Column(name = "target_vc_id", length = 100)
    private String targetVcId;
    
    @Size(min = 0, max = 100)
    @Column(name = "target_vc_name", length = 100)
    private String targetVcName;


    //Datacenter to access for DR2C
    @Size(min = 0, max = 100)
    @Column(name = "target_datacenter_id", length = 100)
    private String targetDataCenterId;
    
    @Size(min = 0, max = 100)
    @Column(name = "target_datacenter_name", length = 100)
    private String targetDataCenterName;


    //Used with DR2C - ESX cluster under data center
    @Size(min = 0, max = 100)
    @Column(name = "target_esx_cluster_id", length = 100)
    private String targetEsxClusterId;
    
    @Size(min = 0, max = 100)
    @Column(name = "target_esx_cluster_name", length = 100)
    private String targetEsxClusterName;


    //ESX the generated VM on protect operation will be created on
    @Size(min = 0, max = 100)
    @Column(name = "target_esx_id", length = 100)
    private String targetEsxId;
    
    @Size(min = 0, max = 100)
    @Column(name = "target_esx_name", length = 100)
    private String targetEsxName;


    //Datastore the generated VM on protect operation will be created on
    @Size(min = 0, max = 100)
    @Column(name = "target_datastore_id", length = 100)
    private String targetDatastoreId;
    
    
    @Size(min = 0, max = 100)
    @Column(name = "target_datastore_name", length = 100)
    private String targetDatastoreName;


    //Not used at the moment
    @Size(min = 0, max = 100)
    @Column(name = "test_network_id", length = 100)
    private String testNetworkId;


    @JsonIgnore
    @Column
    @ManyToMany(targetEntity = com.emc.rpsp.accounts.domain.Account.class, mappedBy = "packageDefinition", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Account> accounts;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private SystemSettings systemSettings;


    public PackageDefinition() {
        super();
        accounts = new LinkedList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRpo() {
        return rpo;
    }

    public void setRpo(Integer rpo) {
        this.rpo = rpo;
    }

    public Long getSourceClusterId() {
        return sourceClusterId;
    }

    public void setSourceClusterId(Long sourceClusterId) {
        this.sourceClusterId = sourceClusterId;
    }

    public String getSourceDataCenterId() {
        return sourceDataCenterId;
    }

    public void setSourceDataCenterId(String sourceDataCenterId) {
        this.sourceDataCenterId = sourceDataCenterId;
    }

    public String getSourceEsxClusterId() {
        return sourceEsxClusterId;
    }

    public void setSourceEsxClusterId(String sourceEsxClusterId) {
        this.sourceEsxClusterId = sourceEsxClusterId;
    }

    public String getSourceDatastoreId() {
        return sourceDatastoreId;
    }

    public void setSourceDatastoreId(String sourceDatastoreId) {
        this.sourceDatastoreId = sourceDatastoreId;
    }

    public Long getTargetClusterId() {
        return targetClusterId;
    }

    public void setTargetClusterId(Long targetClusterId) {
        this.targetClusterId = targetClusterId;
    }

    public String getTargetDataCenterId() {
        return targetDataCenterId;
    }

    public void setTargetDataCenterId(String targetDataCenterId) {
        this.targetDataCenterId = targetDataCenterId;
    }

    public String getTargetEsxClusterId() {
        return targetEsxClusterId;
    }

    public void setTargetEsxClusterId(String targetEsxClusterId) {
        this.targetEsxClusterId = targetEsxClusterId;
    }

    public String getTargetDatastoreId() {
        return targetDatastoreId;
    }

    public void setTargetDatastoreId(String targetDatastoreId) {
        this.targetDatastoreId = targetDatastoreId;
    }

    public String getTestNetworkId() {
        return testNetworkId;
    }

    public void setTestNetworkId(String testNetworkId) {
        this.testNetworkId = testNetworkId;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
    
    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public SystemSettings getSystemSettings() {
        return systemSettings;
    }

    public void setSystemSettings(SystemSettings systemSettings) {
        this.systemSettings = systemSettings;
    }

    public String getSourceVcId() {
        return sourceVcId;
    }

    public void setSourceVcId(String sourceVcId) {
        this.sourceVcId = sourceVcId;
    }

    public String getSourceEsxId() {
        return sourceEsxId;
    }

    public void setSourceEsxId(String sourceEsxId) {
        this.sourceEsxId = sourceEsxId;
    }

    public String getTargetVcId() {
        return targetVcId;
    }

    public void setTargetVcId(String targetVcId) {
        this.targetVcId = targetVcId;
    }

    public String getTargetEsxId() {
        return targetEsxId;
    }

    public void setTargetEsxId(String targetEsxId) {
        this.targetEsxId = targetEsxId;
    }

    public void setAdditionalValues() {
        if (null != systemSettings) {
            systemId = systemSettings.getId();
            systemName = systemSettings.getName();
        } else {
            log.warn("System not defined for package");
        }
    }


    public Long getSystemId() {
        return systemId;
    }

    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    } 

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	
	
	
	

	public String getSourceVcName() {
		return sourceVcName;
	}

	public void setSourceVcName(String sourceVcName) {
		this.sourceVcName = sourceVcName;
	}

	public String getSourceDataCenterName() {
		return sourceDataCenterName;
	}

	public void setSourceDataCenterName(String sourceDataCenterName) {
		this.sourceDataCenterName = sourceDataCenterName;
	}

	public String getSourceEsxClusterName() {
		return sourceEsxClusterName;
	}

	public void setSourceEsxClusterName(String sourceEsxClusterName) {
		this.sourceEsxClusterName = sourceEsxClusterName;
	}

	public String getSourceEsxName() {
		return sourceEsxName;
	}

	public void setSourceEsxName(String sourceEsxName) {
		this.sourceEsxName = sourceEsxName;
	}

	public String getSourceDatastoreName() {
		return sourceDatastoreName;
	}

	public void setSourceDatastoreName(String sourceDatastoreName) {
		this.sourceDatastoreName = sourceDatastoreName;
	}

	public String getTargetVcName() {
		return targetVcName;
	}

	public void setTargetVcName(String targetVcName) {
		this.targetVcName = targetVcName;
	}

	public String getTargetDataCenterName() {
		return targetDataCenterName;
	}

	public void setTargetDataCenterName(String targetDataCenterName) {
		this.targetDataCenterName = targetDataCenterName;
	}

	public String getTargetEsxClusterName() {
		return targetEsxClusterName;
	}

	public void setTargetEsxClusterName(String targetEsxClusterName) {
		this.targetEsxClusterName = targetEsxClusterName;
	}

	public String getTargetEsxName() {
		return targetEsxName;
	}

	public void setTargetEsxName(String targetEsxName) {
		this.targetEsxName = targetEsxName;
	}

	public String getTargetDatastoreName() {
		return targetDatastoreName;
	}

	public void setTargetDatastoreName(String targetDatastoreName) {
		this.targetDatastoreName = targetDatastoreName;
	}

	@Override
    public String toString() {
        return "Account{" + "id='" + id + '\'' + ", name='" + name + '\''
            + ", label='" + displayName + "}";
    }
}
