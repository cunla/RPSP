package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum NetBiosMode {

    DISABLED("Disabled"),
    ENABLED("Enabled"),
    ENABLED_VIA_DHCP("EnabledViaDHCP"),
    UNKNOWN("Unknown");

    private String name;

    @Override
    public String toString() {
        return name;
    }
}

