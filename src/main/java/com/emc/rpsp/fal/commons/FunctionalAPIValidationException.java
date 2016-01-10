package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("serial")
@XmlRootElement

@JsonTypeName("FunctionalAPIValidationException")
@XmlType(name = "FunctionalAPIValidationException")
public class FunctionalAPIValidationException extends BaseFunctionalAPIException {

    public FunctionalAPIValidationException(String message) {
        super(message);
    }

    public FunctionalAPIValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
