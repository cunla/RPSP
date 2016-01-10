package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum EventLogLevel {
    INFO("Info"),
    WARNING("Warning"),
    TRANSIENT_WARNING("TransientWarning"),
    CLEARED_WARNING("ClearedWarning"),
    ERROR("Error"),
    TRANSIENT_ERROR("TransientError"),
    CLEARED_ERROR("ClearedError"),
    CRITICAL("Critical"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
