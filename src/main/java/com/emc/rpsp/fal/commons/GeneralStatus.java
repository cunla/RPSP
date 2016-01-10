package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum GeneralStatus {
    OK("OK"),
    ERROR("Error"),
    UNKNOWN("Unknown"),
    WARNING("Warning");

    private String name;

    public String toString() {
        return name;
    }

}
