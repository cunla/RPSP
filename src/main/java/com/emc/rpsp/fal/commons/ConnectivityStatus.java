package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum ConnectivityStatus {
    STATUS_OK("StatusOk"),
    AUTHENTICATION_FAILURE("AuthenticationFailure"),
    IP_NOT_REACHABLE("IpNotReachable"),
    INVALID_PORT("InvalidPort"),
    UNKNOWN_ERROR("UnknownError"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
