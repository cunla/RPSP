package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum HostOS {
    AIX("AIX"),
    HPUX("HPUX"),
    LINUX_2_4("Linux24"),
    LINUX_2_6("Linux26"),
    SOLARIS("Solaris"),
    VMWARE_ESX("VMwareESX"),
    VMWARE_ESX_WINDOWS("VMwareESXWindows"),
    WINDOWS("Windows"),
    OTHER_MIXED("OtherMixed"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
