package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum ClusterMaintenanceMode {
    NONE("None"),
    MINOR_UPGRADE("MinorUpgrade"),
    MAJOR_UPGRADE("MajorUpgrade"),
    HW_REPLACEMENT("HWReplacement"),
    CLUSTER_UPGRADE("ClusterUpgrade"),
    REPOSITORY_CHANGE("RepositoryChange"),
    RPSE_CONVERSION("RPSEConversion"),
    SYSTEM_MODIFICATION("SystemModification"),
    USER_INITIATED_MAINTENANCE_MODE("UserInitiatedMaintenanceMode"),
    CLUSTER_CONNECTION("ClusterConnection"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
