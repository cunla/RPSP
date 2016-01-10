package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@AllArgsConstructor
@XmlRootElement
public enum ClariionCredentialsType {

    PASSWORD("Password"),
    SECURE_FILES("SecureFiles"),
    VNX2E("Vnx2e"),
    UNKNOWN("Unknown");

    private String name;

    @Override
    public String toString() {
        return name;
    }
}
