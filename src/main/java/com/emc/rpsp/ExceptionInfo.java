package com.emc.rpsp;

import org.apache.commons.lang3.exception.ExceptionUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by morand3 on 11/12/2015.
 */
public class ExceptionInfo {
    public final String url;
    public final String ex;
    public String[] stackTrace;

    public ExceptionInfo(String url, Exception ex) {
        this.url = url;
        this.ex = ex.getLocalizedMessage();
        this.stackTrace = ExceptionUtils.getStackTrace(ex).split("\r\n\t");
    }

    public ExceptionInfo(HttpServletRequest req, Exception e) {
        this(req.getRequestURI(), e);
    }
}
