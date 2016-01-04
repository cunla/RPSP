package com.emc.rpsp.exceptions;

import com.emc.rpsp.RpspException;

/**
 * Created by morand3 on 1/4/2016.
 */
public class RpspBackupSystemNotSetException extends RpspException {
    public RpspBackupSystemNotSetException() {
        super("Backup system not set in environment");
    }
}
