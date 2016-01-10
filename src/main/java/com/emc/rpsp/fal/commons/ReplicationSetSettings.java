package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReplicationSetSettings")
public class ReplicationSetSettings {

    @XmlElement(nillable = true)
    private ReplicationSetUID replicationSetUID;
    private String replicationSetName;
    private long sizeInBytes;
    private HashSet<UserVolumeSettings> volumes;
    /*private ReplicationSetType replicationSetType;*/ //XXX Vnx

    public ReplicationSetSettings() {
    }

    public ReplicationSetSettings(ReplicationSetUID replicationSetUID,
                                  String replicationSetName, long sizeInBytes,
                                  HashSet<UserVolumeSettings> volumes) {
        this.replicationSetUID = replicationSetUID;
        this.replicationSetName = replicationSetName;
        this.sizeInBytes = sizeInBytes;
        this.volumes = volumes;
    }

    public ReplicationSetUID getReplicationSetUID() {
        return replicationSetUID;
    }

    public void setReplicationSetUID(ReplicationSetUID replicationSetUID) {
        this.replicationSetUID = replicationSetUID;
    }

    public String getReplicationSetName() {
        return replicationSetName;
    }

    public void setReplicationSetName(String replicationSetName) {
        this.replicationSetName = replicationSetName;
    }

    public long getSizeInBytes() {
        return sizeInBytes;
    }

    public void setSizeInBytes(long sizeInBytes) {
        this.sizeInBytes = sizeInBytes;
    }

    public HashSet<UserVolumeSettings> getVolumes() {
        return volumes;
    }

    public void setVolumes(HashSet<UserVolumeSettings> volumes) {
        this.volumes = volumes;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ReplicationSetSettings [replicationSetUID=")
            .append(replicationSetUID).append(", replicationSetName=")
            .append(replicationSetName).append(", sizeInBytes=")
            .append(sizeInBytes).append(", volumes=").append(volumes)
            .append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((replicationSetName == null) ? 0 : replicationSetName
            .hashCode());
        result = prime
            * result
            + ((replicationSetUID == null) ? 0 : replicationSetUID
            .hashCode());
        result = prime * result + (int) (sizeInBytes ^ (sizeInBytes >>> 32));
        result = prime * result + ((volumes == null) ? 0 : volumes.hashCode());
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
        ReplicationSetSettings other = (ReplicationSetSettings) obj;
        if (replicationSetName == null) {
            if (other.replicationSetName != null)
                return false;
        } else if (!replicationSetName.equals(other.replicationSetName))
            return false;
        if (replicationSetUID == null) {
            if (other.replicationSetUID != null)
                return false;
        } else if (!replicationSetUID.equals(other.replicationSetUID))
            return false;
        if (sizeInBytes != other.sizeInBytes)
            return false;
        if (volumes == null) {
            if (other.volumes != null)
                return false;
        } else if (!volumes.equals(other.volumes))
            return false;
        return true;
    }
}
