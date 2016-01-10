package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReplicationSetVolumesState")
public class ReplicationSetVolumesState {

    @XmlElement(nillable = true)
    private ReplicationSetUID replicationSetUID;
    private HashSet<UserVolumeState> userVolumesState;
    private long maxPossibleSizeInBytes;
    private boolean canBeEnlarged;

    public ReplicationSetVolumesState() {
    }

    public ReplicationSetVolumesState(ReplicationSetUID replicationSetUID, HashSet<UserVolumeState> userVolumesState, long maxPossibleSizeInBytes,
                                      boolean canBeEnlarged) {
        this.replicationSetUID = replicationSetUID;
        this.userVolumesState = userVolumesState;
        this.maxPossibleSizeInBytes = maxPossibleSizeInBytes;
        this.canBeEnlarged = canBeEnlarged;
    }

    public ReplicationSetUID getReplicationSetUID() {
        return replicationSetUID;
    }

    public void setReplicationSetUID(ReplicationSetUID replicationSetUID) {
        this.replicationSetUID = replicationSetUID;
    }

    public HashSet<UserVolumeState> getUserVolumesState() {
        return userVolumesState;
    }

    public void setUserVolumesState(HashSet<UserVolumeState> userVolumesState) {
        this.userVolumesState = userVolumesState;
    }

    public long getMaxPossibleSizeInBytes() {
        return maxPossibleSizeInBytes;
    }

    public void setMaxPossibleSizeInBytes(long maxPossibleSizeInBytes) {
        this.maxPossibleSizeInBytes = maxPossibleSizeInBytes;
    }

    public boolean isCanBeEnlarged() {
        return canBeEnlarged;
    }

    public void setCanBeEnlarged(boolean canBeEnlarged) {
        this.canBeEnlarged = canBeEnlarged;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (canBeEnlarged ? 1231 : 1237);
        result = prime * result
            + (int) (maxPossibleSizeInBytes ^ (maxPossibleSizeInBytes >>> 32));
        result = prime
            * result
            + ((replicationSetUID == null) ? 0 : replicationSetUID
            .hashCode());
        result = prime
            * result
            + ((userVolumesState == null) ? 0 : userVolumesState.hashCode());
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
        ReplicationSetVolumesState other = (ReplicationSetVolumesState) obj;
        if (canBeEnlarged != other.canBeEnlarged)
            return false;
        if (maxPossibleSizeInBytes != other.maxPossibleSizeInBytes)
            return false;
        if (replicationSetUID == null) {
            if (other.replicationSetUID != null)
                return false;
        } else if (!replicationSetUID.equals(other.replicationSetUID))
            return false;
        if (userVolumesState == null) {
            if (other.userVolumesState != null)
                return false;
        } else if (!userVolumesState.equals(other.userVolumesState))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ReplicationSetVolumesState [replicationSetUID=")
            .append(replicationSetUID).append(", userVolumesState=")
            .append(userVolumesState).append(", maxPossibleSizeInBytes=")
            .append(maxPossibleSizeInBytes).append(", canBeEnlarged=")
            .append(canBeEnlarged).append("]");
        return builder.toString();
    }
}
