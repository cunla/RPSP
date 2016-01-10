package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)

@XmlSeeAlso({UserVolumeSettings.class, RepositoryVolumeSettings.class, JournalVolumeSettings.class})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "JsonSubType")
@JsonSubTypes({
    @Type(value = UserVolumeSettings.class, name = "UserVolumeSettings"),
    @Type(value = RepositoryVolumeSettings.class, name = "RepositoryVolumeSettings"),
    @Type(value = JournalVolumeSettings.class, name = "JournalVolumeSettings")})
@XmlType(name = "VolumeSettings")
public abstract
@XmlRootElement
class VolumeSettings {

    @XmlElement(nillable = true)
    private VolumeType volumeType;
    @XmlElement(nillable = true)
    private ClusterUID clusterUID;
    private VolumeInformation volumeInfo;

    protected VolumeSettings() {
    }

    protected VolumeSettings(VolumeType type, ClusterUID clusterUID, VolumeInformation volumeInfo) {
        this.volumeType = type;
        this.clusterUID = clusterUID;
        this.volumeInfo = volumeInfo;
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

    public VolumeInformation getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(VolumeInformation volumeInfo) {
        this.volumeInfo = volumeInfo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((clusterUID == null) ? 0 : clusterUID.hashCode());
        result = prime * result
            + ((volumeInfo == null) ? 0 : volumeInfo.hashCode());
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
        VolumeSettings other = (VolumeSettings) obj;
        if (clusterUID == null) {
            if (other.clusterUID != null)
                return false;
        } else if (!clusterUID.equals(other.clusterUID))
            return false;
        if (volumeInfo == null) {
            if (other.volumeInfo != null)
                return false;
        } else if (!volumeInfo.equals(other.volumeInfo))
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
        builder.append("VolumeSettings [clusterUID=").append(clusterUID).append(
            ", volumeInfo=").append(volumeInfo).append(", volumeType=")
            .append(volumeType).append("]");
        return builder.toString();
    }
}
