package com.emc.rpsp.backupsystems;

public class BackupImageAccessParams {
	private Long groupId;
	private Long clusterId;
	private Integer copyId;
	
	
	public BackupImageAccessParams() {
		super();
	}
	
	
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public Long getClusterId() {
		return clusterId;
	}
	public void setClusterId(Long clusterId) {
		this.clusterId = clusterId;
	}
	public Integer getCopyId() {
		return copyId;
	}
	public void setCopyId(Integer copyId) {
		this.copyId = copyId;
	}
	
	

}
