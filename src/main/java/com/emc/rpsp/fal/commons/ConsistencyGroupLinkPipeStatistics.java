package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsistencyGroupLinkPipeStatistics")
public class ConsistencyGroupLinkPipeStatistics {

    private double averageJournalCompressionRatio;
    private double compressionRatio;
    private Long detachData;
    private Long detachDataRate;
    private StatisticsCounters lag;
    private int numberOfGrids;
    private long outgoingThroughput;
    private HashSet<OutgoingThroughputStatistics> outgoingThroughputPerRPA;
    @XmlElement(nillable = true)
    private ReplicationMode replicationMode;
    private boolean syncRemoteLink;
    private double deduplicationRatio;
    private double averageDeduplicationRatio;

    public ConsistencyGroupLinkPipeStatistics() {
    }

    public ConsistencyGroupLinkPipeStatistics(double averageJournalCompressionRatio,
                                              double compressionRatio, Long detachData, Long detachDataRate,
                                              StatisticsCounters lag, int numberOfGrids, long outgoingThroughput,
                                              HashSet<OutgoingThroughputStatistics> outgoingThroughputPerRPA,
                                              ReplicationMode replicationMode, boolean syncRemoteLink, double deduplicationRatio, double averageDeduplicationRatio) {
        this.averageJournalCompressionRatio = averageJournalCompressionRatio;
        this.compressionRatio = compressionRatio;
        this.detachData = detachData;
        this.detachDataRate = detachDataRate;
        this.lag = lag;
        this.numberOfGrids = numberOfGrids;
        this.outgoingThroughput = outgoingThroughput;
        this.outgoingThroughputPerRPA = outgoingThroughputPerRPA;
        this.replicationMode = replicationMode;
        this.syncRemoteLink = syncRemoteLink;
        this.deduplicationRatio = deduplicationRatio;
        this.averageDeduplicationRatio = averageDeduplicationRatio;
    }

    public double getAverageJournalCompressionRatio() {
        return averageJournalCompressionRatio;
    }

    public void setAverageJournalCompressionRatio(double averageJournalCompressionRatio) {
        this.averageJournalCompressionRatio = averageJournalCompressionRatio;
    }

    public double getCompressionRatio() {
        return compressionRatio;
    }

    public void setCompressionRatio(double compressionRatio) {
        this.compressionRatio = compressionRatio;
    }

    public Long getDetachData() {
        return detachData;
    }

    public void setDetachData(Long detachData) {
        this.detachData = detachData;
    }

    public Long getDetachDataRate() {
        return detachDataRate;
    }

    public void setDetachDataRate(Long detachDataRate) {
        this.detachDataRate = detachDataRate;
    }

    public StatisticsCounters getLag() {
        return lag;
    }

    public void setLag(StatisticsCounters lag) {
        this.lag = lag;
    }

    public int getNumberOfGrids() {
        return numberOfGrids;
    }

    public void setNumberOfGrids(int numberOfGrids) {
        this.numberOfGrids = numberOfGrids;
    }

    public long getOutgoingThroughput() {
        return outgoingThroughput;
    }

    public void setOutgoingThroughput(long outgoingThroughput) {
        this.outgoingThroughput = outgoingThroughput;
    }

    public HashSet<OutgoingThroughputStatistics> getOutgoingThroughputPerRPA() {
        return outgoingThroughputPerRPA;
    }

    public void setOutgoingThroughputPerRPA(
        HashSet<OutgoingThroughputStatistics> outgoingThroughputPerRPA) {
        this.outgoingThroughputPerRPA = outgoingThroughputPerRPA;
    }

    public ReplicationMode getReplicationMode() {
        return replicationMode;
    }

    public void setReplicationMode(ReplicationMode replicationMode) {
        this.replicationMode = replicationMode;
    }

    public boolean getSyncRemoteLink() {
        return syncRemoteLink;
    }

    public void setSyncRemoteLink(boolean syncRemoteLink) {
        this.syncRemoteLink = syncRemoteLink;
    }

    public double getDeduplicationRatio() {
        return deduplicationRatio;
    }

    public void setDeduplicationRatio(double deduplicationRatio) {
        this.deduplicationRatio = deduplicationRatio;
    }

    public double getAverageDeduplicationRatio() {
        return averageDeduplicationRatio;
    }

    public void setAverageDeduplicationRatio(double averageDeduplicationRatio) {
        this.averageDeduplicationRatio = averageDeduplicationRatio;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(averageJournalCompressionRatio);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(averageDeduplicationRatio);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(compressionRatio);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(deduplicationRatio);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result
            + ((detachData == null) ? 0 : detachData.hashCode());
        result = prime * result
            + ((detachDataRate == null) ? 0 : detachDataRate.hashCode());
        result = prime * result + ((lag == null) ? 0 : lag.hashCode());
        result = prime * result + numberOfGrids;
        result = prime * result
            + (int) (outgoingThroughput ^ (outgoingThroughput >>> 32));
        result = prime
            * result
            + ((outgoingThroughputPerRPA == null) ? 0
            : outgoingThroughputPerRPA.hashCode());
        result = prime * result
            + ((replicationMode == null) ? 0 : replicationMode.hashCode());
        result = prime * result + (syncRemoteLink ? 1231 : 1237);
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
        ConsistencyGroupLinkPipeStatistics other = (ConsistencyGroupLinkPipeStatistics) obj;
        if (Double.doubleToLongBits(averageJournalCompressionRatio) != Double
            .doubleToLongBits(other.averageJournalCompressionRatio))
            return false;
        if (Double.doubleToLongBits(averageDeduplicationRatio) != Double
            .doubleToLongBits(other.averageDeduplicationRatio))
            return false;
        if (Double.doubleToLongBits(compressionRatio) != Double
            .doubleToLongBits(other.compressionRatio))
            return false;
        if (Double.doubleToLongBits(deduplicationRatio) != Double
            .doubleToLongBits(other.deduplicationRatio))
            return false;
        if (detachData == null) {
            if (other.detachData != null)
                return false;
        } else if (!detachData.equals(other.detachData))
            return false;
        if (detachDataRate == null) {
            if (other.detachDataRate != null)
                return false;
        } else if (!detachDataRate.equals(other.detachDataRate))
            return false;
        if (lag == null) {
            if (other.lag != null)
                return false;
        } else if (!lag.equals(other.lag))
            return false;
        if (numberOfGrids != other.numberOfGrids)
            return false;
        if (outgoingThroughput != other.outgoingThroughput)
            return false;
        if (outgoingThroughputPerRPA == null) {
            if (other.outgoingThroughputPerRPA != null)
                return false;
        } else if (!outgoingThroughputPerRPA
            .equals(other.outgoingThroughputPerRPA))
            return false;
        if (replicationMode == null) {
            if (other.replicationMode != null)
                return false;
        } else if (!replicationMode.equals(other.replicationMode))
            return false;
        if (syncRemoteLink != other.syncRemoteLink)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(
            "ConsistencyGroupLinkPipeStatistics [averageJournalCompressionRatio=")
            .append(averageJournalCompressionRatio).append(
            ", averageDeduplicationRatio=").append(
            averageDeduplicationRatio)
            .append(", compressionRatio=").append(compressionRatio).append(
            ", deduplicationRatio=").append(deduplicationRatio)
            .append(", detachData=").append(detachData).append(
            ", detachDataRate=").append(detachDataRate).append(
            ", lag=").append(lag).append(", numberOfGrids=")
            .append(numberOfGrids).append(", outgoingThroughput=").append(
            outgoingThroughput).append(
            ", outgoingThroughputPerRPA=").append(
            outgoingThroughputPerRPA).append(", replicationMode=")
            .append(replicationMode).append(", syncRemoteLink=").append(
            syncRemoteLink).append("]");
        return builder.toString();
    }
}
