package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.HashSet;
import java.util.LinkedList;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RPAConfiguration")
public class RPAConfiguration {

    @XmlElement(nillable = true)
    private RpaUID rpaUID;
    private HashSet<NICInformation> nicsInformation;
    private HashSet<RPAPortInformation> spoofedPorts;
    @XmlElement(nillable = true)
    private LocalISCSIPortsConfiguration localISCSIPortsConfiguration;
    private LinkedList<String> ntpServersIPs;

    public RPAConfiguration() {
    }

    public RPAConfiguration(RpaUID rpaUID,
                            HashSet<NICInformation> nicsInformation,
                            HashSet<RPAPortInformation> spoofedPorts,
                            LocalISCSIPortsConfiguration localISCSIPortsConfiguration,
                            LinkedList<String> ntpServersIPs) {
        this.rpaUID = rpaUID;
        this.nicsInformation = nicsInformation;
        this.spoofedPorts = spoofedPorts;
        this.localISCSIPortsConfiguration = localISCSIPortsConfiguration;
        this.ntpServersIPs = ntpServersIPs;
    }

    public RpaUID getRpaUID() {
        return rpaUID;
    }

    public void setRpaUID(RpaUID rpaUID) {
        this.rpaUID = rpaUID;
    }

    public HashSet<NICInformation> getNicsInformation() {
        return nicsInformation;
    }

    public void setNicsInformation(HashSet<NICInformation> nicsInformation) {
        this.nicsInformation = nicsInformation;
    }

    public HashSet<RPAPortInformation> getSpoofedPorts() {
        return spoofedPorts;
    }

    public void setSpoofedPorts(HashSet<RPAPortInformation> spoofedPorts) {
        this.spoofedPorts = spoofedPorts;
    }

    public LocalISCSIPortsConfiguration getLocalISCSIPortsConfiguration() {
        return localISCSIPortsConfiguration;
    }

    public void setLocalISCSIPortsConfiguration(
        LocalISCSIPortsConfiguration localISCSIPortsConfiguration) {
        this.localISCSIPortsConfiguration = localISCSIPortsConfiguration;
    }

    public LinkedList<String> getNtpServersIPs() {
        return ntpServersIPs;
    }

    public void setNtpServersIPs(LinkedList<String> ntpServersIPs) {
        this.ntpServersIPs = ntpServersIPs;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((localISCSIPortsConfiguration == null) ? 0
            : localISCSIPortsConfiguration.hashCode());
        result = prime * result
            + ((nicsInformation == null) ? 0 : nicsInformation.hashCode());
        result = prime * result
            + ((ntpServersIPs == null) ? 0 : ntpServersIPs.hashCode());
        result = prime * result + ((rpaUID == null) ? 0 : rpaUID.hashCode());
        result = prime * result
            + ((spoofedPorts == null) ? 0 : spoofedPorts.hashCode());
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
        RPAConfiguration other = (RPAConfiguration) obj;
        if (localISCSIPortsConfiguration == null) {
            if (other.localISCSIPortsConfiguration != null)
                return false;
        } else if (!localISCSIPortsConfiguration
            .equals(other.localISCSIPortsConfiguration))
            return false;
        if (nicsInformation == null) {
            if (other.nicsInformation != null)
                return false;
        } else if (!nicsInformation.equals(other.nicsInformation))
            return false;
        if (ntpServersIPs == null) {
            if (other.ntpServersIPs != null)
                return false;
        } else if (!ntpServersIPs.equals(other.ntpServersIPs))
            return false;
        if (rpaUID == null) {
            if (other.rpaUID != null)
                return false;
        } else if (!rpaUID.equals(other.rpaUID))
            return false;
        if (spoofedPorts == null) {
            if (other.spoofedPorts != null)
                return false;
        } else if (!spoofedPorts.equals(other.spoofedPorts))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RPAConfiguration [rpaUID=").append(rpaUID)
            .append(", nicsInformation=").append(nicsInformation)
            .append(", spoofedPorts=").append(spoofedPorts)
            .append(", localISCSIPortsConfiguration=")
            .append(localISCSIPortsConfiguration)
            .append(", ntpServersIPs=").append(ntpServersIPs).append("]");
        return builder.toString();
    }

}
