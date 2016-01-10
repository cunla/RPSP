package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VolumeInformationAndPaths")
////@LargeObject
public class VolumeInformationAndPaths {

    @XmlElement(nillable = true)
    private VolumeInformation volumeInformation;
    private HashSet<VolumePath> volumePaths;

    public VolumeInformationAndPaths() {
    }

    public VolumeInformationAndPaths(VolumeInformation volumeInformation, HashSet<VolumePath> volumePaths) {
        this.volumeInformation = volumeInformation;
        this.volumePaths = volumePaths;
    }

    public VolumeInformation getVolumeInformation() {
        return volumeInformation;
    }

    public void setVolumeInformation(VolumeInformation volumeInformation) {
        this.volumeInformation = volumeInformation;
    }

    public HashSet<VolumePath> getVolumePaths() {
        return volumePaths;
    }

    public void setVolumePaths(HashSet<VolumePath> volumePaths) {
        this.volumePaths = volumePaths;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((volumeInformation == null) ? 0 : volumeInformation.hashCode());
        result = prime * result + ((volumePaths == null) ? 0 : volumePaths.hashCode());
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
        VolumeInformationAndPaths other = (VolumeInformationAndPaths) obj;
        if (volumeInformation == null) {
            if (other.volumeInformation != null)
                return false;
        } else if (!volumeInformation.equals(other.volumeInformation))
            return false;
        if (volumePaths == null) {
            if (other.volumePaths != null)
                return false;
        } else if (!volumePaths.equals(other.volumePaths))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("VolumeInformationAndPaths [volumeInformation=").append(volumeInformation).append(", volumePaths=").append(volumePaths).append("]");
        return builder.toString();
    }


}
