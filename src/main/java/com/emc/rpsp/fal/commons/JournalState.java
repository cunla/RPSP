package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum JournalState {
    DISTRIBUTING("Distributing"),
    ENABLING_LOGGED_ACCESS("EnablingLoggedAccess"),
    ENABLING_VIRTUAL_ACCESS("EnablingVirtualAccess"),
    SNAPSHOT_ACCESS("SnapshotAccess"),
    ERROR_ACCESSING_VIRTUAL_IMAGE("ErrorAccessingVirtualImage"),
    ERROR_ACCESSING_PHYSICAL_IMAGE("ErrorAccessingPhysicalImage"),
    LOCKING("Locking"),
    LOCKED("Locked"),
    LONG_RESYNC("LongResync"),
    RECOVERING("Recovering"),
    INACCESSIBLE("Inaccessible"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
