package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@XmlRootElement
@XmlType(name = "ConsistencyGroupSnapshots")
////@LargeObject
public class ConsistencyGroupSnapshots {

    private ConsistencyGroupUID groupUID;
    private HashSet<ConsistencyGroupCopySnapshots> copiesSnapshots;

    public ConsistencyGroupSnapshots() {
    }

    public ConsistencyGroupSnapshots(ConsistencyGroupUID groupUID, HashSet<ConsistencyGroupCopySnapshots> copiesSnapshots) {
        this.groupUID = groupUID;
        this.copiesSnapshots = copiesSnapshots;
    }

    public ConsistencyGroupUID getGroupUID() {
        return groupUID;
    }

    public void setGroupUID(ConsistencyGroupUID groupUID) {
        this.groupUID = groupUID;
    }

    public HashSet<ConsistencyGroupCopySnapshots> getCopiesSnapshots() {
        return copiesSnapshots;
    }

    public void setCopiesSnapshots(
        HashSet<ConsistencyGroupCopySnapshots> copiesSnapshots) {
        this.copiesSnapshots = copiesSnapshots;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((copiesSnapshots == null) ? 0 : copiesSnapshots.hashCode());
        result = prime * result
            + ((groupUID == null) ? 0 : groupUID.hashCode());
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
        ConsistencyGroupSnapshots other = (ConsistencyGroupSnapshots) obj;
        if (copiesSnapshots == null) {
            if (other.copiesSnapshots != null)
                return false;
        } else if (!copiesSnapshots.equals(other.copiesSnapshots))
            return false;
        if (groupUID == null) {
            if (other.groupUID != null)
                return false;
        } else if (!groupUID.equals(other.groupUID))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ConsistencyGroupSnapshots [copiesSnapshots=").append(
            copiesSnapshots).append(", groupUID=").append(groupUID).append(
            "]");
        return builder.toString();
    }
}
