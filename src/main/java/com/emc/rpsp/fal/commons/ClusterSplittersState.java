package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterSplittersState")
//@LargeObject
public class ClusterSplittersState {

    @XmlElement(nillable = true)
    private ClusterUID clusterUID;
    private HashSet<SplitterState> splittersState;

    public ClusterSplittersState() {
    }

    public ClusterSplittersState(ClusterUID clusterUID, HashSet<SplitterState> splittersState) {
        this.clusterUID = clusterUID;
        this.splittersState = splittersState;
    }

    public ClusterUID getClusterUID() {
        return clusterUID;
    }

    public void setClusterUID(ClusterUID clusterUID) {
        this.clusterUID = clusterUID;
    }

    public HashSet<SplitterState> getSplittersState() {
        return splittersState;
    }

    public void setSplittersState(HashSet<SplitterState> splittersState) {
        this.splittersState = splittersState;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((clusterUID == null) ? 0 : clusterUID.hashCode());
        result = prime * result
            + ((splittersState == null) ? 0 : splittersState.hashCode());
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
        ClusterSplittersState other = (ClusterSplittersState) obj;
        if (clusterUID == null) {
            if (other.clusterUID != null)
                return false;
        } else if (!clusterUID.equals(other.clusterUID))
            return false;
        if (splittersState == null) {
            if (other.splittersState != null)
                return false;
        } else if (!splittersState.equals(other.splittersState))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ClusterSplittersState [clusterUID=").append(clusterUID).append(
            ", splittersState=").append(splittersState).append("]");
        return builder.toString();
    }
}
