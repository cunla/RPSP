package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VMVolume")
public class VMVolume {

    private String canonicalName;
    private DeviceUID volumeID;
    private ConsistencyGroupCopyUID groupCopyUID;
    @XmlElement(nillable = true)
    private ReplicationSetUID replicationSetUID;
    private boolean filtered;

    public VMVolume() {
    }

    public VMVolume(String canonicalName, DeviceUID volumeID, ConsistencyGroupCopyUID groupCopyUID,
                    ReplicationSetUID replicationSetUID, boolean filtered) {
        this.canonicalName = canonicalName;
        this.volumeID = volumeID;
        this.groupCopyUID = groupCopyUID;
        this.replicationSetUID = replicationSetUID;
        this.filtered = filtered;
    }

    public String getCanonicalName() {
        return canonicalName;
    }

    public void setCanonicalName(String canonicalName) {
        this.canonicalName = canonicalName;
    }

    public DeviceUID getVolumeID() {
        return volumeID;
    }

    public void setVolumeID(DeviceUID volumeID) {
        this.volumeID = volumeID;
    }

    public ConsistencyGroupCopyUID getGroupCopyUID() {
        return groupCopyUID;
    }

    public void setGroupCopyUID(ConsistencyGroupCopyUID groupCopyUID) {
        this.groupCopyUID = groupCopyUID;
    }

    public ReplicationSetUID getReplicationSetUID() {
        return replicationSetUID;
    }

    public void setReplicationSetUID(ReplicationSetUID replicationSetUID) {
        this.replicationSetUID = replicationSetUID;
    }

    public boolean getFiltered() {
        return filtered;
    }

    public void setFiltered(boolean filtered) {
        this.filtered = filtered;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((canonicalName == null) ? 0 : canonicalName.hashCode());
        result = prime * result + (filtered ? 1231 : 1237);
        result = prime * result
            + ((groupCopyUID == null) ? 0 : groupCopyUID.hashCode());
        result = prime
            * result
            + ((replicationSetUID == null) ? 0 : replicationSetUID
            .hashCode());
        result = prime * result
            + ((volumeID == null) ? 0 : volumeID.hashCode());
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
        VMVolume other = (VMVolume) obj;
        if (canonicalName == null) {
            if (other.canonicalName != null)
                return false;
        } else if (!canonicalName.equals(other.canonicalName))
            return false;
        if (filtered != other.filtered)
            return false;
        if (groupCopyUID == null) {
            if (other.groupCopyUID != null)
                return false;
        } else if (!groupCopyUID.equals(other.groupCopyUID))
            return false;
        if (replicationSetUID == null) {
            if (other.replicationSetUID != null)
                return false;
        } else if (!replicationSetUID.equals(other.replicationSetUID))
            return false;
        if (volumeID == null) {
            if (other.volumeID != null)
                return false;
        } else if (!volumeID.equals(other.volumeID))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("VMVolume [canonicalName=").append(canonicalName)
            .append(", filtered=").append(filtered).append(
            ", groupCopyUID=").append(groupCopyUID).append(
            ", replicationSetUID=").append(replicationSetUID)
            .append(", volumeID=").append(volumeID).append("]");
        return builder.toString();
    }
}
