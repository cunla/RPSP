package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum ReplicationSetType {
    BLOCK("Block"),
    FILE_SYSTEM("FileSystem"),
    VDM("VDM"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
