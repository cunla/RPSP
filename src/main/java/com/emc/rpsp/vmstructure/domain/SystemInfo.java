package com.emc.rpsp.vmstructure.domain;

import java.util.LinkedList;
import java.util.List;

import com.emc.rpsp.packages.domain.PackageDefinition;

public class SystemInfo {
	
    private ClusterDefinition productionCluster;
    private List<ClusterDefinition> replicaClusters = new LinkedList<ClusterDefinition>();
    private List<PackageDefinition> packages = new LinkedList<PackageDefinition>();
	   
	public SystemInfo() {
		super();
	}
	
	public void addReplicaCluster(ClusterDefinition cluster) {
		this.replicaClusters.add(cluster);
	}

	public ClusterDefinition getProductionCluster() {
		return productionCluster;
	}

	public void setProductionCluster(ClusterDefinition productionCluster) {
		this.productionCluster = productionCluster;
	}

	public List<ClusterDefinition> getReplicaClusters() {
		return replicaClusters;
	}

	public void setReplicaClusters(List<ClusterDefinition> replicaClusters) {
		this.replicaClusters = replicaClusters;
	}

	public List<PackageDefinition> getPackages() {
		return packages;
	}

	public void setPackages(List<PackageDefinition> packages) {
		this.packages = packages;
	}
	   
	


}
