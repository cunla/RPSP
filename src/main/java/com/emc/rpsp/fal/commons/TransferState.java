package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum TransferState {

    ACTIVE("Active"),
    ERROR("Error"),
    INIT("Init"),
    PAUSED("Paused"),
    DISABLED("Disabled"),
    OTHER("Other");

    private String name;

    public static TransferState getTransferStateForPipeState(PipeState pipeState) {

        TransferState transferState;
        switch (pipeState) {
            case ACTIVE:
            case SNAP_IDLE:
            case SNAP_SHIPPING:
                transferState = ACTIVE;
                break;
            case INITIALIZING:
            case IN_HIGH_LOAD:
                transferState = INIT;
                break;
            case PAUSED:
            case PAUSED_BY_SYSTEM:
                transferState = PAUSED;
                break;
            case ERROR:
                transferState = ERROR;
                break;
            default:
                transferState = OTHER;
        }
        return transferState;
    }

    public String toString() {
        return name;
    }

}
