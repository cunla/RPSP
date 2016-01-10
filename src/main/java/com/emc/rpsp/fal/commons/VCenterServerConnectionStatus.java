package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum VCenterServerConnectionStatus {
    CONNECTED("Connected"),
    AUTHENTICATION_FAILURE("AuthenticationFailure"),
    IP_UNREACHABLE("IPUnreachable"),
    UNSUPPORTED_VERSION("UnsupportedVersion"),
    INVALID_PORT("InvalidPort"),
    INVALID_PORT_OR_CERTIFICATE("InvalidPortOrCertificate"),
    UNKNOWN_ERROR("UnknownError"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
