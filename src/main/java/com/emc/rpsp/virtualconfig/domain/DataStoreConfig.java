package com.emc.rpsp.virtualconfig.domain;

public class DataStoreConfig {
	
	private String id;
	private String name;
	private Long freeSpace;
	private Long capacity;
	
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

	public Long getFreeSpace() {
		return freeSpace;
	}

	public void setFreeSpace(Long freeSpace) {
		this.freeSpace = freeSpace;
	}

	public Long getCapacity() {
		return capacity;
	}

	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "DataStoreConfig [id=" + id + ", name=" + name + "]";
	}
	
	
}
