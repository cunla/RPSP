package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@AllArgsConstructor
@XmlRootElement
public enum ArrayType {
    VNX("VNX"),
    VNXE("VNXe"),
    SYMMETRIX("SYMMETRIX"),
    CX("CX"),
    VPLEX("VPLEX"),
    VC("VC"),
    XTREMEIO("XTREMIO"),
    SCALEIO("ScaleIo"),
    UNKNOWN("UNKNOWN");

    private String name;

    public String toString() {
        return name;
    }

}
