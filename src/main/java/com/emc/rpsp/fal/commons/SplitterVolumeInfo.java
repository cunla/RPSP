package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SplitterVolumeInfo")
public class SplitterVolumeInfo {

    @XmlElement(nillable = true)
    private SplitterVolume splitterVolume;
    private String splitterName;
    private String volumeName;

    public SplitterVolumeInfo() {
    }

    public SplitterVolumeInfo(SplitterVolume splitterVolume, String splitterName, String volumeName) {
        this.splitterVolume = splitterVolume;
        this.splitterName = splitterName;
        this.volumeName = volumeName;
    }

    public SplitterVolume getSplitterVolume() {
        return splitterVolume;
    }

    public void setSplitterVolume(SplitterVolume splitterVolume) {
        this.splitterVolume = splitterVolume;
    }

    public String getSplitterName() {
        return splitterName;
    }

    public void setSplitterName(String splitterName) {
        this.splitterName = splitterName;
    }

    public String getVolumeName() {
        return volumeName;
    }

    public void setVolumeName(String volumeName) {
        this.volumeName = volumeName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((splitterName == null) ? 0 : splitterName.hashCode());
        result = prime * result
            + ((splitterVolume == null) ? 0 : splitterVolume.hashCode());
        result = prime * result
            + ((volumeName == null) ? 0 : volumeName.hashCode());
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
        SplitterVolumeInfo other = (SplitterVolumeInfo) obj;
        if (splitterName == null) {
            if (other.splitterName != null)
                return false;
        } else if (!splitterName.equals(other.splitterName))
            return false;
        if (splitterVolume == null) {
            if (other.splitterVolume != null)
                return false;
        } else if (!splitterVolume.equals(other.splitterVolume))
            return false;
        if (volumeName == null) {
            if (other.volumeName != null)
                return false;
        } else if (!volumeName.equals(other.volumeName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SplitterVolumeInfo [splitterName=")
            .append(splitterName).append(", splitterVolume=").append(
            splitterVolume).append(", volumeName=").append(
            volumeName).append("]");
        return builder.toString();
    }
}
