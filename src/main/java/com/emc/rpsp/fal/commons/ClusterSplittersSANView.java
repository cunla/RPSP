package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterSplittersSANView")
//@LargeObject
public class ClusterSplittersSANView {

    @XmlElement(nillable = true)
    private ClusterUID clusterUID;
    private HashSet<SplitterSANView> splittersSANView;

    public ClusterSplittersSANView() {
    }

    public ClusterSplittersSANView(ClusterUID clusterUID,
                                   HashSet<SplitterSANView> splittersSANView) {
        this.clusterUID = clusterUID;
        this.splittersSANView = splittersSANView;
    }

    public ClusterUID getClusterUID() {
        return clusterUID;
    }

    public void setClusterUID(ClusterUID clusterUID) {
        this.clusterUID = clusterUID;
    }

    public HashSet<SplitterSANView> getSplittersSANView() {
        return splittersSANView;
    }

    public void setSplittersSANView(HashSet<SplitterSANView> splittersSANView) {
        this.splittersSANView = splittersSANView;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((clusterUID == null) ? 0 : clusterUID.hashCode());
        result = prime
            * result
            + ((splittersSANView == null) ? 0 : splittersSANView.hashCode());
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
        ClusterSplittersSANView other = (ClusterSplittersSANView) obj;
        if (clusterUID == null) {
            if (other.clusterUID != null)
                return false;
        } else if (!clusterUID.equals(other.clusterUID))
            return false;
        if (splittersSANView == null) {
            if (other.splittersSANView != null)
                return false;
        } else if (!splittersSANView.equals(other.splittersSANView))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ClusterSplittersSANView [clusterUID=").append(clusterUID)
            .append(", splittersSANView=").append(splittersSANView).append(
            "]");
        return builder.toString();
    }
}
