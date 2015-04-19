package com.emc.rpsp.fal;

import java.util.List;

/**
 * Created by morand3 on 12/24/2014.
 */
public class Cluster {
	private List<VmData> vmData;
	private String clusterName;
	private int totalVms;

	public Cluster(String clusterName, List<VmData> vmData) {
		this.vmData = vmData;
		this.clusterName = clusterName;
		totalVms = (null == vmData) ? 0 : vmData.size();
	}

	public List<VmData> getVmData() {
		return vmData;
	}

	public String getClusterName() {
		return clusterName;
	}

	public int getTotalVms() {
		return totalVms;
	}
}
