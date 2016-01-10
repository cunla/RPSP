package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@XmlRootElement
@XmlType(name = "ConsistencyGroupCopyVolumesState")
public class ConsistencyGroupCopyVolumesState {

    private ConsistencyGroupCopyUID copyUID;
    private HashSet<JournalVolumeState> journalsState;

    public ConsistencyGroupCopyVolumesState() {
    }

    public ConsistencyGroupCopyVolumesState(ConsistencyGroupCopyUID copyUID, HashSet<JournalVolumeState> journalsState) {
        this.copyUID = copyUID;
        this.journalsState = journalsState;
    }

    public ConsistencyGroupCopyUID getCopyUID() {
        return copyUID;
    }

    public void setCopyUID(ConsistencyGroupCopyUID copyUID) {
        this.copyUID = copyUID;
    }

    public HashSet<JournalVolumeState> getJournalsState() {
        return journalsState;
    }

    public void setJournalsState(HashSet<JournalVolumeState> journalsState) {
        this.journalsState = journalsState;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((copyUID == null) ? 0 : copyUID.hashCode());
        result = prime * result
            + ((journalsState == null) ? 0 : journalsState.hashCode());
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
        ConsistencyGroupCopyVolumesState other = (ConsistencyGroupCopyVolumesState) obj;
        if (copyUID == null) {
            if (other.copyUID != null)
                return false;
        } else if (!copyUID.equals(other.copyUID))
            return false;
        if (journalsState == null) {
            if (other.journalsState != null)
                return false;
        } else if (!journalsState.equals(other.journalsState))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ConsistencyGroupCopyVolumesState [copyUID=").append(
            copyUID).append(", journalsState=").append(journalsState)
            .append("]");
        return builder.toString();
    }
}
