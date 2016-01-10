package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SymmetrixGateKeepersRPAInfo")
public class SymmetrixGateKeepersRPAInfo {

    @XmlElement(nillable = true)
    private RpaUID rpaUID;
    private HashSet<SymmetrixDevicePath> gateKeeperPaths;

    public SymmetrixGateKeepersRPAInfo() {
        super();
    }

    public SymmetrixGateKeepersRPAInfo(RpaUID rpaUID,
                                       HashSet<SymmetrixDevicePath> gateKeeperPaths) {
        super();
        this.rpaUID = rpaUID;
        this.gateKeeperPaths = gateKeeperPaths;
    }

    public RpaUID getRpaUID() {
        return rpaUID;
    }

    public void setRpaUID(RpaUID rpaUID) {
        this.rpaUID = rpaUID;
    }

    public HashSet<SymmetrixDevicePath> getGateKeeperPaths() {
        return gateKeeperPaths;
    }

    public void setGateKeeperPaths(HashSet<SymmetrixDevicePath> gateKeeperPaths) {
        this.gateKeeperPaths = gateKeeperPaths;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((gateKeeperPaths == null) ? 0 : gateKeeperPaths.hashCode());
        result = prime * result + ((rpaUID == null) ? 0 : rpaUID.hashCode());
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
        SymmetrixGateKeepersRPAInfo other = (SymmetrixGateKeepersRPAInfo) obj;
        if (gateKeeperPaths == null) {
            if (other.gateKeeperPaths != null)
                return false;
        } else if (!gateKeeperPaths.equals(other.gateKeeperPaths))
            return false;
        if (rpaUID == null) {
            if (other.rpaUID != null)
                return false;
        } else if (!rpaUID.equals(other.rpaUID))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SymmetrixGateKeepersRPAInfo [gateKeeperPaths=").append(
            gateKeeperPaths).append(", rpaUID=").append(rpaUID).append("]");
        return builder.toString();
    }

}
