package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)

@XmlSeeAlso({RPAConnectivityStatus.class, VolumeConnectivityStatus.class, SplitterConnectivityStatus.class})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "JsonSubType")
@JsonSubTypes({
    @Type(value = RPAConnectivityStatus.class, name = "RPAConnectivityStatus"),
    @Type(value = VolumeConnectivityStatus.class, name = "VolumeConnectivityStatus"),
    @Type(value = SplitterConnectivityStatus.class, name = "SplitterConnectivityStatus")})
@XmlType(name = "ClusterEntityConnectivityStatus")
public abstract
@XmlRootElement
class ClusterEntityConnectivityStatus {

    @XmlElement(nillable = true)
    private ClusterUID clusterUID;
    private ClusterEntityType entityType;
    private GeneralStatus connectivityStatus;

    protected ClusterEntityConnectivityStatus() {
    }

    protected ClusterEntityConnectivityStatus(ClusterUID clusterUID, ClusterEntityType entityType, GeneralStatus connectivityStatus) {
        this.clusterUID = clusterUID;
        this.entityType = entityType;
        this.connectivityStatus = connectivityStatus;
    }

    public ClusterUID getClusterUID() {
        return clusterUID;
    }

    public void setClusterUID(ClusterUID clusterUID) {
        this.clusterUID = clusterUID;
    }

    public ClusterEntityType getEntityType() {
        return entityType;
    }

    public void setEntityType(ClusterEntityType entityType) {
        this.entityType = entityType;
    }

    public GeneralStatus getConnectivityStatus() {
        return connectivityStatus;
    }

    public void setConnectivityStatus(GeneralStatus connectivityStatus) {
        this.connectivityStatus = connectivityStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((connectivityStatus == null) ? 0 : connectivityStatus
            .hashCode());
        result = prime * result
            + ((entityType == null) ? 0 : entityType.hashCode());
        result = prime * result + ((clusterUID == null) ? 0 : clusterUID.hashCode());
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
        ClusterEntityConnectivityStatus other = (ClusterEntityConnectivityStatus) obj;
        if (connectivityStatus == null) {
            if (other.connectivityStatus != null)
                return false;
        } else if (!connectivityStatus.equals(other.connectivityStatus))
            return false;
        if (entityType == null) {
            if (other.entityType != null)
                return false;
        } else if (!entityType.equals(other.entityType))
            return false;
        if (clusterUID == null) {
            if (other.clusterUID != null)
                return false;
        } else if (!clusterUID.equals(other.clusterUID))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ClusterEntityConnectivityStatus [connectivityStatus=")
            .append(connectivityStatus).append(", entityType=").append(
            entityType).append(", clusterUID=").append(clusterUID)
            .append("]");
        return builder.toString();
    }
}
