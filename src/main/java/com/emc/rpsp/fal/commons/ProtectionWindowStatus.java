package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum ProtectionWindowStatus {
    SUFFICIENT("Sufficient"),
    INSUFFICIENT("Insufficient"),
    EXTENDING("Extending"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
