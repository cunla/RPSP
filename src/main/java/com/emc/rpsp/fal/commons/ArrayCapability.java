package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@AllArgsConstructor
@XmlRootElement
public enum ArrayCapability {

    DISCOVERY("Discovery"),
    DEVICE_MANAGEMENT("DeviceManagement"),
    INITIATOR_MANAGEMENT("InitiatorManagement"),
    CONSISTENT_SNAPSHOT("ConsistentSnapshot"),
    EXTENDED_DEVICE_MANAGEMENT("ExtendedDeviceManagement"),
    FAKE_SIZE("FakeSize"),
    JOURNAL_VOLUME_PROVISIONING("JournalVolumeProvisioning"),
    USER_VOLUME_PROVISIONING("UserVolumeProvisioning"),
    RESOURCE_POOL_REGISTRATION("ResourcePoolRegistration"),
    UNKNOWN("Unknown");

    private String name;

    @Override
    public String toString() {
        return name;
    }
}
