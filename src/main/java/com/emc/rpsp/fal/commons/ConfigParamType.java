package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@AllArgsConstructor
@XmlRootElement
public enum ConfigParamType {

    IP("IP"),
    STRING("String"),
    PASSWORD("Password"),
    INTEGER("int"),
    UNKNOWN("Unknown");

    private String type;

    @Override
    public String toString() {
        return type;
    }
}
