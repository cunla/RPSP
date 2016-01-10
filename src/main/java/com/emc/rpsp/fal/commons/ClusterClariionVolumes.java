package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterClariionVolumes")
//@LargeObject
public class ClusterClariionVolumes {

    @XmlElement(nillable = true)
    private ClusterUID clusterUID;
    private HashSet<ClariionVolumes> clariionsView;

    public ClusterClariionVolumes() {
    }

    public ClusterClariionVolumes(ClusterUID clusterUID, HashSet<ClariionVolumes> clariionsView) {
        this.clusterUID = clusterUID;
        this.clariionsView = clariionsView;
    }

    public ClusterUID getClusterUID() {
        return clusterUID;
    }

    public void setClusterUID(ClusterUID clusterUID) {
        this.clusterUID = clusterUID;
    }

    public HashSet<ClariionVolumes> getClariionsView() {
        return clariionsView;
    }

    public void setClariionsView(HashSet<ClariionVolumes> clariionsView) {
        this.clariionsView = clariionsView;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((clariionsView == null) ? 0 : clariionsView.hashCode());
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
        ClusterClariionVolumes other = (ClusterClariionVolumes) obj;
        if (clariionsView == null) {
            if (other.clariionsView != null)
                return false;
        } else if (!clariionsView.equals(other.clariionsView))
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
        builder.append("ClusterClariionVolumes [clariionsView=").append(
            clariionsView).append(", clusterUID=").append(clusterUID).append("]");
        return builder.toString();
    }
}
