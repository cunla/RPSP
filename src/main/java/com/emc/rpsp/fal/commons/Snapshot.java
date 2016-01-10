package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Snapshot")
public class Snapshot implements Validateable {

    @XmlElement(nillable = true)
    private SnapshotUID snapshotUID; // Will be null if converted from FAPI version 3_4
    @XmlElement(required = true)
    private String description;
    @XmlElement(required = true)
    private RecoverPointTimeStamp closingTimeStamp;
    private long sizeInBytes;
    private long uncompressedSizeInBytes;
    private SnapshotConsolidationInfo consolidationInfo;
    private boolean userSnapshot;
    private EventLog relevantEvent;
    private SnapshotConsistencyType consistencyType;

    public Snapshot() {
    }

    public Snapshot(SnapshotUID snapshotUID, String description,
                    RecoverPointTimeStamp closingTimeStamp, long sizeInBytes,
                    long uncompressedSizeInBytes,
                    SnapshotConsolidationInfo consolidationInfo, boolean userSnapshot,
                    EventLog relevantEvent, SnapshotConsistencyType consistencyType) {
        this.snapshotUID = snapshotUID;
        this.description = description;
        this.closingTimeStamp = closingTimeStamp;
        this.sizeInBytes = sizeInBytes;
        this.uncompressedSizeInBytes = uncompressedSizeInBytes;
        this.consolidationInfo = consolidationInfo;
        this.userSnapshot = userSnapshot;
        this.relevantEvent = relevantEvent;
        this.consistencyType = consistencyType;
    }


    public SnapshotUID getSnapshotUID() {
        return snapshotUID;
    }

    public void setSnapshotUID(SnapshotUID snapshotUID) {
        this.snapshotUID = snapshotUID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RecoverPointTimeStamp getClosingTimeStamp() {
        return closingTimeStamp;
    }

    public void setClosingTimeStamp(RecoverPointTimeStamp closingTimeStamp) {
        this.closingTimeStamp = closingTimeStamp;
    }

    public long getSizeInBytes() {
        return sizeInBytes;
    }

    public void setSizeInBytes(long sizeInBytes) {
        this.sizeInBytes = sizeInBytes;
    }

    public long getUncompressedSizeInBytes() {
        return uncompressedSizeInBytes;
    }

    public void setUncompressedSizeInBytes(long uncompressedSizeInBytes) {
        this.uncompressedSizeInBytes = uncompressedSizeInBytes;
    }

    public SnapshotConsolidationInfo getConsolidationInfo() {
        return consolidationInfo;
    }

    public void setConsolidationInfo(SnapshotConsolidationInfo consolidationInfo) {
        this.consolidationInfo = consolidationInfo;
    }

    public boolean getUserSnapshot() {
        return userSnapshot;
    }

    public void setUserSnapshot(boolean userSnapshot) {
        this.userSnapshot = userSnapshot;
    }

    public EventLog getRelevantEvent() {
        return relevantEvent;
    }

    public void setRelevantEvent(EventLog relevantEvent) {
        this.relevantEvent = relevantEvent;
    }

    public SnapshotConsistencyType getConsistencyType() {
        return consistencyType;
    }

    public void setConsistencyType(SnapshotConsistencyType consistencyType) {
        this.consistencyType = consistencyType;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((closingTimeStamp == null) ? 0 : closingTimeStamp.hashCode());
        result = prime * result
            + ((consistencyType == null) ? 0 : consistencyType.hashCode());
        result = prime
            * result
            + ((consolidationInfo == null) ? 0 : consolidationInfo
            .hashCode());
        result = prime * result
            + ((description == null) ? 0 : description.hashCode());
        result = prime * result
            + ((relevantEvent == null) ? 0 : relevantEvent.hashCode());
        result = prime * result + (int) (sizeInBytes ^ (sizeInBytes >>> 32));
        result = prime * result
            + ((snapshotUID == null) ? 0 : snapshotUID.hashCode());
        result = prime
            * result
            + (int) (uncompressedSizeInBytes ^ (uncompressedSizeInBytes >>> 32));
        result = prime * result + (userSnapshot ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Snapshot other = (Snapshot) obj;
        if (closingTimeStamp == null) {
            if (other.closingTimeStamp != null)
                return false;
        } else if (!closingTimeStamp.equals(other.closingTimeStamp))
            return false;
        if (consistencyType != other.consistencyType)
            return false;
        if (consolidationInfo == null) {
            if (other.consolidationInfo != null)
                return false;
        } else if (!consolidationInfo.equals(other.consolidationInfo))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (relevantEvent == null) {
            if (other.relevantEvent != null)
                return false;
        } else if (!relevantEvent.equals(other.relevantEvent))
            return false;
        if (sizeInBytes != other.sizeInBytes)
            return false;
        if (snapshotUID == null) {
            if (other.snapshotUID != null)
                return false;
        } else if (!snapshotUID.equals(other.snapshotUID))
            return false;
        if (uncompressedSizeInBytes != other.uncompressedSizeInBytes)
            return false;
        if (userSnapshot != other.userSnapshot)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Snapshot [snapshotUID=").append(snapshotUID)
            .append(", description=").append(description)
            .append(", closingTimeStamp=").append(closingTimeStamp)
            .append(", sizeInBytes=").append(sizeInBytes)
            .append(", uncompressedSizeInBytes=")
            .append(uncompressedSizeInBytes).append(", consolidationInfo=")
            .append(consolidationInfo).append(", userSnapshot=")
            .append(userSnapshot).append(", relevantEvent=")
            .append(relevantEvent).append(", consistencyType=")
            .append(consistencyType).append("]");
        return builder.toString();
    }
}
