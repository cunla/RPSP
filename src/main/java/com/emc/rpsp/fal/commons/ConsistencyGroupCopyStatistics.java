package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "ConsistencyGroupCopyStatistics")
public class ConsistencyGroupCopyStatistics {

    private ConsistencyGroupCopyUID copyUID;
    private long averageIncomingThroughput;
    private long averageIncomingWrites;
    private long incomingThroughput;
    private long incomingWrites;
    private ConsistencyGroupCopyJournalStatistics journalStatistics;

    public ConsistencyGroupCopyStatistics() {
    }

    public ConsistencyGroupCopyStatistics(ConsistencyGroupCopyUID copyUID, long averageIncomingThroughput, long averageIncomingWrites,
                                          long incomingThroughput, long incomingWrites, ConsistencyGroupCopyJournalStatistics journalStatistics) {
        this.copyUID = copyUID;
        this.averageIncomingThroughput = averageIncomingThroughput;
        this.averageIncomingWrites = averageIncomingWrites;
        this.incomingThroughput = incomingThroughput;
        this.incomingWrites = incomingWrites;
        this.journalStatistics = journalStatistics;
    }

    public ConsistencyGroupCopyUID getCopyUID() {
        return copyUID;
    }

    public void setCopyUID(ConsistencyGroupCopyUID copyUID) {
        this.copyUID = copyUID;
    }

    public long getAverageIncomingThroughput() {
        return averageIncomingThroughput;
    }

    public void setAverageIncomingThroughput(long averageIncomingThroughput) {
        this.averageIncomingThroughput = averageIncomingThroughput;
    }

    public long getAverageIncomingWrites() {
        return averageIncomingWrites;
    }

    public void setAverageIncomingWrites(long averageIncomingWrites) {
        this.averageIncomingWrites = averageIncomingWrites;
    }

    public long getIncomingThroughput() {
        return incomingThroughput;
    }

    public void setIncomingThroughput(long incomingThroughput) {
        this.incomingThroughput = incomingThroughput;
    }

    public long getIncomingWrites() {
        return incomingWrites;
    }

    public void setIncomingWrites(long incomingWrites) {
        this.incomingWrites = incomingWrites;
    }

    public ConsistencyGroupCopyJournalStatistics getJournalStatistics() {
        return journalStatistics;
    }

    public void setJournalStatistics(
        ConsistencyGroupCopyJournalStatistics journalStatistics) {
        this.journalStatistics = journalStatistics;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + (int) (averageIncomingThroughput ^ (averageIncomingThroughput >>> 32));
        result = prime
            * result
            + (int) (averageIncomingWrites ^ (averageIncomingWrites >>> 32));
        result = prime * result + ((copyUID == null) ? 0 : copyUID.hashCode());
        result = prime * result
            + (int) (incomingThroughput ^ (incomingThroughput >>> 32));
        result = prime * result
            + (int) (incomingWrites ^ (incomingWrites >>> 32));
        result = prime
            * result
            + ((journalStatistics == null) ? 0 : journalStatistics
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
        ConsistencyGroupCopyStatistics other = (ConsistencyGroupCopyStatistics) obj;
        if (averageIncomingThroughput != other.averageIncomingThroughput)
            return false;
        if (averageIncomingWrites != other.averageIncomingWrites)
            return false;
        if (copyUID == null) {
            if (other.copyUID != null)
                return false;
        } else if (!copyUID.equals(other.copyUID))
            return false;
        if (incomingThroughput != other.incomingThroughput)
            return false;
        if (incomingWrites != other.incomingWrites)
            return false;
        if (journalStatistics == null) {
            if (other.journalStatistics != null)
                return false;
        } else if (!journalStatistics.equals(other.journalStatistics))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(
            "ConsistencyGroupCopyStatistics [averageIncomingThroughput=")
            .append(averageIncomingThroughput).append(
            ", averageIncomingWrites=").append(
            averageIncomingWrites).append(", copyUID=").append(
            copyUID).append(", incomingThroughput=").append(
            incomingThroughput).append(", incomingWrites=").append(
            incomingWrites).append(", journalStatistics=").append(
            journalStatistics).append("]");
        return builder.toString();
    }
}
