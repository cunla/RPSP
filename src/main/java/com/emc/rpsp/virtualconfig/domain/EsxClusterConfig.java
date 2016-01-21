package com.emc.rpsp.virtualconfig.domain;

import java.util.ArrayList;
import java.util.List;

public class EsxClusterConfig {
	
	private String id;
	private String name;
	private List<EsxConfig> esxConfigs = new ArrayList<EsxConfig>();
	
	public EsxClusterConfig() {
		super();
	}
	
	public void addEsxConfig(EsxConfig esxConfig) {
		this.esxConfigs.add(esxConfig);
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

	public List<EsxConfig> getEsxConfigs() {
		return esxConfigs;
	}

	public void setEsxConfigs(List<EsxConfig> esxConfigs) {
		this.esxConfigs = esxConfigs;
	}
	
	

	@Override
	public String toString() {
		return "EsxClusterConfig [id=" + id + ", name=" + name
				+ ", esxConfigs=" + esxConfigs + "]";
	}
	
	
	
	
}
