package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum LDAPSearchScope {
    SUB_TREE("SubTree"),
    ONE_LEVEL("OneLevel"),
    BASE_LEVEL("BaseLevel"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
