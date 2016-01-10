package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@XmlRootElement
@XmlType(name = "SymmetrixGateKeepersInfo")
public class SymmetrixGateKeepersInfo {

    private HashSet<SymmetrixGateKeepersRPAInfo> symmetrixGateKeepersRPAInfo;

    public SymmetrixGateKeepersInfo() {
    }

    public SymmetrixGateKeepersInfo(
        HashSet<SymmetrixGateKeepersRPAInfo> symmetrixGateKeepersRPAInfo) {
        this.symmetrixGateKeepersRPAInfo = symmetrixGateKeepersRPAInfo;
    }

    public HashSet<SymmetrixGateKeepersRPAInfo> getSymmetrixGateKeepersRPAInfo() {
        return symmetrixGateKeepersRPAInfo;
    }

    public void setSymmetrixGateKeepersRPAInfo(
        HashSet<SymmetrixGateKeepersRPAInfo> symmetrixGateKeepersRPAInfo) {
        this.symmetrixGateKeepersRPAInfo = symmetrixGateKeepersRPAInfo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((symmetrixGateKeepersRPAInfo == null) ? 0
            : symmetrixGateKeepersRPAInfo.hashCode());
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
        SymmetrixGateKeepersInfo other = (SymmetrixGateKeepersInfo) obj;
        if (symmetrixGateKeepersRPAInfo == null) {
            if (other.symmetrixGateKeepersRPAInfo != null)
                return false;
        } else if (!symmetrixGateKeepersRPAInfo
            .equals(other.symmetrixGateKeepersRPAInfo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder
            .append(
                "SymmetrixGateKeepersInfo [symmetrixGateKeepersRPAInfo=")
            .append(symmetrixGateKeepersRPAInfo).append("]");
        return builder.toString();
    }

}
