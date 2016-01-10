package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum ProblemSeverity {
    ERROR("Error"),
    CRITICAL("Critical"),
    WARNING("Warning"),
    UNKNOWN("Unknown"),
    OK("OK");

    private String name;

    public String toString() {
        return name;
    }

}
