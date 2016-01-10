package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterVersionState")
public class ClusterVersionState {

    @XmlElement(nillable = true)
    private Features features;
    private String version;
    @XmlElement(nillable = true)
    private ClusterUID clusterUID;

    public ClusterVersionState() {
    }

    public ClusterVersionState(Features features, String version, ClusterUID clusterUID) {
        this.features = features;
        this.version = version;
        this.clusterUID = clusterUID;
    }

    public Features getFeatures() {
        return features;
    }

    public String getVersion() {
        return version;
    }

    public ClusterUID getClusterUID() {
        return clusterUID;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setClusterUID(ClusterUID clusterUID) {
        this.clusterUID = clusterUID;
    }

    public void setFeatures(Features features) {
        this.features = features;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((features == null) ? 0 : features.hashCode());
        result = prime * result + ((clusterUID == null) ? 0 : clusterUID.hashCode());
        result = prime * result + ((version == null) ? 0 : version.hashCode());
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
        ClusterVersionState other = (ClusterVersionState) obj;
        if (features == null) {
            if (other.features != null)
                return false;
        } else if (!features.equals(other.features))
            return false;
        if (clusterUID == null) {
            if (other.clusterUID != null)
                return false;
        } else if (!clusterUID.equals(other.clusterUID))
            return false;
        if (version == null) {
            if (other.version != null)
                return false;
        } else if (!version.equals(other.version))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ClusterVersionState [features=").append(features)
            .append(", version=").append(version).append(", clusterUID=")
            .append(clusterUID).append("]");
        return builder.toString();
    }


}
