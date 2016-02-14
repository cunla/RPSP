package com.emc.rpsp.config;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.emc.rpsp.ExceptionInfo;

/**
 * Created by morand3 on 11/12/2015.
 */
@ControllerAdvice class GlobalDefaultExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "error";
    private final Logger log = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST) @ExceptionHandler(Exception.class) @ResponseBody
    ExceptionInfo defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
    	log.error(e.getMessage(), e);
        // If exception is part of the
        if (null != AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class))
            throw e;

        // Otherwise setup and send the user to a default error-view.
        ExceptionInfo exceptionInfo = new ExceptionInfo(req, e);

        return exceptionInfo;
    }
}
