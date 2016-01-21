package com.emc.rpsp.virtualconfig.domain;

public class DataStoreConfig {
	
	private String id;
	private String name;
	
	public DataStoreConfig() {
		super();
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

	@Override
	public String toString() {
		return "DataStoreConfig [id=" + id + ", name=" + name + "]";
	}
	
	
}
