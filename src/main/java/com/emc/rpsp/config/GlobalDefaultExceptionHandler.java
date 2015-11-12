package com.emc.rpsp.config;

import com.emc.rpsp.ExceptionInfo;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by morand3 on 11/12/2015.
 */
@ControllerAdvice class GlobalDefaultExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "error";

    @ResponseStatus(HttpStatus.BAD_REQUEST) @ExceptionHandler(Exception.class) @ResponseBody
    ExceptionInfo defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        // If exception is part of the
        if (null != AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class))
            throw e;

        // Otherwise setup and send the user to a default error-view.
        ExceptionInfo exceptionInfo = new ExceptionInfo(req, e);

        return exceptionInfo;
    }
}
