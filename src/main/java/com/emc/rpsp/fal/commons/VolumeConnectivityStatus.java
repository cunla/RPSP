package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

@JsonTypeName("VolumeConnectivityStatus")
@XmlType(name = "VolumeConnectivityStatus")
public class VolumeConnectivityStatus extends ClusterEntityConnectivityStatus {

    private DeviceUID volumeID;
    @XmlElement(nillable = true)
    private VolumeStatus volumeStatus;

    public VolumeConnectivityStatus() {
    }

    public VolumeConnectivityStatus(ClusterUID clusterUID, GeneralStatus connectivityStatus, DeviceUID volumeID, VolumeStatus volumeStatus) {
        super(clusterUID, ClusterEntityType.VOLUME, connectivityStatus);
        this.volumeID = volumeID;
        this.volumeStatus = volumeStatus;
    }

    public VolumeConnectivityStatus(ClusterUID clusterUID, ClusterEntityType entityType, GeneralStatus connectivityStatus, DeviceUID volumeID,
                                    VolumeStatus volumeStatus) {
        this(clusterUID, connectivityStatus, volumeID, volumeStatus);
    }

    public DeviceUID getVolumeID() {
        return volumeID;
    }

    public void setVolumeID(DeviceUID volumeID) {
        this.volumeID = volumeID;
    }

    public VolumeStatus getVolumeStatus() {
        return volumeStatus;
    }

    public void setVolumeStatus(VolumeStatus volumeStatus) {
        this.volumeStatus = volumeStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
            + ((volumeID == null) ? 0 : volumeID.hashCode());
        result = prime * result
            + ((volumeStatus == null) ? 0 : volumeStatus.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        VolumeConnectivityStatus other = (VolumeConnectivityStatus) obj;
        if (volumeID == null) {
            if (other.volumeID != null)
                return false;
        } else if (!volumeID.equals(other.volumeID))
            return false;
        if (volumeStatus == null) {
            if (other.volumeStatus != null)
                return false;
        } else if (!volumeStatus.equals(other.volumeStatus))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append("VolumeConnectivityStatus [volumeID=").append(volumeID)
            .append(", volumeStatus=").append(volumeStatus).append(
            ", super=").append(super.toString()).append("]");
        return builder.toString();
    }
}
