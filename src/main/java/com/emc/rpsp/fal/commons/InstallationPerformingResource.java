package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@AllArgsConstructor
@XmlRootElement
public enum InstallationPerformingResource {
    CUSTOMER("Customer"),
    EMC_EMPLOYEE("EMCEmployee"),
    EMC_PARTNER("EMCPartner"),
    UNKNOWN("Unknown");

    private String name;

    @Override
    public String toString() {
        return name;
    }
}
