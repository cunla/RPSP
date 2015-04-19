package com.emc.rpsp.fal;

import org.joda.time.DateTime;

import java.util.List;

/**
 * Created by morand3 on 12/24/2014.
 */
public class DatabaseInfo {
	private List<Cluster> clusters;
	private int totalClusters;
	private int totalVms;
	private DateTime sampleDate;

	public DatabaseInfo(List<Cluster> clusters, DateTime sampleDate) {
		this.clusters = clusters;
		this.sampleDate = sampleDate;
		totalClusters = (null == clusters) ? 0 : clusters.size();
		totalVms = 0;
		if (null == clusters) {
			return;
		}
		for (Cluster cluster : clusters) {
			totalVms += cluster.getTotalVms();
		}
	}

	public List<Cluster> getClusters() {
		return clusters;
	}

	public int getTotalClusters() {
		return totalClusters;
	}

	public int getTotalVms() {
		return totalVms;
	}

	public DateTime getSampleDate() {
		return sampleDate;
	}

	public static DatabaseInfo getCurrentInfo() {
		return new DatabaseInfo(null, DateTime.now());
	}

}
