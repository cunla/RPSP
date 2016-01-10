package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum ArrayConnectivityStatus {

    OK("OK"),
    DEGRADED("Degraded"),
    BAD_CREDENTIALS("BadCredentials"),
    BAD_CONNECTION_PARAMETERS("BadConnectionParameters"),
    FAILURE("Failure"),
    UNKNOWN("Unknown");

    private String name;

    @Override
    public String toString() {
        return name;
    }
}
