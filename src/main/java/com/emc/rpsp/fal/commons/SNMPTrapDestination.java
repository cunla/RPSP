package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;


@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SNMPTrapDestination")
public class SNMPTrapDestination implements Validateable {

    @XmlElement(nillable = true, required = true)
    private ClusterUID clusterUID;
    @XmlElement(required = true)
    private String targetHostAddress;

    public SNMPTrapDestination() {
    }

    public SNMPTrapDestination(ClusterUID clusterUID, String targetHostAddress) {
        this.clusterUID = clusterUID;
        this.targetHostAddress = targetHostAddress;
    }

    public ClusterUID getClusterUID() {
        return clusterUID;
    }

    public void setClusterUID(ClusterUID clusterUID) {
        this.clusterUID = clusterUID;
    }

    public String getTargetHostAddress() {
        return targetHostAddress;
    }

    public void setTargetHostAddress(String targetHostAddress) {
        this.targetHostAddress = targetHostAddress;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((clusterUID == null) ? 0 : clusterUID.hashCode());
        result = prime
            * result
            + ((targetHostAddress == null) ? 0 : targetHostAddress
            .hashCode());
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
        SNMPTrapDestination other = (SNMPTrapDestination) obj;
        if (clusterUID == null) {
            if (other.clusterUID != null)
                return false;
        } else if (!clusterUID.equals(other.clusterUID))
            return false;
        if (targetHostAddress == null) {
            if (other.targetHostAddress != null)
                return false;
        } else if (!targetHostAddress.equals(other.targetHostAddress))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SNMPTrapDestination [clusterUID=").append(clusterUID).append(
            ", targetHostAddress=").append(targetHostAddress).append("]");
        return builder.toString();
    }
}
