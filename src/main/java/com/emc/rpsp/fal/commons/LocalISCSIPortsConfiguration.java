package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@XmlRootElement
@XmlType(name = "LocalISCSIPortsConfiguration")
public class LocalISCSIPortsConfiguration {

    private HashSet<LocalISCSIPortInformation> portsInformation;

    public LocalISCSIPortsConfiguration() {
    }

    public LocalISCSIPortsConfiguration(
        HashSet<LocalISCSIPortInformation> portsInformation) {
        this.portsInformation = portsInformation;
    }

    public HashSet<LocalISCSIPortInformation> getPortsInformation() {
        return portsInformation;
    }

    public void setPortsInformation(
        HashSet<LocalISCSIPortInformation> portsInformation) {
        this.portsInformation = portsInformation;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((portsInformation == null) ? 0 : portsInformation.hashCode());
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
        LocalISCSIPortsConfiguration other = (LocalISCSIPortsConfiguration) obj;
        if (portsInformation == null) {
            if (other.portsInformation != null)
                return false;
        } else if (!portsInformation.equals(other.portsInformation))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LocalISCSIPortsConfiguration [portsInformation=")
            .append(portsInformation).append("]");
        return builder.toString();
    }


}
