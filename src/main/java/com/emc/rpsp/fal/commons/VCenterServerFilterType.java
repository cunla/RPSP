package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum VCenterServerFilterType {
    ESX("ESX"),
    VM("VM"),
    LUN("Lun"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
