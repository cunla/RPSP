package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@XmlRootElement
@XmlType(name = "SymmetrixArrayList")
public class SymmetrixArrayList {

    private HashSet<String> symmetrixIDs;

    public SymmetrixArrayList() {
    }

    public SymmetrixArrayList(HashSet<String> symmetrixIDs) {
        super();
        this.symmetrixIDs = symmetrixIDs;
    }

    public HashSet<String> getSymmetrixIDs() {
        return symmetrixIDs;
    }

    public void setSymmetrixIDs(HashSet<String> symmetrixIDs) {
        this.symmetrixIDs = symmetrixIDs;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((symmetrixIDs == null) ? 0 : symmetrixIDs.hashCode());
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
        SymmetrixArrayList other = (SymmetrixArrayList) obj;
        if (symmetrixIDs == null) {
            if (other.symmetrixIDs != null)
                return false;
        } else if (!symmetrixIDs.equals(other.symmetrixIDs))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SymmetrixArrayList [symmetrixIDs=")
            .append(symmetrixIDs).append("]");
        return builder.toString();
    }

}
