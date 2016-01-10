package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@XmlRootElement
@XmlType(name = "ConsistencyGroupCopyJournal")
public class ConsistencyGroupCopyJournal {

    private HashSet<JournalVolumeSettings> journalVolumes;
    private long grossJournalSize;

    public ConsistencyGroupCopyJournal() {
    }

    public ConsistencyGroupCopyJournal(HashSet<JournalVolumeSettings> journalVolumes, long grossJournalSize) {
        this.journalVolumes = journalVolumes;
        this.grossJournalSize = grossJournalSize;
    }

    public HashSet<JournalVolumeSettings> getJournalVolumes() {
        return journalVolumes;
    }

    public void setJournalVolumes(HashSet<JournalVolumeSettings> journalVolumes) {
        this.journalVolumes = journalVolumes;
    }

    public long getGrossJournalSize() {
        return grossJournalSize;
    }

    public void setGrossJournalSize(long grossJournalSize) {
        this.grossJournalSize = grossJournalSize;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + (int) (grossJournalSize ^ (grossJournalSize >>> 32));
        result = prime * result
            + ((journalVolumes == null) ? 0 : journalVolumes.hashCode());
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
        ConsistencyGroupCopyJournal other = (ConsistencyGroupCopyJournal) obj;
        if (grossJournalSize != other.grossJournalSize)
            return false;
        if (journalVolumes == null) {
            if (other.journalVolumes != null)
                return false;
        } else if (!journalVolumes.equals(other.journalVolumes))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ConsistencyGroupCopyJournal [grossJournalSize=")
            .append(grossJournalSize).append(", journalVolumes=").append(
            journalVolumes).append("]");
        return builder.toString();
    }
}
