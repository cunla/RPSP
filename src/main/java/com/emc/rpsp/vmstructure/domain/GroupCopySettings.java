package com.emc.rpsp.vmstructure.domain;

public class GroupCopySettings {
	
	private String id;
	private String name;
	private String clusterId;
	private boolean isImageAccessActive;
		
	
	public GroupCopySettings() {
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
	public String getClusterId() {
		return clusterId;
	}
	public void setClusterId(String clusterId) {
		this.clusterId = clusterId;
	}
	public boolean isImageAccessActive() {
		return isImageAccessActive;
	}
	public void setImageAccessActive(boolean isImageAccessActive) {
		this.isImageAccessActive = isImageAccessActive;
	}
	
	
}
