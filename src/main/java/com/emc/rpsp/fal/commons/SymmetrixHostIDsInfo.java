package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@XmlRootElement
@XmlType(name = "SymmetrixHostIDsInfo")
public class SymmetrixHostIDsInfo {

    private HashSet<SymmetrixHostId> symmetrixHostIDs;

    public SymmetrixHostIDsInfo() {

    }

    public SymmetrixHostIDsInfo(HashSet<SymmetrixHostId> symmetrixHostIDs) {
        this.symmetrixHostIDs = symmetrixHostIDs;
    }

    public HashSet<SymmetrixHostId> getSymmetrixHostIDs() {
        return symmetrixHostIDs;
    }

    public void setSymmetrixHostIDs(HashSet<SymmetrixHostId> symmetrixHostIDs) {
        this.symmetrixHostIDs = symmetrixHostIDs;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((symmetrixHostIDs == null) ? 0 : symmetrixHostIDs.hashCode());
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
        SymmetrixHostIDsInfo other = (SymmetrixHostIDsInfo) obj;
        if (symmetrixHostIDs == null) {
            if (other.symmetrixHostIDs != null)
                return false;
        } else if (!symmetrixHostIDs.equals(other.symmetrixHostIDs))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SymmetrixHostIDsInfo [symmetrixHostIDs=")
            .append(symmetrixHostIDs).append("]");
        return builder.toString();
    }

}
