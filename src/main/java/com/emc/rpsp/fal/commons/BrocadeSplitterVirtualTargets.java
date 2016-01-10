package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BrocadeSplitterVirtualTargets")
public class BrocadeSplitterVirtualTargets {

    @XmlElement(nillable = true)
    private SplitterUID splitterUID;
    private HashSet<BrocadeInitiatorVirtualTargets> brocadeInitiatorVirtualTargets;

    public BrocadeSplitterVirtualTargets() {
        super();
    }

    public BrocadeSplitterVirtualTargets(
        SplitterUID splitterUID,
        HashSet<BrocadeInitiatorVirtualTargets> brocadeInitiatorVirtualTargets) {
        super();
        this.splitterUID = splitterUID;
        this.brocadeInitiatorVirtualTargets = brocadeInitiatorVirtualTargets;
    }

    public SplitterUID getSplitterUID() {
        return splitterUID;
    }

    public void setSplitterUID(SplitterUID splitterUID) {
        this.splitterUID = splitterUID;
    }

    public HashSet<BrocadeInitiatorVirtualTargets> getBrocadeInitiatorVirtualTargets() {
        return brocadeInitiatorVirtualTargets;
    }

    public void setBrocadeInitiatorVirtualTargets(
        HashSet<BrocadeInitiatorVirtualTargets> brocadeInitiatorVirtualTargets) {
        this.brocadeInitiatorVirtualTargets = brocadeInitiatorVirtualTargets;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((brocadeInitiatorVirtualTargets == null) ? 0
            : brocadeInitiatorVirtualTargets.hashCode());
        result = prime * result
            + ((splitterUID == null) ? 0 : splitterUID.hashCode());
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
        BrocadeSplitterVirtualTargets other = (BrocadeSplitterVirtualTargets) obj;
        if (brocadeInitiatorVirtualTargets == null) {
            if (other.brocadeInitiatorVirtualTargets != null)
                return false;
        } else if (!brocadeInitiatorVirtualTargets
            .equals(other.brocadeInitiatorVirtualTargets))
            return false;
        if (splitterUID == null) {
            if (other.splitterUID != null)
                return false;
        } else if (!splitterUID.equals(other.splitterUID))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder
            .append(
                "BrocadeSplitterVirtualTargets [brocadeInitiatorVirtualTargets=")
            .append(brocadeInitiatorVirtualTargets)
            .append(", splitterUID=").append(splitterUID).append("]");
        return builder.toString();
    }

}
