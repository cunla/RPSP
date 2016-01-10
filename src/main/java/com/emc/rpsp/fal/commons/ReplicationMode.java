package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum ReplicationMode {
    UNKNOWN("Unknown"),
    NA("NA"),
    SNAPSHOT("Snapshot"),
    ASYNCHRONOUS("Asynchronous"),
    PING_PONG("PingPong");

    private String name;

    public String toString() {
        return name;
    }

}
