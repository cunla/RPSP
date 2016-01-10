package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@AllArgsConstructor
@XmlRootElement
public enum ArrayResourcePoolSupportedTier {

    FC("FC"),
    SSD("SSD"),
    SATA("SATA"),
    FAST("FAST"),
    UNKNOWN("Unknown");

    private String name;

    @Override
    public String toString() {
        return name;
    }
}
