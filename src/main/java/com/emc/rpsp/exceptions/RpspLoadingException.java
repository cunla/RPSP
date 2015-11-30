package com.emc.rpsp.exceptions;

import com.emc.rpsp.RpspException;

/**
 * Created by morand3 on 11/30/2015.
 */
public class RpspLoadingException extends RpspException {
    public RpspLoadingException(Exception e) {
        super(e);
    }
}
