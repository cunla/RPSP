package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum ControllerType {
    CONTROLLER_TYPE_SCSI("scsi"),
    CONTROLLER_TYPE_SATA("sata"),
    CONTROLLER_TYPE_IDE("ide"),
    CONTROLLER_TYPE_UNKNOWN("unknown");

    private String name;

    public String toString() {
        return name;
    }
}
