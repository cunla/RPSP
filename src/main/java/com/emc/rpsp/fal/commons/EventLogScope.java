package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum EventLogScope {
    ROOT_CAUSE("RootCause"),
    NORMAL("Normal"),
    ADVANCED("Advanced"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
