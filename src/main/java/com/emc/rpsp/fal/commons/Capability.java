package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum Capability {
    SYNC_REPLICATION("SyncReplication"),
    VOLUMES_GREATER_THAN_TWO_TERA_BYTES("VolumesGreaterThanTwoTeraBytes"),
    VIRTUAL_ACCESS("VirtualAccess"),
    VIRTUAL_ACCESS_WITH_ROLL("VirtualAccessWithRoll"),
    READ_ONLY_ON_REPLICA("ReadOnlyOnReplica"),
    FAKE_VOLUME_SIZE("FakeVolumeSize"),
    VOLUME_RESIZE("VolumeResize"),
    UNMAP_VOLUME_COMMAND("UnmapVolumeCommand"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
