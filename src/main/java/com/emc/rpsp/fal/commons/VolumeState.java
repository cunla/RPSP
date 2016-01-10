package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@XmlAccessorType(XmlAccessType.FIELD)

@XmlSeeAlso({RepositoryVolumeState.class, UserVolumeState.class, JournalVolumeState.class})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "JsonSubType")
@JsonSubTypes({
    @Type(value = RepositoryVolumeState.class, name = "RepositoryVolumeState"),
    @Type(value = UserVolumeState.class, name = "UserVolumeState"),
    @Type(value = JournalVolumeState.class, name = "JournalVolumeState")})
@XmlType(name = "VolumeState")
public abstract
@XmlRootElement
class VolumeState {

    @XmlElement(nillable = true)
    private VolumeType volumeType;
    @XmlElement(nillable = true)
    private ClusterUID clusterUID;
    private DeviceUID volumeID;
    private HashSet<VolumeRPAAccessStatus> rpasAccessStatus;

    protected VolumeState() {
    }

    protected VolumeState(VolumeType type, ClusterUID clusterUID, DeviceUID volumeID, HashSet<VolumeRPAAccessStatus> rpasAccessStatus) {
        this.volumeType = type;
        this.clusterUID = clusterUID;
        this.volumeID = volumeID;
        this.rpasAccessStatus = rpasAccessStatus;
    }

    public VolumeType getVolumeType() {
        return volumeType;
    }

    public void setVolumeType(VolumeType volumeType) {
        this.volumeType = volumeType;
    }

    public ClusterUID getClusterUID() {
        return clusterUID;
    }

    public void setClusterUID(ClusterUID clusterUID) {
        this.clusterUID = clusterUID;
    }

    public DeviceUID getVolumeID() {
        return volumeID;
    }

    public void setVolumeID(DeviceUID volumeID) {
        this.volumeID = volumeID;
    }

    public HashSet<VolumeRPAAccessStatus> getRpasAccessStatus() {
        return rpasAccessStatus;
    }

    public void setRpasAccessStatus(HashSet<VolumeRPAAccessStatus> rpasAccessStatus) {
        this.rpasAccessStatus = rpasAccessStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((rpasAccessStatus == null) ? 0 : rpasAccessStatus.hashCode());
        result = prime * result + ((clusterUID == null) ? 0 : clusterUID.hashCode());
        result = prime * result
            + ((volumeID == null) ? 0 : volumeID.hashCode());
        result = prime * result
            + ((volumeType == null) ? 0 : volumeType.hashCode());
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
        VolumeState other = (VolumeState) obj;
        if (rpasAccessStatus == null) {
            if (other.rpasAccessStatus != null)
                return false;
        } else if (!rpasAccessStatus.equals(other.rpasAccessStatus))
            return false;
        if (clusterUID == null) {
            if (other.clusterUID != null)
                return false;
        } else if (!clusterUID.equals(other.clusterUID))
            return false;
        if (volumeID == null) {
            if (other.volumeID != null)
                return false;
        } else if (!volumeID.equals(other.volumeID))
            return false;
        if (volumeType == null) {
            if (other.volumeType != null)
                return false;
        } else if (!volumeType.equals(other.volumeType))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("VolumeState [rpasAccessStatus=").append(
            rpasAccessStatus).append(", clusterUID=").append(clusterUID).append(
            ", volumeID=").append(volumeID).append(", volumeType=").append(
            volumeType).append("]");
        return builder.toString();
    }
}
