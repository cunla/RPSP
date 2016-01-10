package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RPAInterfaceStatus")
public class RPAInterfaceStatus {

    @XmlElement(nillable = true)
    private InterfaceType interfaceType;
    private GeneralStatus interfaceStatus;
    private HashSet<RPAConnectivityStatus> otherRPAsIPV4ConnectivityStatus;
    private HashSet<RPAConnectivityStatus> otherRPAsIPV6ConnectivityStatus;

    public RPAInterfaceStatus() {
    }

    public RPAInterfaceStatus(InterfaceType interfaceType,
                              GeneralStatus interfaceStatus,
                              HashSet<RPAConnectivityStatus> otherRPAsIPV4ConnectivityStatus,
                              HashSet<RPAConnectivityStatus> otherRPAsIPV6ConnectivityStatus) {
        this.interfaceType = interfaceType;
        this.interfaceStatus = interfaceStatus;
        this.otherRPAsIPV4ConnectivityStatus = otherRPAsIPV4ConnectivityStatus;
        this.otherRPAsIPV6ConnectivityStatus = otherRPAsIPV6ConnectivityStatus;
    }

    public InterfaceType getInterfaceType() {
        return interfaceType;
    }

    public void setInterfaceType(InterfaceType interfaceType) {
        this.interfaceType = interfaceType;
    }

    public GeneralStatus getInterfaceStatus() {
        return interfaceStatus;
    }

    public void setInterfaceStatus(GeneralStatus interfaceStatus) {
        this.interfaceStatus = interfaceStatus;
    }

    public HashSet<RPAConnectivityStatus> getOtherRPAsIPV4ConnectivityStatus() {
        return otherRPAsIPV4ConnectivityStatus;
    }

    public void setOtherRPAsIPV4ConnectivityStatus(
        HashSet<RPAConnectivityStatus> otherRPAsIPV4ConnectivityStatus) {
        this.otherRPAsIPV4ConnectivityStatus = otherRPAsIPV4ConnectivityStatus;
    }

    public HashSet<RPAConnectivityStatus> getOtherRPAsIPV6ConnectivityStatus() {
        return otherRPAsIPV6ConnectivityStatus;
    }

    public void setOtherRPAsIPV6ConnectivityStatus(
        HashSet<RPAConnectivityStatus> otherRPAsIPV6ConnectivityStatus) {
        this.otherRPAsIPV6ConnectivityStatus = otherRPAsIPV6ConnectivityStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((interfaceStatus == null) ? 0 : interfaceStatus.hashCode());
        result = prime * result
            + ((interfaceType == null) ? 0 : interfaceType.hashCode());
        result = prime
            * result
            + ((otherRPAsIPV4ConnectivityStatus == null) ? 0
            : otherRPAsIPV4ConnectivityStatus.hashCode());
        result = prime
            * result
            + ((otherRPAsIPV6ConnectivityStatus == null) ? 0
            : otherRPAsIPV6ConnectivityStatus.hashCode());
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
        RPAInterfaceStatus other = (RPAInterfaceStatus) obj;
        if (interfaceStatus == null) {
            if (other.interfaceStatus != null)
                return false;
        } else if (!interfaceStatus.equals(other.interfaceStatus))
            return false;
        if (interfaceType == null) {
            if (other.interfaceType != null)
                return false;
        } else if (!interfaceType.equals(other.interfaceType))
            return false;
        if (otherRPAsIPV4ConnectivityStatus == null) {
            if (other.otherRPAsIPV4ConnectivityStatus != null)
                return false;
        } else if (!otherRPAsIPV4ConnectivityStatus
            .equals(other.otherRPAsIPV4ConnectivityStatus))
            return false;
        if (otherRPAsIPV6ConnectivityStatus == null) {
            if (other.otherRPAsIPV6ConnectivityStatus != null)
                return false;
        } else if (!otherRPAsIPV6ConnectivityStatus
            .equals(other.otherRPAsIPV6ConnectivityStatus))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RPAInterfaceStatus [interfaceStatus=").append(
            interfaceStatus).append(", interfaceType=").append(
            interfaceType).append(", otherRPAsIPV4ConnectivityStatus=")
            .append(otherRPAsIPV4ConnectivityStatus).append(
            ", otherRPAsIPV6ConnectivityStatus=").append(
            otherRPAsIPV6ConnectivityStatus).append("]");
        return builder.toString();
    }
}
