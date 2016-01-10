package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum RPAType {
    PHYSICAL("Physical"),
    VIRTUAL("Virtual"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
