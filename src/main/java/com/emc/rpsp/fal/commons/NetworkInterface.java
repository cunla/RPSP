package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum NetworkInterface {
    WAN("WAN"),
    LAN("LAN"),
    ISCSI1("ISCSI1"),
    ISCSI2("ISCSI2"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
