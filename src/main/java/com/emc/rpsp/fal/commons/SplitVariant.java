package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum SplitVariant {
    STANDARD("Standard"),
    TSP("TSP"),
    REDIRECT("Redirect"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
