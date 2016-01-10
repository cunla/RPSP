package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@AllArgsConstructor
@XmlRootElement
public enum RpSupportedArrayCapability {

    JVOL_AUTO_PROVISIONING("JvolAutoProvisioning"),
    UVOL_AUTO_PROVISIONING("UvolAutoProvisioning"),
    SNAPSHOT_SHIPPING("SnapshotShipping"),
    UNKNOWN("Unknown");

    private String name;

    @Override
    public String toString() {
        return name;
    }
}
