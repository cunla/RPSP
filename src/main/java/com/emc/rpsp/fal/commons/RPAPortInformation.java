package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "RPAPortInformation")
public class RPAPortInformation {

    private String portWWN;
    private String nodeWWN;
    private long portIndex;

    public RPAPortInformation() {
    }

    public RPAPortInformation(String portWWN, String nodeWWN, long portIndex) {
        this.portWWN = portWWN;
        this.nodeWWN = nodeWWN;
        this.portIndex = portIndex;
    }

    public String getPortWWN() {
        return portWWN;
    }

    public void setPortWWN(String portWWN) {
        this.portWWN = portWWN;
    }

    public String getNodeWWN() {
        return nodeWWN;
    }

    public void setNodeWWN(String nodeWWN) {
        this.nodeWWN = nodeWWN;
    }

    public long getPortIndex() {
        return portIndex;
    }

    public void setPortIndex(long portIndex) {
        this.portIndex = portIndex;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nodeWWN == null) ? 0 : nodeWWN.hashCode());
        result = prime * result + (int) (portIndex ^ (portIndex >>> 32));
        result = prime * result + ((portWWN == null) ? 0 : portWWN.hashCode());
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
        RPAPortInformation other = (RPAPortInformation) obj;
        if (nodeWWN == null) {
            if (other.nodeWWN != null)
                return false;
        } else if (!nodeWWN.equals(other.nodeWWN))
            return false;
        if (portIndex != other.portIndex)
            return false;
        if (portWWN == null) {
            if (other.portWWN != null)
                return false;
        } else if (!portWWN.equals(other.portWWN))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RPAPortInformation [portWWN=").append(portWWN)
            .append(", nodeWWN=").append(nodeWWN).append(", portIndex=")
            .append(portIndex).append("]");
        return builder.toString();
    }


}
