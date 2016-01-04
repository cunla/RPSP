package com.emc.rpsp.backupsystems;

public class BackupImageAccessParams {
    private Long groupId;
    private Long clusterId;
    private Integer copyId;

    private String replicaName;

    public BackupImageAccessParams() {
        super();
    }

    public BackupImageAccessParams(Long groupId, Long clusterId, Integer copyId, String replicaName) {
        this.groupId = groupId;
        this.clusterId = clusterId;
        this.copyId = copyId;
        this.replicaName = replicaName;
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

    public String getReplicaName() {
        return replicaName;
    }

    public void setReplicaName(String vmName) {
        this.replicaName = vmName;
    }
}
