package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum StorageAccessState {
    DIRECT_ACCESS("DirectAccess"),
    LOGGED_ACCESS("LoggedAccess"),
    VIRTUAL_ACCESS("VirtualAccess"),
    ENABLING_LOGGED_ACCESS("EnablingLoggedAccess"),
    ENABLING_VIRTUAL_ACCESS("EnablingVirtualAccess"),
    VIRTUAL_ACCESS_ROLLING_IMAGE("VirtualAccessRollingImage"),
    LOGGED_ACCESS_ROLL_COMPLETE("LoggedAccessRollComplete"),
    NO_ACCESS("NoAccess"),
    NO_ACCESS_UNDOING_WRITES("NoAccessUndoingWrites"),
    NO_ACCESS_SPACE_FULL("NoAccessSpaceFull"),
    NO_ACCESS_JOURNAL_PRESERVED("NoAccessJournalPreserved"),
    NO_ACCESS_BFS_GROUP("NoAccessBFSGroup"),
    VIRTUAL_ACCESS_CANNOT_ROLL_IMAGE("VirtualAccessCannotRollImage"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
