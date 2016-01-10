package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum MountType {
    NONE("None"),
    READ_WRITE("ReadWrite"),
    READ_ONLY("ReadOnly"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
