package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@AllArgsConstructor
@XmlRootElement
public enum DiskProvisionPolicy {
    SAME_AS_SOURCE(0),
    AS_THICK(1),
    AS_THIN(2);

    private int value;

}
