package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement

@JsonTypeName("FiberChannelInitiatorInformation")
@XmlType(name = "FiberChannelInitiatorInformation")
public class FiberChannelInitiatorInformation extends InitiatorInformation {

    private String portWWN;
    private String nodeWWN;

    public FiberChannelInitiatorInformation() {
    }

    public FiberChannelInitiatorInformation(String portWWN, String nodeWWN) {
        this.portWWN = portWWN;
        this.nodeWWN = nodeWWN;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nodeWWN == null) ? 0 : nodeWWN.hashCode());
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
        FiberChannelInitiatorInformation other = (FiberChannelInitiatorInformation) obj;
        if (nodeWWN == null) {
            if (other.nodeWWN != null)
                return false;
        } else if (!nodeWWN.equals(other.nodeWWN))
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
        builder.append("FiberChannelInitiatorInformation [portWWN=").append(portWWN).append(", nodeWWN=").append(nodeWWN).append("]");
        return builder.toString();
    }

}
