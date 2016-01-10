package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@AllArgsConstructor
@XmlRootElement
public enum ArrayResourcePoolType {

    STORAGE_POOL("StoragePool"),
    RAID_GROUP("RaidGoup"),
    VC_DATASTORE("VcDataStore"),
    UNKNOWN("Unknown");

    private String name;

    @Override
    public String toString() {
        return name;
    }
}
