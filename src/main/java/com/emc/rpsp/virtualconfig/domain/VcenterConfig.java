package com.emc.rpsp.virtualconfig.domain;

import java.util.ArrayList;
import java.util.List;

public class VcenterConfig {
	
	private String id;
	private String name;
	private List<DataCenterConfig> relatedDatacenters = new ArrayList<DataCenterConfig>();	
	
	public VcenterConfig() {
		super();
	}
	
	public void addDataCenterConfig(DataCenterConfig dataCenterConfig) {
		this.relatedDatacenters.add(dataCenterConfig);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<DataCenterConfig> getRelatedDatacenters() {
		return relatedDatacenters;
	}
	public void setRelatedDatacenters(List<DataCenterConfig> relatedDatacenters) {
		this.relatedDatacenters = relatedDatacenters;
	}


	@Override
	public String toString() {
		return "VcenterConfig [id=" + id + ", name=" + name
				+ ", relatedDatacenters=" + relatedDatacenters + "]";
	}
	
	
	
	
	
}
