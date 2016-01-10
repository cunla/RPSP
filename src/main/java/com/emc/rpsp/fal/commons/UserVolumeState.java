package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

@JsonTypeName("UserVolumeState")
@XmlType(name = "UserVolumeState")
public class UserVolumeState extends VolumeState {

    private ConsistencyGroupCopyUID groupCopyUID;
    @XmlElement(nillable = true)
    private ReplicationSetUID replicationSetUID;

    public UserVolumeState() {
    }

    public UserVolumeState(ConsistencyGroupCopyUID groupCopyUID, ReplicationSetUID replicationSetUID, DeviceUID volumeID,
                           HashSet<VolumeRPAAccessStatus> rpasAccessStatus) {
        super(VolumeType.USER, groupCopyUID.getGlobalCopyUID().getClusterUID(), volumeID, rpasAccessStatus);
        this.groupCopyUID = groupCopyUID;
        this.replicationSetUID = replicationSetUID;
    }

    public UserVolumeState(VolumeType type, ClusterUID clusterUID, DeviceUID volumeID, HashSet<VolumeRPAAccessStatus> rpasAccessStatus,
                           ConsistencyGroupCopyUID groupCopyUID, ReplicationSetUID replicationSetUID) {
        this(groupCopyUID, replicationSetUID, volumeID, rpasAccessStatus);
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
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
        UserVolumeState other = (UserVolumeState) obj;
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
        builder.append(super.toString());
        builder.append("UserVolumeState [groupCopyUID=").append(groupCopyUID)
            .append(", replicationSetUID=").append(replicationSetUID).append(", super=").append(super.toString())
            .append("]");
        return builder.toString();
    }
}
