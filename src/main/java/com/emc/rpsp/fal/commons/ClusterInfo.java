package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterInfo")
public class ClusterInfo {

    @XmlElement(nillable = true)
    private ClusterUID clusterUID;
    private String clusterName;

    public ClusterInfo() {
    }

    public ClusterInfo(ClusterUID clusterUID, String clusterName) {
        this.clusterUID = clusterUID;
        this.clusterName = clusterName;
    }

    public ClusterUID getClusterUID() {
        return clusterUID;
    }

    public void setClusterUID(ClusterUID clusterUID) {
        this.clusterUID = clusterUID;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((clusterName == null) ? 0 : clusterName.hashCode());
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
        ClusterInfo other = (ClusterInfo) obj;
        if (clusterName == null) {
            if (other.clusterName != null)
                return false;
        } else if (!clusterName.equals(other.clusterName))
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
        builder.append("ClusterInfo [clusterName=").append(clusterName).append(
            ", clusterUID=").append(clusterUID).append("]");
        return builder.toString();
    }
}
