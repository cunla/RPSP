package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.HashSet;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterVnxServers")
public class ClusterVnxServers {

    @XmlElement(nillable = true)
    private ClusterUID clusterUID;
    private HashSet<VnxServer> vnxServers;

    public ClusterVnxServers() {

    }

    public ClusterVnxServers(ClusterUID clusterUID, HashSet<VnxServer> vnxServers) {
        this.clusterUID = clusterUID;
        this.vnxServers = vnxServers;
    }

    public ClusterUID getClusterUID() {
        return clusterUID;
    }

    public void setClusterUID(ClusterUID clusterUID) {
        this.clusterUID = clusterUID;
    }

    public HashSet<VnxServer> getVnxServers() {
        return vnxServers;
    }

    public void setVnxServers(HashSet<VnxServer> vnxServers) {
        this.vnxServers = vnxServers;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((clusterUID == null) ? 0 : clusterUID.hashCode());
        result = prime * result
            + ((vnxServers == null) ? 0 : vnxServers.hashCode());
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
        ClusterVnxServers other = (ClusterVnxServers) obj;
        if (clusterUID == null) {
            if (other.clusterUID != null)
                return false;
        } else if (!clusterUID.equals(other.clusterUID))
            return false;
        if (vnxServers == null) {
            if (other.vnxServers != null)
                return false;
        } else if (!vnxServers.equals(other.vnxServers))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ClusterVnxServers [clusterUID=").append(clusterUID)
            .append(", vnxServers=").append(vnxServers).append("]");
        return builder.toString();
    }

}
