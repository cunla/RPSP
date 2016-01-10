package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author hacoho
 *         Enum to represent the image access scenario - on which gui flow was this image access requested on.
 */
@XmlRootElement
@AllArgsConstructor
public enum ImageAccessScenario {
    NONE("None"),
    FAILOVER("Failover"),
    TEMPORARY_FAILOVER("TemporaryFailover"),
    RECOVER_PRODUCTION("RecoverProduction"),
    TEST_REPLICA("TestReplica"),
    RESUME_PRODUCTION("ResumeProduction"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
