package com.emc.rpsp.vmstructure.constants;

public enum TransferState {

    INITIALIZING("Initializing"),
    ACTIVE("Active"),
    STAND_BY("Stand by"),
    READY_TO_REPLICATE("Ready"),
    PAUSED("Paused"),
    PAUSED_BY_SYSTEM("Paused by system"),
    ERROR("Error"),
    UNKNOWN("Unknown");

    private final String stateVal;

    private TransferState(final String state) {
        stateVal = state;
    }

    public String value() {
        return stateVal;
    }

    public static TransferState fromValue(String v) {
        return valueOf(v);
    }

}
