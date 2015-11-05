package com.emc.rpsp.vmstructure.domain;

import java.util.LinkedList;
import java.util.List;

public class SystemInfo {
	
    private ClusterDefinition productionCluster;
    private List<ClusterDefinition> replicaClusters = new LinkedList<ClusterDefinition>();
	   
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
	   
	


}
