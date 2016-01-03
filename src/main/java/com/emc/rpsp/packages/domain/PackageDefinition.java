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


    //Datacenter to access for DR2C
    @Size(min = 0, max = 100)
    @Column(name = "source_datacenter_id", length = 100)
    private String sourceDataCenterId;


    //Used with DR2C - ESX cluster under data center
    @Size(min = 0, max = 100)
    @Column(name = "source_esx_cluster_id", length = 100)
    private String sourceEsxClusterId;


    //ESX the generated VM on protect operation will be created on
    @Size(min = 0, max = 100)
    @Column(name = "source_esx_id", length = 100)
    private String sourceEsxId;

    //Datastore the generated VM on protect operation will be created on
    @Size(min = 0, max = 100)
    @Column(name = "source_datastore_id", length = 100)
    private String sourceDatastoreId;

    //cluster
    @Column(name = "target_cluster_id")
    private Long targetClusterId;

    //vCenter ID the cluster is on
    @Size(min = 0, max = 100)
    @Column(name = "target_vc_id", length = 100)
    private String targetVcId;


    //Datacenter to access for DR2C
    @Size(min = 0, max = 100)
    @Column(name = "target_datacenter_id", length = 100)
    private String targetDataCenterId;


    //Used with DR2C - ESX cluster under data center
    @Size(min = 0, max = 100)
    @Column(name = "target_esx_cluster_id", length = 100)
    private String targetEsxClusterId;


    //ESX the generated VM on protect operation will be created on
    @Size(min = 0, max = 100)
    @Column(name = "target_esx_id", length = 100)
    private String targetEsxId;


    //Datastore the generated VM on protect operation will be created on
    @Size(min = 0, max = 100)
    @Column(name = "target_datastore_id", length = 100)
    private String targetDatastoreId;


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

    @Override
    public String toString() {
        return "Account{" + "id='" + id + '\'' + ", name='" + name + '\''
            + ", label='" + displayName + "}";
    }
}