package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * The different states of execution an async-operation can be in.
 *
 * @author dagano
 */
@XmlRootElement
@AllArgsConstructor
public enum ExecutionState {
    UNKNOWN("Unknown"),
    RUNNING("Running"),
    FINISHED("Finished"),
    ABORTED("Aborted"),
    UNKNOWN_TRANSACTION("UnknownTransaction");

    private String name;

    public String toString() {
        return name;
    }

}
