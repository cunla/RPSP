package com.emc.rpsp.vmstructure.domain;

public class GroupCopySettings {
	
	private String id;
	private String name;
	private String clusterId;
	private String imageAccess;
	private String replication;
		
	
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
	public String getImageAccess() {
		return imageAccess;
	}
	public void setImageAccess(String imageAccess) {
		this.imageAccess = imageAccess;
	}


	public String getReplication() {
		return replication;
	}


	public void setReplication(String replication) {
		this.replication = replication;
	}
	
	
}
