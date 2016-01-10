package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VCenterServerUID")
public class VCenterServerUID implements Validateable {

    @XmlElement(nillable = true, required = true)
    private ClusterUID clusterUID;
    @XmlElement(required = true)
    private String ip;

    public VCenterServerUID() {
    }

    public VCenterServerUID(ClusterUID clusterUID, String ip) {
        this.ip = ip;
        this.clusterUID = clusterUID;
    }

    public ClusterUID getClusterUID() {
        return clusterUID;
    }

    public void setClusterUID(ClusterUID clusterUID) {
        this.clusterUID = clusterUID;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ip == null) ? 0 : ip.hashCode());
        result = prime * result + ((clusterUID == null) ? 0 : clusterUID.hashCode());
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
        VCenterServerUID other = (VCenterServerUID) obj;
        if (ip == null) {
            if (other.ip != null)
                return false;
        } else if (!ip.equals(other.ip))
            return false;
        if (clusterUID == null) {
            if (other.clusterUID != null)
                return false;
        } else if (!clusterUID.equals(other.clusterUID))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("VCenterServerUID [ip=").append(ip).append(", clusterUID=")
            .append(clusterUID).append("]");
        return builder.toString();
    }
}
