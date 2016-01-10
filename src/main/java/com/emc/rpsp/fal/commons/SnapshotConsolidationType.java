package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum SnapshotConsolidationType {
    NO_CONSOLIDATION("NoConsolidation"),
    MANUAL("Manual"),
    DAILY("Daily"),
    WEEKLY("Weekly"),
    MONTHLY("Monthly"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
