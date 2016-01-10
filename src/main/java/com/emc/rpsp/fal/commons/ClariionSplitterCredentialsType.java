package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum ClariionSplitterCredentialsType {
    PASSWORD("Password"),
    SECURE_FILES("SecureFiles"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
