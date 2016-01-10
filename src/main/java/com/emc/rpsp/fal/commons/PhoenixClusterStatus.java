package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum PhoenixClusterStatus {
    OK("OK"),
    DOWN("Down"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
