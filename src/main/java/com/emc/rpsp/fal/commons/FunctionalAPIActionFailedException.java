package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("serial")
@XmlRootElement

@JsonTypeName("FunctionalAPIActionFailedException")
@XmlType(name = "FunctionalAPIActionFailedException")
public class FunctionalAPIActionFailedException extends BaseFunctionalAPIException {

    public FunctionalAPIActionFailedException(String message) {
        super(message);
    }

    public FunctionalAPIActionFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
