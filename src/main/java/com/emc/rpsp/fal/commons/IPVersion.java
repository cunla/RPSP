package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum IPVersion {
    IPV4("IPv4"),
    IPV6("IPv6"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
