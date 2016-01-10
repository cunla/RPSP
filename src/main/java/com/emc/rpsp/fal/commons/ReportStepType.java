package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum ReportStepType {

    VM_POWER_ON("VmPowerOn"),
    VM_POWER_OFF("VmPowerOff"),
    PREPARE_STORAGE("PrepareStorage"),
    PREPARE_REPLICA("PrepareReplica"),
    PREPARE_SOURCE("PrepareSource"),
    PREPARE_REPLICATION("PrepareReplication"),
    PAUSE_TRANSFER("PauseTransfer"),
    VM_STARTUP_SEQUENCE("VmStartUpSequence"),
    VM_STARTUP_SCRIPT("VmStartUpScript"),
    VM_STARTUP_PROMPT("VmStartUpPrompt"),
    POWER_ON_VMS("PowerOnVms"), //currently not in use. bug 118413: aggregation for super steps
    POWER_OFF_VMS("PowerOffVms"), //currently not in use. bug 118413: aggregation for super steps
    UNKNOWN("Unknown");
    //USER_OK("USER_OK"); //P1

    private String name;

    public String toString() {
        return name;
    }

}

