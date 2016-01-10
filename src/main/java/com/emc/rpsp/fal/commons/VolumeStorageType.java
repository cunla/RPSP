package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@AllArgsConstructor
@XmlRootElement
public enum VolumeStorageType {

    VNX_OR_CLARIION("VnxOrClariion"),
    SYMMETRIX("Symmetrix"),
    VPLEX("Vplex"),
    XTREME_IO("XtremeIo"),
    OTHER("Other"),
    VIRTUAL("Virtual"),
    UNKNOWN("Unknown");

    private String name;

    @Override
    public String toString() {
        return name;
    }
}
