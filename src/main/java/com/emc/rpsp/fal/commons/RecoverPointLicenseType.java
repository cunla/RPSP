package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum RecoverPointLicenseType {
    SE("SE"),
    EX("EX"),
    CL("CL"),
    VE("VE"),
    VC("VC"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
