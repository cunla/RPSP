package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsistencyGroupStatistics")
////@LargeObject
public class ConsistencyGroupStatistics {

    @XmlElement(nillable = true)
    private ConsistencyGroupUID consistencyGroupUID;
    private HashSet<ConsistencyGroupCopyStatistics> consistencyGroupCopyStatistics;
    private HashSet<ConsistencyGroupLinkStatistics> consistencyGroupLinkStatistics;

    public ConsistencyGroupStatistics() {
    }

    public ConsistencyGroupStatistics(
        ConsistencyGroupUID consistencyGroupUID,
        HashSet<ConsistencyGroupCopyStatistics> consistencyGroupCopyStatistics,
        HashSet<ConsistencyGroupLinkStatistics> consistencyGroupLinkStatistics) {
        super();
        this.consistencyGroupUID = consistencyGroupUID;
        this.consistencyGroupCopyStatistics = consistencyGroupCopyStatistics;
        this.consistencyGroupLinkStatistics = consistencyGroupLinkStatistics;
    }


    public ConsistencyGroupUID getConsistencyGroupUID() {
        return consistencyGroupUID;
    }

    public void setConsistencyGroupUID(ConsistencyGroupUID consistencyGroupUID) {
        this.consistencyGroupUID = consistencyGroupUID;
    }

    public HashSet<ConsistencyGroupCopyStatistics> getConsistencyGroupCopyStatistics() {
        return consistencyGroupCopyStatistics;
    }

    public void setConsistencyGroupCopyStatistics(
        HashSet<ConsistencyGroupCopyStatistics> consistencyGroupCopyStatistics) {
        this.consistencyGroupCopyStatistics = consistencyGroupCopyStatistics;
    }

    public HashSet<ConsistencyGroupLinkStatistics> getConsistencyGroupLinkStatistics() {
        return consistencyGroupLinkStatistics;
    }

    public void setConsistencyGroupLinkStatistics(
        HashSet<ConsistencyGroupLinkStatistics> consistencyGroupLinkStatistics) {
        this.consistencyGroupLinkStatistics = consistencyGroupLinkStatistics;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((consistencyGroupCopyStatistics == null) ? 0
            : consistencyGroupCopyStatistics.hashCode());
        result = prime
            * result
            + ((consistencyGroupLinkStatistics == null) ? 0
            : consistencyGroupLinkStatistics.hashCode());
        result = prime
            * result
            + ((consistencyGroupUID == null) ? 0 : consistencyGroupUID
            .hashCode());
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
        ConsistencyGroupStatistics other = (ConsistencyGroupStatistics) obj;
        if (consistencyGroupCopyStatistics == null) {
            if (other.consistencyGroupCopyStatistics != null)
                return false;
        } else if (!consistencyGroupCopyStatistics
            .equals(other.consistencyGroupCopyStatistics))
            return false;
        if (consistencyGroupLinkStatistics == null) {
            if (other.consistencyGroupLinkStatistics != null)
                return false;
        } else if (!consistencyGroupLinkStatistics
            .equals(other.consistencyGroupLinkStatistics))
            return false;
        if (consistencyGroupUID == null) {
            if (other.consistencyGroupUID != null)
                return false;
        } else if (!consistencyGroupUID.equals(other.consistencyGroupUID))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(
            "ConsistencyGroupStatistics [consistencyGroupCopyStatistics=")
            .append(consistencyGroupCopyStatistics).append(
            ", consistencyGroupLinkStatistics=").append(
            consistencyGroupLinkStatistics).append(
            ", consistencyGroupUID=").append(consistencyGroupUID)
            .append("]");
        return builder.toString();
    }

}
