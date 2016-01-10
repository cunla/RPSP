package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum ReportType {

    ENABLE_IMAGE_ACCESS("EnableImageAccess"),
    DISABLE_IMAGE_ACCESS("DisableImageAccess"),
    ACCESS_ANOTHER_IMAGE("AccessAnotherImage"),
    FAILOVER("Failover"),
    RECOVER_PRODUCTION("RecoverProduction"),
    RESUME_PRODUCTION("ResumeProduction"),
    TEST_AND_PROMOTE("TestAndPromote"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
