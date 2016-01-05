package com.emc.rpsp.exceptions;

import com.emc.rpsp.RpspException;

/**
 * Created by morand3 on 1/5/2016.
 */
public class RpspBackupVmNotFoundException extends RpspException {
    public RpspBackupVmNotFoundException(String vmName) {
        super("No VM with name " + vmName);
    }
}
