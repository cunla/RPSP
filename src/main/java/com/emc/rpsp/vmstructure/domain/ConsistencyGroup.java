package com.emc.rpsp.vmstructure.domain;

import java.util.List;

public class ConsistencyGroup implements VmContainer {

	private String name;
	private boolean isReplicationEnabled;
	private boolean isReplicationActive;
	private boolean isImageAccessEnabled;
	private List<VmDefinition> vms;
	private ClusterDefinition productionCluster;
	private List<ClusterDefinition> replicaClusters;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isReplicationEnabled() {
		return isReplicationEnabled;
	}

	public void setReplicationEnabled(boolean isReplicationEnabled) {
		this.isReplicationEnabled = isReplicationEnabled;
	}

	public boolean isReplicationActive() {
		return isReplicationActive;
	}

	public void setReplicationActive(boolean isReplicationActive) {
		this.isReplicationActive = isReplicationActive;
	}

	public boolean isImageAccessEnabled() {
		return isImageAccessEnabled;
	}

	public void setImageAccessEnabled(boolean isImageAccessEnabled) {
		this.isImageAccessEnabled = isImageAccessEnabled;
	}

	public List<VmDefinition> getVms() {
		return vms;
	}

	public void setVms(List<VmDefinition> vms) {
		this.vms = vms;
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

	@Override
	public String getType() {
		return "cg";
	}

}
