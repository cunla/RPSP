package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum ConnectionStatus {
    SUCCESS("Success"),
    PASSWORD_EXPIRED("PasswordExpired"),
    TOO_MANY_CONNECTIONS("TooManyConnections"),
    NO_PERMISSION("NoPermission"),
    ERROR("Error");

    private String name;

    public String toString() {
        return name;
    }

}
