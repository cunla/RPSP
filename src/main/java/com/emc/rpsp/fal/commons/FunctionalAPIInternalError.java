package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("serial")
@XmlRootElement

@JsonTypeName("FunctionalAPIInternalError")
@XmlType(name = "FunctionalAPIInternalError")
public class FunctionalAPIInternalError extends BaseFunctionalAPIException {

    public FunctionalAPIInternalError(String message) {
        super(message);
    }

    public FunctionalAPIInternalError(String message, Throwable cause) {
        super(message, cause);
    }
}
