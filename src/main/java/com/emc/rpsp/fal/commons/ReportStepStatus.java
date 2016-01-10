package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum ReportStepStatus {

    IN_PROGRESS("InProgress"),
    COMPLETED("Completed"),
    SKIPPED("Skipped"),
    FAILED("Failed"),
    FAILED_TIMEOUT("FailedTimeout"),
    COMPLETED_WITH_FAILURES("Completed With Failures"), //currently not in use. bug 118413: aggregation for super steps
    UNKNOWN("Unknown"),
    COMPLETED_FUTURE_USE_1("CompletedFutureUse1"),
    NOTCOMPLETED_FUTURE_USE_2("NonCompletedFutureUse2");

    private String name;

    public String toString() {
        return name;
    }

}
