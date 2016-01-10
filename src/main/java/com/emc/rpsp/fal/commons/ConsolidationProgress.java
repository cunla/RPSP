package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "ConsolidationProgress")
public class ConsolidationProgress {

    private SnapshotConsolidationType consolidationType;
    private RecoverPointTimeStamp firstSnapshotTime;
    private RecoverPointTimeStamp lastSnapshotTime;
    private double progress;
    private boolean pending;

    public ConsolidationProgress() {
    }

    public ConsolidationProgress(SnapshotConsolidationType consolidationType,
                                 RecoverPointTimeStamp firstSnapshotTime, RecoverPointTimeStamp lastSnapshotTime, double progress,
                                 boolean pending) {
        this.consolidationType = consolidationType;
        this.firstSnapshotTime = firstSnapshotTime;
        this.lastSnapshotTime = lastSnapshotTime;
        this.progress = progress;
        this.pending = pending;
    }

    public SnapshotConsolidationType getConsolidationType() {
        return consolidationType;
    }

    public void setConsolidationType(SnapshotConsolidationType consolidationType) {
        this.consolidationType = consolidationType;
    }

    public RecoverPointTimeStamp getFirstSnapshotTime() {
        return firstSnapshotTime;
    }

    public void setFirstSnapshotTime(RecoverPointTimeStamp firstSnapshotTime) {
        this.firstSnapshotTime = firstSnapshotTime;
    }

    public RecoverPointTimeStamp getLastSnapshotTime() {
        return lastSnapshotTime;
    }

    public void setLastSnapshotTime(RecoverPointTimeStamp lastSnapshotTime) {
        this.lastSnapshotTime = lastSnapshotTime;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }

    public boolean getPending() {
        return pending;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((consolidationType == null) ? 0 : consolidationType
            .hashCode());
        result = prime
            * result
            + ((firstSnapshotTime == null) ? 0 : firstSnapshotTime
            .hashCode());
        result = prime
            * result
            + ((lastSnapshotTime == null) ? 0 : lastSnapshotTime.hashCode());
        result = prime * result + (pending ? 1231 : 1237);
        long temp;
        temp = Double.doubleToLongBits(progress);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        ConsolidationProgress other = (ConsolidationProgress) obj;
        if (consolidationType == null) {
            if (other.consolidationType != null)
                return false;
        } else if (!consolidationType.equals(other.consolidationType))
            return false;
        if (firstSnapshotTime == null) {
            if (other.firstSnapshotTime != null)
                return false;
        } else if (!firstSnapshotTime.equals(other.firstSnapshotTime))
            return false;
        if (lastSnapshotTime == null) {
            if (other.lastSnapshotTime != null)
                return false;
        } else if (!lastSnapshotTime.equals(other.lastSnapshotTime))
            return false;
        if (pending != other.pending)
            return false;
        if (Double.doubleToLongBits(progress) != Double
            .doubleToLongBits(other.progress))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ConsolidationProgress [consolidationType=").append(
            consolidationType).append(", firstSnapshotTime=").append(
            firstSnapshotTime).append(", lastSnapshotTime=").append(
            lastSnapshotTime).append(", pending=").append(pending).append(
            ", progress=").append(progress).append("]");
        return builder.toString();
    }
}
