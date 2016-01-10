package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum Permission {
    ARRAY_MANAGEMENT("ArrayManagement"),
    BOX_MANAGEMENT("BoxManagement"),
    FAILOVER("Failover"),
    GROUP("Group"),
    TRANSFER("Transfer"),
    TARGET_IMAGE("TargetImage"),
    SE("SE"),
    SECURITY("Security"),
    SPLITTER("Splitter"),
    SYSTEM("System"),
    UPGRADE("Upgrade"),
    MONITOR("Monitor"),
    WEB_DOWNLOAD("WebDownload"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
