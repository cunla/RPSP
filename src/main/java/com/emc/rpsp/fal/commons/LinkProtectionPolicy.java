package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LinkProtectionPolicy")
public class LinkProtectionPolicy implements Validateable {

    @XmlElement(required = true)
    private ProtectionMode protectionType;
    @XmlElement(required = true)
    private SyncReplicationThreshold syncReplicationLatencyThresholds; // must hold time quantity
    @XmlElement(required = true)
    private SyncReplicationThreshold syncReplicationThroughputThresholds; // must hold data quantity
    @XmlElement(nillable = true, required = true)
    private RPOPolicy rpoPolicy;
    private boolean replicatingOverWAN;
    @XmlElement(required = true)
    private WanCompression compression;
    private double bandwidthLimit;
    private boolean measureLagToTargetRPA;
    private boolean deduplication;
    private int weight;

    public LinkProtectionPolicy() {
    }

    public LinkProtectionPolicy(ProtectionMode protectionType, SyncReplicationThreshold syncReplicationLatencyThresholds,
                                SyncReplicationThreshold syncReplicationThroughputThresholds, RPOPolicy rpoPolicy, boolean replicatingOverWAN,
                                WanCompression compression, double bandwidthLimit, boolean measureLagToTargetRPA,
                                boolean deduplication, int weight) {
        this.protectionType = protectionType;
        this.syncReplicationLatencyThresholds = syncReplicationLatencyThresholds;
        this.syncReplicationThroughputThresholds = syncReplicationThroughputThresholds;
        this.rpoPolicy = rpoPolicy;
        this.replicatingOverWAN = replicatingOverWAN;
        this.compression = compression;
        this.bandwidthLimit = bandwidthLimit;
        this.measureLagToTargetRPA = measureLagToTargetRPA;
        this.deduplication = deduplication;
        this.weight = weight;
    }

    public ProtectionMode getProtectionType() {
        return protectionType;
    }

    public void setProtectionType(ProtectionMode protectionType) {
        this.protectionType = protectionType;
    }

    public SyncReplicationThreshold getSyncReplicationLatencyThresholds() {
        return syncReplicationLatencyThresholds;
    }

    public void setSyncReplicationLatencyThresholds(
        SyncReplicationThreshold syncReplicationLatencyThresholds) {
        this.syncReplicationLatencyThresholds = syncReplicationLatencyThresholds;
    }

    public SyncReplicationThreshold getSyncReplicationThroughputThresholds() {
        return syncReplicationThroughputThresholds;
    }

    public void setSyncReplicationThroughputThresholds(
        SyncReplicationThreshold syncReplicationThroughputThresholds) {
        this.syncReplicationThroughputThresholds = syncReplicationThroughputThresholds;
    }

    public RPOPolicy getRpoPolicy() {
        return rpoPolicy;
    }

    public void setRpoPolicy(RPOPolicy rpoPolicy) {
        this.rpoPolicy = rpoPolicy;
    }

    public boolean getReplicatingOverWAN() {
        return replicatingOverWAN;
    }

    public void setReplicatingOverWAN(boolean replicatingOverWAN) {
        this.replicatingOverWAN = replicatingOverWAN;
    }

    public WanCompression getCompression() {
        return compression;
    }

    public void setCompression(WanCompression compression) {
        this.compression = compression;
    }

    public double getBandwidthLimit() {
        return bandwidthLimit;
    }

    public void setBandwidthLimit(double bandwidthLimit) {
        this.bandwidthLimit = bandwidthLimit;
    }

    public boolean getMeasureLagToTargetRPA() {
        return measureLagToTargetRPA;
    }

    public void setMeasureLagToTargetRPA(boolean measureLagToTargetRPA) {
        this.measureLagToTargetRPA = measureLagToTargetRPA;
    }

    public boolean getDeduplication() {
        return deduplication;
    }

    public void setDeduplication(boolean deduplication) {
        this.deduplication = deduplication;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(bandwidthLimit);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result
            + ((compression == null) ? 0 : compression.hashCode());
        result = prime * result + (deduplication ? 1231 : 1237);
        result = prime * result + (measureLagToTargetRPA ? 1231 : 1237);
        result = prime * result
            + ((protectionType == null) ? 0 : protectionType.hashCode());
        result = prime * result + (replicatingOverWAN ? 1231 : 1237);
        result = prime * result
            + ((rpoPolicy == null) ? 0 : rpoPolicy.hashCode());
        result = prime
            * result
            + ((syncReplicationLatencyThresholds == null) ? 0
            : syncReplicationLatencyThresholds.hashCode());
        result = prime
            * result
            + ((syncReplicationThroughputThresholds == null) ? 0
            : syncReplicationThroughputThresholds.hashCode());
        result = prime * result + weight;
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
        LinkProtectionPolicy other = (LinkProtectionPolicy) obj;
        if (Double.doubleToLongBits(bandwidthLimit) != Double
            .doubleToLongBits(other.bandwidthLimit))
            return false;
        if (compression != other.compression)
            return false;
        if (deduplication != other.deduplication)
            return false;
        if (measureLagToTargetRPA != other.measureLagToTargetRPA)
            return false;
        if (protectionType != other.protectionType)
            return false;
        if (replicatingOverWAN != other.replicatingOverWAN)
            return false;
        if (rpoPolicy == null) {
            if (other.rpoPolicy != null)
                return false;
        } else if (!rpoPolicy.equals(other.rpoPolicy))
            return false;
        if (syncReplicationLatencyThresholds == null) {
            if (other.syncReplicationLatencyThresholds != null)
                return false;
        } else if (!syncReplicationLatencyThresholds
            .equals(other.syncReplicationLatencyThresholds))
            return false;
        if (syncReplicationThroughputThresholds == null) {
            if (other.syncReplicationThroughputThresholds != null)
                return false;
        } else if (!syncReplicationThroughputThresholds
            .equals(other.syncReplicationThroughputThresholds))
            return false;
        if (weight != other.weight)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LinkProtectionPolicy [protectionType=")
            .append(protectionType)
            .append(", syncReplicationLatencyThresholds=")
            .append(syncReplicationLatencyThresholds)
            .append(", syncReplicationThroughputThresholds=")
            .append(syncReplicationThroughputThresholds)
            .append(", rpoPolicy=").append(rpoPolicy)
            .append(", replicatingOverWAN=").append(replicatingOverWAN)
            .append(", compression=").append(compression)
            .append(", bandwidthLimit=").append(bandwidthLimit)
            .append(", measureLagToTargetRPA=")
            .append(measureLagToTargetRPA).append(", deduplication=")
            .append(deduplication).append(", weight=").append(weight)
            .append("]");
        return builder.toString();
    }
}
