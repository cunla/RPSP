package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@AllArgsConstructor
@XmlRootElement
public enum HardwareChangesPolicy {

    DONT_REPLICATE_HW_CHANGES("DoNotReplicateHwChanges"),
    REPLICATE_HW_CHANGES("ReplicateHwChanges"),
    UNKNOWN("Unknown");

    private String value;

}
