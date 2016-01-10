package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum SnapshotGranularity {
    DYNAMIC("Dynamic"),
    FIXED_PER_SECOND("FixedPerSecond"),
    FIXED_PER_WRITE("FixedPerWrite"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
