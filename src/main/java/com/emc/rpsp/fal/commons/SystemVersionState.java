package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@XmlRootElement
@XmlType(name = "SystemVersionState")
public class SystemVersionState {

    private Features supportedFeatures;
    private HashSet<ClusterVersionState> clustersVersionState;

    public SystemVersionState() {
    }

    public SystemVersionState(Features supportedFeatures, HashSet<ClusterVersionState> clustersVersionState) {
        this.supportedFeatures = supportedFeatures;
        this.clustersVersionState = clustersVersionState;
    }

    public Features getSupportedFeatures() {
        return supportedFeatures;
    }

    public void setSupportedFeatures(Features supportedFeatures) {
        this.supportedFeatures = supportedFeatures;
    }

    public HashSet<ClusterVersionState> getClustersVersionState() {
        return clustersVersionState;
    }

    public void setClustersVersionState(HashSet<ClusterVersionState> clustersVersionState) {
        this.clustersVersionState = clustersVersionState;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((clustersVersionState == null) ? 0 : clustersVersionState
            .hashCode());
        result = prime
            * result
            + ((supportedFeatures == null) ? 0 : supportedFeatures
            .hashCode());
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
        SystemVersionState other = (SystemVersionState) obj;
        if (clustersVersionState == null) {
            if (other.clustersVersionState != null)
                return false;
        } else if (!clustersVersionState.equals(other.clustersVersionState))
            return false;
        if (supportedFeatures == null) {
            if (other.supportedFeatures != null)
                return false;
        } else if (!supportedFeatures.equals(other.supportedFeatures))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SystemVersionState [supportedFeatures=")
            .append(supportedFeatures).append(", clustersVersionState=")
            .append(clustersVersionState).append("]");
        return builder.toString();
    }
}
