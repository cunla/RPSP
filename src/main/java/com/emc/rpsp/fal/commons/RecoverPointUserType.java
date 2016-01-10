package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum RecoverPointUserType {
    LOCAL_USER("LocalUser"),
    LDAP_USER("LDAPUser"),
    LDAP_GROUP("LDAPGroup"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
