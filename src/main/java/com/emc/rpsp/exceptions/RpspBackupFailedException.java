package com.emc.rpsp.exceptions;

import com.emc.rpsp.RpspException;

/**
 * Created by morand3 on 1/5/2016.
 */
public class RpspBackupFailedException extends RpspException {

    public RpspBackupFailedException(String vm) {
        super("Backup failed for machine");
    }
}
