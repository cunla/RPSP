package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClariionVolumes")
public class ClariionVolumes {

    @XmlElement(nillable = true)
    private SplitterUID splitterUID;
    private HashSet<ClariionVolumeInformation> volumesInformation;

    public ClariionVolumes() {
    }

    public ClariionVolumes(SplitterUID splitterUID, HashSet<ClariionVolumeInformation> volumesInformation) {
        this.splitterUID = splitterUID;
        this.volumesInformation = volumesInformation;
    }

    public SplitterUID getSplitterUID() {
        return splitterUID;
    }

    public void setSplitterUID(SplitterUID splitterUID) {
        this.splitterUID = splitterUID;
    }

    public HashSet<ClariionVolumeInformation> getVolumesInformation() {
        return volumesInformation;
    }

    public void setVolumesInformation(HashSet<ClariionVolumeInformation> volumesInformation) {
        this.volumesInformation = volumesInformation;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((splitterUID == null) ? 0 : splitterUID.hashCode());
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
        ClariionVolumes other = (ClariionVolumes) obj;
        if (splitterUID == null) {
            if (other.splitterUID != null)
                return false;
        } else if (!splitterUID.equals(other.splitterUID))
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
        builder.append("ClariionVolumes [splitterUID=").append(splitterUID)
            .append(", volumesInformation=").append(volumesInformation)
            .append("]");
        return builder.toString();
    }
}
