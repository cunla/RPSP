package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum IRThrottleType {
    LOW("Low", 50),
    HIGH("High", 200),
    CUSTOM("Custom", 0),
    NONE("None", 0),
    UNKNOWN("Unkown", 0);

    private String name;
    private int numVal;

    public int getNumVal() {
        return numVal;
    }

    @Override
    public String toString() {
        return name;
    }

}
