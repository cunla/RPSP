package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@AllArgsConstructor
@XmlRootElement
public enum ArrayManagementProviderType {

    NAVISECCLI("NaviSecCLI"),
    XTREMIO("XtremIo"),
    VC("VCenter"),
    VPLEX("Vplex"),
    SMIS("SMI-S"),
    SCALEIO("ScaleIo"),
    UNKNOWN("Unkown");

    private String name;

    @Override
    public String toString() {
        return name;
    }
}
