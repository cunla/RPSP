package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@AllArgsConstructor
@XmlRootElement
public enum VplexCredentialsType {

    VPLEX("Vplex"),        // what mgmt defines as CommonCredentialsType.CREDENTIALS_VPLEX
    VPLEX_IC("VplexIC"),
    UNKNOWN("Unknown");

    private String name;

    @Override
    public String toString() {
        return name;
    }
}
