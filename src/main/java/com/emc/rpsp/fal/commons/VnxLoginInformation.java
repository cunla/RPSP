package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VnxLoginInformation")
public class VnxLoginInformation implements Validateable {

    private HashSet<VnxEndPoint> endPoints;
    @XmlElement(nillable = true)
    private VnxCredentials vnxCredentials;

    public VnxLoginInformation() {
    }

    public VnxLoginInformation(HashSet<VnxEndPoint> endPoints, VnxCredentials vnxCredentials) {
        this.endPoints = endPoints;
        this.vnxCredentials = vnxCredentials;
    }

    public HashSet<VnxEndPoint> getEndPoints() {
        return endPoints;
    }

    public void setEndPoints(HashSet<VnxEndPoint> endPoints) {
        this.endPoints = endPoints;
    }

    public VnxCredentials getVnxCredentials() {
        return vnxCredentials;
    }

    public void setVnxCredentials(VnxCredentials vnxCredentials) {
        this.vnxCredentials = vnxCredentials;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((endPoints == null) ? 0 : endPoints.hashCode());
        result = prime * result
            + ((vnxCredentials == null) ? 0 : vnxCredentials.hashCode());
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
        VnxLoginInformation other = (VnxLoginInformation) obj;
        if (endPoints == null) {
            if (other.endPoints != null)
                return false;
        } else if (!endPoints.equals(other.endPoints))
            return false;
        if (vnxCredentials == null) {
            if (other.vnxCredentials != null)
                return false;
        } else if (!vnxCredentials.equals(other.vnxCredentials))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("VnxLoginInformation [endPoints=").append(endPoints)
            .append(", vnxCredentials=").append(vnxCredentials).append("]");
        return builder.toString();
    }

}
