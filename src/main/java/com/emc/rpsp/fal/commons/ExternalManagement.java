package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum ExternalManagement {
    NONE("None"),
    RPCE("RPCE"),
    SRM("SRM"),
    REE("REE"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
