package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum LicenseStatus {
    ACTIVE("Active"),
    EXPIRED("Expired"),
    INACTIVE("Inactive"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
