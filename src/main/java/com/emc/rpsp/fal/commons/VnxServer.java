package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VnxServer")
public class VnxServer {

    @XmlElement(nillable = true)
    private VnxUID vnxUID;
    private String username;
    @XmlElement(nillable = true)
    private AuthenticationType authenticationType;
    private boolean certificateConfigured;
    private HashSet<VnxEndPoint> endPoints;

    public VnxServer() {

    }

    public VnxServer(VnxUID vnxUID, String username, AuthenticationType authenticationType,
                     boolean certificateConfigured, HashSet<VnxEndPoint> endPoints) {
        this.vnxUID = vnxUID;
        this.username = username;
        this.authenticationType = authenticationType;
        this.certificateConfigured = certificateConfigured;
        this.endPoints = endPoints;
    }

    public VnxUID getVnxUID() {
        return vnxUID;
    }

    public void setVnxUID(VnxUID vnxUID) {
        this.vnxUID = vnxUID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AuthenticationType getAuthenticationType() {
        return authenticationType;
    }

    public void setAuthenticationType(AuthenticationType authenticationType) {
        this.authenticationType = authenticationType;
    }

    public boolean isCertificateConfigured() {
        return certificateConfigured;
    }

    public void setCertificateConfigured(boolean certificateConfigured) {
        this.certificateConfigured = certificateConfigured;
    }

    public HashSet<VnxEndPoint> getEndPoints() {
        return endPoints;
    }

    public void setEndPoints(HashSet<VnxEndPoint> endPoints) {
        this.endPoints = endPoints;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((authenticationType == null) ? 0 : authenticationType
            .hashCode());
        result = prime * result + (certificateConfigured ? 1231 : 1237);
        result = prime * result
            + ((endPoints == null) ? 0 : endPoints.hashCode());
        result = prime * result
            + ((username == null) ? 0 : username.hashCode());
        result = prime * result + ((vnxUID == null) ? 0 : vnxUID.hashCode());
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
        VnxServer other = (VnxServer) obj;
        if (authenticationType != other.authenticationType)
            return false;
        if (certificateConfigured != other.certificateConfigured)
            return false;
        if (endPoints == null) {
            if (other.endPoints != null)
                return false;
        } else if (!endPoints.equals(other.endPoints))
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        if (vnxUID == null) {
            if (other.vnxUID != null)
                return false;
        } else if (!vnxUID.equals(other.vnxUID))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("VnxServer [vnxUID=").append(vnxUID)
            .append(", username=").append(username)
            .append(", authenticationType=").append(authenticationType)
            .append(", certificateConfigured=")
            .append(certificateConfigured).append(", endPoints=")
            .append(endPoints).append("]");
        return builder.toString();
    }
}
