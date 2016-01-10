package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum AxxanaCopyStatus {
    OK("Ok"),
    DISABLED("Disabled"),
    INITIALIZING("Initializing"),
    DOWN("Down"),
    EXCEEDING_LAG_POLICY("ExceedingLagPolicy"),
    FAILED_TO_CREATE("FailedToCreate"),
    MEMORY_PROBLEM("MemoryProblem"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
