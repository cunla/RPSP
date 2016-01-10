package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@AllArgsConstructor
@XmlRootElement
public enum InstallationActivityType {
    NEW_INSTALL("NewInstall"),
    SOFTWARE_UPGRADE("SoftwareUpgrade"),
    HARDWARE_UPGRADE("HardwareUpgrade"),
    RE_INSTALL("Reinstall"),
    GENERAL_UPDATE("GeneralUpdate"),
    UNKNOWN("Unknown");


    private String name;

    @Override
    public String toString() {
        return name;
    }
}
