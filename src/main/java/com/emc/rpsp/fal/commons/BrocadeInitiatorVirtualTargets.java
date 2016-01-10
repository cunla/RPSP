package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@XmlRootElement
@XmlType(name = "BrocadeInitiatorVirtualTargets")
public class BrocadeInitiatorVirtualTargets {

    private long initiatorWWN;
    private HashSet<BrocadeVirtualTarget> virtualTargets;

    public BrocadeInitiatorVirtualTargets() {
    }

    public BrocadeInitiatorVirtualTargets(long initiatorWWN,
                                          HashSet<BrocadeVirtualTarget> virtualTargets) {
        this.initiatorWWN = initiatorWWN;
        this.virtualTargets = virtualTargets;
    }

    public long getInitiatorWWN() {
        return initiatorWWN;
    }

    public void setInitiatorWWN(long initiatorWWN) {
        this.initiatorWWN = initiatorWWN;
    }

    public HashSet<BrocadeVirtualTarget> getVirtualTargets() {
        return virtualTargets;
    }

    public void setVirtualTargets(HashSet<BrocadeVirtualTarget> virtualTargets) {
        this.virtualTargets = virtualTargets;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (initiatorWWN ^ (initiatorWWN >>> 32));
        result = prime * result
            + ((virtualTargets == null) ? 0 : virtualTargets.hashCode());
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
        BrocadeInitiatorVirtualTargets other = (BrocadeInitiatorVirtualTargets) obj;
        if (initiatorWWN != other.initiatorWWN)
            return false;
        if (virtualTargets == null) {
            if (other.virtualTargets != null)
                return false;
        } else if (!virtualTargets.equals(other.virtualTargets))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("BrocadeInitiatorVirtualTargets [initiatorWWN=").append(
            initiatorWWN).append(", virtualTargets=").append(virtualTargets)
            .append("]");
        return builder.toString();
    }
}
