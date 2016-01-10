package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum VMProtectionStatus {
    NOT_PROTECTED("NotProtected"),
    PARTIALLY_PROTECTED("PartiallyProtected"),
    FULLY_PROTECTED("FullyProtected"),
    NO_LUNS("NoLuns"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
