package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.LinkedList;

@XmlRootElement
@XmlType(name = "ConsistencyGroupCopySnapshots")
//@LargeObject
public class ConsistencyGroupCopySnapshots {

    private ConsistencyGroupCopyUID copyUID;
    private LinkedList<Snapshot> snapshots;
    private RecoverPointTimeStamp earliest;
    private RecoverPointTimeStamp latest;
    private Double averageCompression;
    private ProtectionWindowsInfo protectionWindows;
    private Double actualJournalCapacity;
    private Long journalUsage;

    public ConsistencyGroupCopySnapshots() {
    }

    public ConsistencyGroupCopySnapshots(ConsistencyGroupCopyUID copyUID, LinkedList<Snapshot> snapshots, RecoverPointTimeStamp earliest,
                                         RecoverPointTimeStamp latest, Double averageCompression, ProtectionWindowsInfo protectionWindows, Double actualJournalCapacity,
                                         Long journalUsage) {
        this.copyUID = copyUID;
        this.snapshots = snapshots;
        this.earliest = earliest;
        this.latest = latest;
        this.averageCompression = averageCompression;
        this.protectionWindows = protectionWindows;
        this.actualJournalCapacity = actualJournalCapacity;
        this.journalUsage = journalUsage;
    }

    public ConsistencyGroupCopyUID getCopyUID() {
        return copyUID;
    }

    public void setCopyUID(ConsistencyGroupCopyUID copyUID) {
        this.copyUID = copyUID;
    }

    public LinkedList<Snapshot> getSnapshots() {
        return snapshots;
    }

    public void setSnapshots(LinkedList<Snapshot> snapshots) {
        this.snapshots = snapshots;
    }

    public RecoverPointTimeStamp getEarliest() {
        return earliest;
    }

    public void setEarliest(RecoverPointTimeStamp earliest) {
        this.earliest = earliest;
    }

    public RecoverPointTimeStamp getLatest() {
        return latest;
    }

    public void setLatest(RecoverPointTimeStamp latest) {
        this.latest = latest;
    }

    public Double getAverageCompression() {
        return averageCompression;
    }

    public void setAverageCompression(Double averageCompression) {
        this.averageCompression = averageCompression;
    }

    public ProtectionWindowsInfo getProtectionWindows() {
        return protectionWindows;
    }

    public void setProtectionWindows(ProtectionWindowsInfo protectionWindows) {
        this.protectionWindows = protectionWindows;
    }

    public Double getActualJournalCapacity() {
        return actualJournalCapacity;
    }

    public void setActualJournalCapacity(Double actualJournalCapacity) {
        this.actualJournalCapacity = actualJournalCapacity;
    }

    public Long getJournalUsage() {
        return journalUsage;
    }

    public void setJournalUsage(Long journalUsage) {
        this.journalUsage = journalUsage;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((actualJournalCapacity == null) ? 0 : actualJournalCapacity
            .hashCode());
        result = prime
            * result
            + ((averageCompression == null) ? 0 : averageCompression
            .hashCode());
        result = prime * result + ((copyUID == null) ? 0 : copyUID.hashCode());
        result = prime * result
            + ((earliest == null) ? 0 : earliest.hashCode());
        result = prime * result
            + ((journalUsage == null) ? 0 : journalUsage.hashCode());
        result = prime * result + ((latest == null) ? 0 : latest.hashCode());
        result = prime
            * result
            + ((protectionWindows == null) ? 0 : protectionWindows
            .hashCode());
        result = prime * result
            + ((snapshots == null) ? 0 : snapshots.hashCode());
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
        ConsistencyGroupCopySnapshots other = (ConsistencyGroupCopySnapshots) obj;
        if (actualJournalCapacity == null) {
            if (other.actualJournalCapacity != null)
                return false;
        } else if (!actualJournalCapacity.equals(other.actualJournalCapacity))
            return false;
        if (averageCompression == null) {
            if (other.averageCompression != null)
                return false;
        } else if (!averageCompression.equals(other.averageCompression))
            return false;
        if (copyUID == null) {
            if (other.copyUID != null)
                return false;
        } else if (!copyUID.equals(other.copyUID))
            return false;
        if (earliest == null) {
            if (other.earliest != null)
                return false;
        } else if (!earliest.equals(other.earliest))
            return false;
        if (journalUsage == null) {
            if (other.journalUsage != null)
                return false;
        } else if (!journalUsage.equals(other.journalUsage))
            return false;
        if (latest == null) {
            if (other.latest != null)
                return false;
        } else if (!latest.equals(other.latest))
            return false;
        if (protectionWindows == null) {
            if (other.protectionWindows != null)
                return false;
        } else if (!protectionWindows.equals(other.protectionWindows))
            return false;
        if (snapshots == null) {
            if (other.snapshots != null)
                return false;
        } else if (!snapshots.equals(other.snapshots))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ConsistencyGroupCopySnapshots [actualJournalCapacity=")
            .append(actualJournalCapacity).append(", averageCompression=")
            .append(averageCompression).append(", copyUID=")
            .append(copyUID).append(", earliest=").append(earliest).append(
            ", journalUsage=").append(journalUsage).append(
            ", latest=").append(latest).append(
            ", protectionWindows=").append(protectionWindows)
            .append(", snapshots=").append(snapshots).append("]");
        return builder.toString();
    }
}
