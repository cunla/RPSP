package com.emc.rpsp.exceptions;

import com.emc.rpsp.RpspException;

/**
 * Created by morand3 on 1/3/2016.
 */
public class RpspParamsException extends RpspException {
    public RpspParamsException() {
        super("Invalid parameters sent");
    }
}
