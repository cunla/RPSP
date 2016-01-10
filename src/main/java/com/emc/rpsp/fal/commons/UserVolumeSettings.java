package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

@JsonTypeName("UserVolumeSettings")
@XmlType(name = "UserVolumeSettings")
public class UserVolumeSettings extends VolumeSettings {

    private ConsistencyGroupCopyUID groupCopyUID;
    @XmlElement(nillable = true)
    private ReplicationSetUID replicationSetUID;
    private HashSet<SplitterUID> attachedSplitters;

    public UserVolumeSettings() {
    }

    public UserVolumeSettings(ConsistencyGroupCopyUID groupCopyUID, ReplicationSetUID replicationSetUID, VolumeInformation volumeInformation,
                              HashSet<SplitterUID> attachedSplitters) {
        super(VolumeType.USER, groupCopyUID.getGlobalCopyUID().getClusterUID(), volumeInformation);
        this.groupCopyUID = groupCopyUID;
        this.replicationSetUID = replicationSetUID;
        this.attachedSplitters = attachedSplitters;
    }

    public UserVolumeSettings(VolumeType type, ClusterUID clusterUID, VolumeInformation volumeInfo, ConsistencyGroupCopyUID groupCopyUID,
                              ReplicationSetUID replicationSetUID, HashSet<SplitterUID> attachedSplittersNames) {
        this(groupCopyUID, replicationSetUID, volumeInfo, attachedSplittersNames);
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

    public HashSet<SplitterUID> getAttachedSplitters() {
        return attachedSplitters;
    }

    public void setAttachedSplitters(HashSet<SplitterUID> attachedSplittersNames) {
        this.attachedSplitters = attachedSplittersNames;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime
            * result
            + ((attachedSplitters == null) ? 0 : attachedSplitters
            .hashCode());
        result = prime * result
            + ((groupCopyUID == null) ? 0 : groupCopyUID.hashCode());
        result = prime
            * result
            + ((replicationSetUID == null) ? 0 : replicationSetUID
            .hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserVolumeSettings other = (UserVolumeSettings) obj;
        if (attachedSplitters == null) {
            if (other.attachedSplitters != null)
                return false;
        } else if (!attachedSplitters.equals(other.attachedSplitters))
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
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserVolumeSettings [attachedSplitters=").append(
            attachedSplitters).append(", groupCopyUID=").append(
            groupCopyUID).append(", replicationSetUID=").append(
            replicationSetUID).append(", super=").append(super.toString()).append("]");
        return builder.toString();
    }
}
