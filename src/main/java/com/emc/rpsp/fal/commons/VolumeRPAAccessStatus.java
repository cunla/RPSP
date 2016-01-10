package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VolumeRPAAccessStatus")
public class VolumeRPAAccessStatus {

    @XmlElement(nillable = true)
    private RpaUID rpaUID;
    private VolumeStatus accessStatus;

    public VolumeRPAAccessStatus() {
    }

    public VolumeRPAAccessStatus(RpaUID rpaUID, VolumeStatus accessStatus) {
        this.rpaUID = rpaUID;
        this.accessStatus = accessStatus;
    }

    public RpaUID getRpaUID() {
        return rpaUID;
    }

    public void setRpaUID(RpaUID rpaUID) {
        this.rpaUID = rpaUID;
    }

    public VolumeStatus getAccessStatus() {
        return accessStatus;
    }

    public void setAccessStatus(VolumeStatus accessStatus) {
        this.accessStatus = accessStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((accessStatus == null) ? 0 : accessStatus.hashCode());
        result = prime * result + ((rpaUID == null) ? 0 : rpaUID.hashCode());
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
        VolumeRPAAccessStatus other = (VolumeRPAAccessStatus) obj;
        if (accessStatus == null) {
            if (other.accessStatus != null)
                return false;
        } else if (!accessStatus.equals(other.accessStatus))
            return false;
        if (rpaUID == null) {
            if (other.rpaUID != null)
                return false;
        } else if (!rpaUID.equals(other.rpaUID))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("VolumeRPAAccessStatus [accessStatus=").append(
            accessStatus).append(", rpaUID=").append(rpaUID).append("]");
        return builder.toString();
    }
}
