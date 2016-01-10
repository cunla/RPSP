package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterSANVolumes")
//@LargeObject
public class ClusterSANVolumes {

    @XmlElement(nillable = true)
    private ClusterUID clusterUID;
    private HashSet<VolumeInformation> volumesInformation;

    public ClusterSANVolumes() {
    }

    public ClusterSANVolumes(ClusterUID clusterUID,
                             HashSet<VolumeInformation> volumesInformation) {
        this.clusterUID = clusterUID;
        this.volumesInformation = volumesInformation;
    }

    public ClusterUID getClusterUID() {
        return clusterUID;
    }

    public void setClusterUID(ClusterUID clusterUID) {
        this.clusterUID = clusterUID;
    }

    public HashSet<VolumeInformation> getVolumesInformation() {
        return volumesInformation;
    }

    public void setVolumesInformation(HashSet<VolumeInformation> volumesInformation) {
        this.volumesInformation = volumesInformation;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((clusterUID == null) ? 0 : clusterUID.hashCode());
        result = prime
            * result
            + ((volumesInformation == null) ? 0 : volumesInformation
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
        ClusterSANVolumes other = (ClusterSANVolumes) obj;
        if (clusterUID == null) {
            if (other.clusterUID != null)
                return false;
        } else if (!clusterUID.equals(other.clusterUID))
            return false;
        if (volumesInformation == null) {
            if (other.volumesInformation != null)
                return false;
        } else if (!volumesInformation.equals(other.volumesInformation))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ClusterSANVolumes [clusterUID=").append(clusterUID).append(
            ", volumesInformation=").append(volumesInformation).append("]");
        return builder.toString();
    }
}
