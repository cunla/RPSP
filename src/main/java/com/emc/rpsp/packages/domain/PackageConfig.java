package com.emc.rpsp.packages.domain;

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

import com.emc.rpsp.accounts.domain.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class PackageConfig implements Serializable {


    private Long id;


    private Long clusterId;
    
    
    private String clusterName;
    
    
    private String clusterFriendlyName;


	private Boolean isProductionCluster;

    //Not used at the moment
    private String testNetworkId;

    //vCenter ID the cluster is on
    private String vcId;

    //ESX the generated VM on protect operation will be created on
    private String esxId;

    //Used with DR2C - ESX cluster under data center
    private String esxClusterId;

    //Datastore the generated VM on protect operation will be created on
    private String datastoreId;

    //Datacenter to access for DR2C
    private String dataCenterId;
    
    
    


    public PackageConfig() {
        super();
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



	public String getClusterName() {
		return clusterName;
	}



	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}



	public String getClusterFriendlyName() {
		return clusterFriendlyName;
	}



	public void setClusterFriendlyName(String clusterFriendlyName) {
		this.clusterFriendlyName = clusterFriendlyName;
	}
	
	
}
