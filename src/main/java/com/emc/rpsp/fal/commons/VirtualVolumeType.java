package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum VirtualVolumeType {

    VIRTUAL_DISK("VirtualDisk"),
    VIRTUAL_RDM("VirtualRDM"),
    PHYSICAL_RDM("PhysicalRDM"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
