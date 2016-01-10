package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@AllArgsConstructor

@XmlRootElement
public enum VplexMetroLinkState {

    CONNECTED("Connected"),
    FRACTURED("Fractured"),
    UNKNOWN("Unknown");

    private String name;

    @Override
    public String toString() {
        return name;
    }

}
