package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum GroupSetTransferState {

    MIXED("Mixed"),
    INITIALIZING("Initializing"),
    ACTIVE("Active"),
    STAND_BY("StandBy"),
    FLUSHING_BUFFER("FlushingBuffer"),
    FLUSHING_REMOTE_BUFFER_TO_JOURNAL("FlushingRemoteBufferToJournal"),
    READY_TO_REPLICATE("ReadyToReplicate"),
    FLUSHED("Flushed"),
    PAUSED("Paused"),
    PAUSED_BY_SYSTEM("PausedBySystem"),
    ERROR("Error"),
    IN_HIGH_LOAD("InHighLoad"),
    SNAP_SHIPPING("SnapShipping"),
    SNAP_IDLE("SnapIdle"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
