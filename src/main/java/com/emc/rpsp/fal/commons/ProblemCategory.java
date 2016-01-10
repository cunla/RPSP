package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum ProblemCategory {
    SPLITTER("Splitter"),
    DEVICE("Device"),
    RPA("RPA"),
    LINK("Link"),
    SYSTEM("System"),
    CONSISTENCY_GROUP("ConsistencyGroup"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
