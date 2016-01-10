package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "GatewayInformation")
public class GatewayInformation {

    private String destinationSubnet;
    private String destinationNetworkMask;
    private IPInformation gatewayIP;

    public GatewayInformation() {
    }

    public GatewayInformation(String destinationSubnet,
                              String destinationNetworkMask, IPInformation gatewayIP) {
        this.destinationSubnet = destinationSubnet;
        this.destinationNetworkMask = destinationNetworkMask;
        this.gatewayIP = gatewayIP;
    }

    public String getDestinationSubnet() {
        return destinationSubnet;
    }

    public void setDestinationSubnet(String destinationSubnet) {
        this.destinationSubnet = destinationSubnet;
    }

    public String getDestinationNetworkMask() {
        return destinationNetworkMask;
    }

    public void setDestinationNetworkMask(String destinationNetworkMask) {
        this.destinationNetworkMask = destinationNetworkMask;
    }

    public IPInformation getGatewayIP() {
        return gatewayIP;
    }

    public void setGatewayIP(IPInformation gatewayIP) {
        this.gatewayIP = gatewayIP;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((destinationNetworkMask == null) ? 0
            : destinationNetworkMask.hashCode());
        result = prime
            * result
            + ((destinationSubnet == null) ? 0 : destinationSubnet
            .hashCode());
        result = prime * result
            + ((gatewayIP == null) ? 0 : gatewayIP.hashCode());
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
        GatewayInformation other = (GatewayInformation) obj;
        if (destinationNetworkMask == null) {
            if (other.destinationNetworkMask != null)
                return false;
        } else if (!destinationNetworkMask.equals(other.destinationNetworkMask))
            return false;
        if (destinationSubnet == null) {
            if (other.destinationSubnet != null)
                return false;
        } else if (!destinationSubnet.equals(other.destinationSubnet))
            return false;
        if (gatewayIP == null) {
            if (other.gatewayIP != null)
                return false;
        } else if (!gatewayIP.equals(other.gatewayIP))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("GatewayInformation [destinationSubnet=")
            .append(destinationSubnet).append(", destinationNetworkMask=")
            .append(destinationNetworkMask).append(", gatewayIP=")
            .append(gatewayIP).append("]");
        return builder.toString();
    }


}
