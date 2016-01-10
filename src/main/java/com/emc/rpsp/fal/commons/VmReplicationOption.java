package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum VmReplicationOption {
    EXISTING_TARGET_VM("ExistingTargetVm"),
    CREATE_TARGET_VM("CreateTargetVm"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
