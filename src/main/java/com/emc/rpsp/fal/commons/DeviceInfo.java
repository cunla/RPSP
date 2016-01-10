package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "DeviceInfo")
public class DeviceInfo {

    private DeviceUID volumeUID;
    private String oldVolumeName;

    public DeviceInfo() {
    }

    public DeviceInfo(DeviceUID volumeUID, String oldVolumeName) {
        this.volumeUID = volumeUID;
        this.oldVolumeName = oldVolumeName;
    }

    public DeviceUID getVolumeUID() {
        return volumeUID;
    }

    public void setVolumeUID(DeviceUID volumeUID) {
        this.volumeUID = volumeUID;
    }

    public String getOldVolumeName() {
        return oldVolumeName;
    }

    public void setOldVolumeName(String oldVolumeName) {
        this.oldVolumeName = oldVolumeName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((oldVolumeName == null) ? 0 : oldVolumeName.hashCode());
        result = prime * result
            + ((volumeUID == null) ? 0 : volumeUID.hashCode());
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
        DeviceInfo other = (DeviceInfo) obj;
        if (oldVolumeName == null) {
            if (other.oldVolumeName != null)
                return false;
        } else if (!oldVolumeName.equals(other.oldVolumeName))
            return false;
        if (volumeUID == null) {
            if (other.volumeUID != null)
                return false;
        } else if (!volumeUID.equals(other.volumeUID))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("DeviceInfo [oldVolumeName=").append(oldVolumeName)
            .append(", volumeUID=").append(volumeUID).append("]");
        return builder.toString();
    }
}
