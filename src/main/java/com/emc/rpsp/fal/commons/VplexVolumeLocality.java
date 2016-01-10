package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@AllArgsConstructor
@XmlRootElement
public enum VplexVolumeLocality {
    LOCAL("Local"), METRO_DR1("MetroDR1"), GEO("Geo"), REMOTE_EXPORTED("RemoteExported"), UNKNOWN("Unknown");

    private String value;

    public String toString() {
        return value;
    }
}
