package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum QuantityType {
    MICROSECONDS("microseconds"),
    MILLISECONDS("milliseconds"),
    SECONDS("seconds"),
    MINUTES("minutes"),
    HOURS("hours"),
    DAYS("days"),
    BYTES("bytes"),
    KB("KB"),
    MB("MB"),
    GB("GB"),
    TB("TB"),
    WRITES("writes"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
