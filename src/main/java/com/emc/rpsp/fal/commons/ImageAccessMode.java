package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum ImageAccessMode {
    LOGGED_ACCESS("LoggedAccess"),
    VIRTUAL_ACCESS("VirtualAccess"),
    VIRTUAL_ACCESS_WITH_ROLL("VirtualAccessWithRoll"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
