package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum VolumeAccessStatus {
    OK("OK"),
    ERROR("Error"),
    RESERVED("Reserved"),
    BAD_SECTOR("BadSector"),
    READ_ONLY("ReadOnly"),
    NA("NA"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
