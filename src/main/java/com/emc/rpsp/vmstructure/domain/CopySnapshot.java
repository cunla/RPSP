package com.emc.rpsp.vmstructure.domain;

public class CopySnapshot {

    private Long id;
    private String closingTimestamp;
    private Long originalClosingTimeStamp;
    private String name;
    private boolean isImageAccessEnabled;
    private String consistencyType;

    public CopySnapshot() {
        super();
    }

    public CopySnapshot(Long id, String closingTimestamp) {
        super();
        this.id = id;
        this.closingTimestamp = closingTimestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClosingTimestamp() {
        return closingTimestamp;
    }

    public void setClosingTimestamp(String closingTimestamp) {
        this.closingTimestamp = closingTimestamp;
    }

    public Long getOriginalClosingTimeStamp() {
        return originalClosingTimeStamp;
    }

    public void setOriginalClosingTimeStamp(Long originalClosingTimeStamp) {
        this.originalClosingTimeStamp = originalClosingTimeStamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isImageAccessEnabled() {
        return isImageAccessEnabled;
    }

    public void setImageAccessEnabled(boolean isImageAccessEnabled) {
        this.isImageAccessEnabled = isImageAccessEnabled;
    }

	public String getConsistencyType() {
		return consistencyType;
	}

	public void setConsistencyType(String consistencyType) {
		this.consistencyType = consistencyType;
	}
    
    

}
