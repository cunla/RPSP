package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum ShareType {

    NFS23("NFS23"),
    NFS4("NFS4"),
    CIFS("CIFS"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
