package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.LinkedList;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterRPAsState")
//@LargeObject
public class ClusterRPAsState {

    @XmlElement(nillable = true)
    private ClusterUID clusterUID;
    private LinkedList<RPAState> rpasState;

    public ClusterRPAsState() {
    }

    public ClusterRPAsState(ClusterUID clusterUID, LinkedList<RPAState> rpasState) {
        this.clusterUID = clusterUID;
        this.rpasState = rpasState;
    }

    public ClusterUID getClusterUID() {
        return clusterUID;
    }

    public void setClusterUID(ClusterUID clusterUID) {
        this.clusterUID = clusterUID;
    }

    public LinkedList<RPAState> getRpasState() {
        return rpasState;
    }

    public void setRpasState(LinkedList<RPAState> rpasState) {
        this.rpasState = rpasState;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((rpasState == null) ? 0 : rpasState.hashCode());
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
        ClusterRPAsState other = (ClusterRPAsState) obj;
        if (rpasState == null) {
            if (other.rpasState != null)
                return false;
        } else if (!rpasState.equals(other.rpasState))
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
        builder.append(super.toString());
        builder.append("ClusterRPAsState [rpasState=").append(rpasState).append(
            ", clusterUID=").append(clusterUID).append("]");
        return builder.toString();
    }
}
