package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum EventLogTopic {
    ALL("All"),
    MANAGEMENT("Management"),
    CLUSTER("Cluster"),
    RPA("RPA"),
    CONSISTENCY_GROUP("ConsistencyGroup"),
    SPLITTER("Splitter"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
