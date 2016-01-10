package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SystemMiscellaneousSettings")
public class SystemMiscellaneousSettings implements Validateable {

    private boolean useAutomaticSplitterInfoCollection;
    @XmlElement(required = true)
    private SystemSecurityLevel securityLevel;
    @XmlElement(required = true)
    private HashSet<ClusterRPAMultipathMonitoring> rpasMultipathMonitoring;

    public SystemMiscellaneousSettings() {
    }

    public SystemMiscellaneousSettings(boolean useAutomaticSplitterInfoCollection, SystemSecurityLevel securityLevel,
                                       HashSet<ClusterRPAMultipathMonitoring> rpasMultipathMonitoring) {
        this.useAutomaticSplitterInfoCollection = useAutomaticSplitterInfoCollection;
        this.securityLevel = securityLevel;
        this.rpasMultipathMonitoring = rpasMultipathMonitoring;
    }

    public boolean getUseAutomaticSplitterInfoCollection() {
        return useAutomaticSplitterInfoCollection;
    }

    public void setUseAutomaticSplitterInfoCollection(boolean useAutomaticSplitterInfoCollection) {
        this.useAutomaticSplitterInfoCollection = useAutomaticSplitterInfoCollection;
    }

    public SystemSecurityLevel getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(SystemSecurityLevel securityLevel) {
        this.securityLevel = securityLevel;
    }

    public HashSet<ClusterRPAMultipathMonitoring> getRpasMultipathMonitoring() {
        return rpasMultipathMonitoring;
    }

    public void setRpasMultipathMonitoring(HashSet<ClusterRPAMultipathMonitoring> rpasMultipathMonitoring) {
        this.rpasMultipathMonitoring = rpasMultipathMonitoring;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((rpasMultipathMonitoring == null) ? 0
            : rpasMultipathMonitoring.hashCode());
        result = prime * result
            + ((securityLevel == null) ? 0 : securityLevel.hashCode());
        result = prime * result
            + (useAutomaticSplitterInfoCollection ? 1231 : 1237);
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
        SystemMiscellaneousSettings other = (SystemMiscellaneousSettings) obj;
        if (rpasMultipathMonitoring == null) {
            if (other.rpasMultipathMonitoring != null)
                return false;
        } else if (!rpasMultipathMonitoring
            .equals(other.rpasMultipathMonitoring))
            return false;
        if (securityLevel == null) {
            if (other.securityLevel != null)
                return false;
        } else if (!securityLevel.equals(other.securityLevel))
            return false;
        if (useAutomaticSplitterInfoCollection != other.useAutomaticSplitterInfoCollection)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SystemMiscellaneousSettings [rpasMultipathMonitoring=")
            .append(rpasMultipathMonitoring).append(", securityLevel=")
            .append(securityLevel).append(
            ", useAutomaticSplitterInfoCollection=").append(
            useAutomaticSplitterInfoCollection).append("]");
        return builder.toString();
    }
}
