package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author hacoho
 *         Enum to represent the Snapshot consistency type
 */
@XmlRootElement
@AllArgsConstructor
public enum SnapshotConsistencyType {
    CONSISTENCY_UNKNOWN("ConsistencyUnknown"),
    APPLICATION_CONSISTENT("ApplicationConsistent"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
