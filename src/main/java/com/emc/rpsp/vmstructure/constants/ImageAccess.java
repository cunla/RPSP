package com.emc.rpsp.vmstructure.constants;

public enum ImageAccess {

    ENABLED("Enabled"),
    ENABLING("Enabling"),
    DISABLED("Disabled");
    

    private final String stateVal;

    private ImageAccess(final String state) {
        stateVal = state;
    }

    public String value() {
        return stateVal;
    }

    public static ImageAccess fromValue(String v) {
        return valueOf(v);
    }
}
