package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;


@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterSyslogHost")
public class ClusterSyslogHost implements Validateable {

    @XmlElement(nillable = true, required = true)
    private ClusterUID clusterUID;
    @XmlElement(required = true)
    private String hostAddress;

    public ClusterSyslogHost() {
    }

    public ClusterSyslogHost(ClusterUID clusterUID, String hostAddress) {
        this.clusterUID = clusterUID;
        this.hostAddress = hostAddress;
    }

    public ClusterUID getClusterUID() {
        return clusterUID;
    }

    public void setClusterUID(ClusterUID clusterUID) {
        this.clusterUID = clusterUID;
    }

    public String getHostAddress() {
        return hostAddress;
    }

    public void setHostAddress(String hostAddress) {
        this.hostAddress = hostAddress;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((hostAddress == null) ? 0 : hostAddress.hashCode());
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
        ClusterSyslogHost other = (ClusterSyslogHost) obj;
        if (hostAddress == null) {
            if (other.hostAddress != null)
                return false;
        } else if (!hostAddress.equals(other.hostAddress))
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
        builder.append("ClusterSyslogHost [hostAddress=").append(hostAddress)
            .append(", clusterUID=").append(clusterUID).append("]");
        return builder.toString();
    }
}
