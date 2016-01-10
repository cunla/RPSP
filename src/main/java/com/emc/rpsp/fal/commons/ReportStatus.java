package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum ReportStatus {

    IN_PROGRESS("InProgress"),
    COMPLETED("Completed"),
    COMPLETED_WITH_FAILURES("Completed With Failures"),
    ABORTED("Aborted"),
    INITIALIZING("initializing"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
