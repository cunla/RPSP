package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum LicenseCapacityUnit {
    TERA_BYTE("TeraByte"),
    BYTE("Byte"),
    BRICKS("Brick"),
    VM("VM"),
    UNKNOWN("Unknown");


    private String name;

    public String toString() {
        return name;
    }

}
