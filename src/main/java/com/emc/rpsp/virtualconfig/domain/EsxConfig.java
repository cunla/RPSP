package com.emc.rpsp.virtualconfig.domain;

import java.util.ArrayList;
import java.util.List;

public class EsxConfig {
	
	private String id;
	private String name;
	private List<DataStoreConfig> relatedDatastores = new ArrayList<DataStoreConfig>();
	
	public EsxConfig() {
		super();
	}
	
	public void addDataStoreConfig(DataStoreConfig dataStoreConfig) {
		this.relatedDatastores.add(dataStoreConfig);
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

	public List<DataStoreConfig> getRelatedDatastores() {
		return relatedDatastores;
	}

	public void setRelatedDatastores(List<DataStoreConfig> relatedDatastores) {
		this.relatedDatastores = relatedDatastores;
	}

	@Override
	public String toString() {
		return "EsxConfig [id=" + id + ", name=" + name
				+ ", relatedDatastores=" + relatedDatastores + "]";
	}
	
	
	
}
