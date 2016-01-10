package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "SnapshotConsolidationInfo")
public class SnapshotConsolidationInfo {

    private BookmarkConsolidationPolicy consolidationPolicy;
    private SnapshotConsolidationType consolidationType;
    private long savedSpaceInBytes;

    public SnapshotConsolidationInfo() {
    }

    public SnapshotConsolidationInfo(BookmarkConsolidationPolicy consolidationPolicy, SnapshotConsolidationType consolidationType,
                                     long savedSpaceInBytes) {
        this.consolidationPolicy = consolidationPolicy;
        this.consolidationType = consolidationType;
        this.savedSpaceInBytes = savedSpaceInBytes;
    }

    public BookmarkConsolidationPolicy getConsolidationPolicy() {
        return consolidationPolicy;
    }

    public void setConsolidationPolicy(
        BookmarkConsolidationPolicy consolidationPolicy) {
        this.consolidationPolicy = consolidationPolicy;
    }

    public SnapshotConsolidationType getConsolidationType() {
        return consolidationType;
    }

    public void setConsolidationType(SnapshotConsolidationType consolidationType) {
        this.consolidationType = consolidationType;
    }

    public long getSavedSpaceInBytes() {
        return savedSpaceInBytes;
    }

    public void setSavedSpaceInBytes(long savedSpaceInBytes) {
        this.savedSpaceInBytes = savedSpaceInBytes;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((consolidationPolicy == null) ? 0 : consolidationPolicy
            .hashCode());
        result = prime
            * result
            + ((consolidationType == null) ? 0 : consolidationType
            .hashCode());
        result = prime * result
            + (int) (savedSpaceInBytes ^ (savedSpaceInBytes >>> 32));
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
        SnapshotConsolidationInfo other = (SnapshotConsolidationInfo) obj;
        if (consolidationPolicy == null) {
            if (other.consolidationPolicy != null)
                return false;
        } else if (!consolidationPolicy.equals(other.consolidationPolicy))
            return false;
        if (consolidationType == null) {
            if (other.consolidationType != null)
                return false;
        } else if (!consolidationType.equals(other.consolidationType))
            return false;
        if (savedSpaceInBytes != other.savedSpaceInBytes)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SnapshotConsolidationInfo [consolidationPolicy=")
            .append(consolidationPolicy).append(", consolidationType=")
            .append(consolidationType).append(", savedSpaceInBytes=")
            .append(savedSpaceInBytes).append("]");
        return builder.toString();
    }
}
