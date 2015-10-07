package com.emc.rpsp.accounts.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity @Table(name = "T_ACCOUNT_CONFIG")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class AccountConfig implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "cluster_id")
    private Long clusterId;

    @Column(name = "is_prod_cluster")
	private Boolean isProductionCluster;

    //Not used at the moment
    @Size(min = 0, max = 100)
    @Column(name = "test_network_id", length = 100)
    private String testNetworkId;

    //vCenter ID the cluster is on
    @Size(min = 0, max = 100)
    @Column(name = "vc_id", length = 100)
    private String vcId;

    //ESX the generated VM on protect operation will be created on
    @Size(min = 0, max = 100)
    @Column(name = "esx_id", length = 100)
    private String esxId;

    //Used with DR2C - ESX cluster under data center
    @Size(min = 0, max = 100)
    @Column(name = "esx_cluster_id", length = 100)
    private String esxClusterId;

    //Datastore the generated VM on protect operation will be created on
    @Size(min = 0, max = 100)
    @Column(name = "datastore_id", length = 100)
    private String datastoreId;

    //Datacenter to access for DR2C
    @Size(min = 0, max = 100)
    @Column(name = "dataCenterId", length = 100)
    private String dataCenterId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Account account;


    public AccountConfig() {
        super();
    }

    public void addAccount(Account account){
    	this.account = account;
    }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getClusterId() {
		return clusterId;
	}


	public void setClusterId(Long clusterId) {
		this.clusterId = clusterId;
	}


	public Boolean getIsProductionCluster() {
		return isProductionCluster;
	}


	public void setIsProductionCluster(Boolean isProductionCluster) {
		this.isProductionCluster = isProductionCluster;
	}

	public String getTestNetworkId() {
		return testNetworkId;
	}


	public void setTestNetworkId(String testNetworkId) {
		this.testNetworkId = testNetworkId;
	}


	public String getVcId() {
		return vcId;
	}


	public void setVcId(String vcId) {
		this.vcId = vcId;
	}


	public String getEsxId() {
		return esxId;
	}


	public void setEsxId(String esxId) {
		this.esxId = esxId;
	}


	public String getDatastoreId() {
		return datastoreId;
	}


	public void setDatastoreId(String datastoreId) {
		this.datastoreId = datastoreId;
	}


	public String getEsxClusterId() {
		return esxClusterId;
	}

	public void setEsxClusterId(String esxClusterId) {
		this.esxClusterId = esxClusterId;
	}

	public String getDataCenterId() {
		return dataCenterId;
	}

	public void setDataCenterId(String dataCenterId) {
		this.dataCenterId = dataCenterId;
	}

	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}



}
