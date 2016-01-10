package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum HostConnectivityStatus {

    SUCCESS("Success"),
    AUTHENTICATION_FAILED("AuthenticationFailed"),
    NO_CONNECTION("NoConnection"),
    COMMAND_TIMED_OUT("CommandTimedOut"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
