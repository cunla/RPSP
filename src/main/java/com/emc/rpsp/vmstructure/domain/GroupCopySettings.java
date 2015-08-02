package com.emc.rpsp.vmstructure.domain;

import java.util.LinkedList;
import java.util.List;

public class GroupCopySettings {

    private String id;
    private String name;
    private String clusterId;
    private String imageAccess;
    private String replication;
    private String initCompletionPortion;
    private List<CopySnapshot> snapshots = new LinkedList<CopySnapshot>();
    private List<CopySnapshot> bookmarks = new LinkedList<CopySnapshot>();

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

    public List<CopySnapshot> getSnapshots() {
        return snapshots;
    }

    public void setSnapshots(List<CopySnapshot> snapshots) {
        this.snapshots = snapshots;
    }

    public List<CopySnapshot> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(List<CopySnapshot> bookmarks) {
        this.bookmarks = bookmarks;
    }

	public String getInitCompletionPortion() {
		return initCompletionPortion;
	}

	public void setInitCompletionPortion(String initCompletionPortion) {
		this.initCompletionPortion = initCompletionPortion;
	}
    
    

}
