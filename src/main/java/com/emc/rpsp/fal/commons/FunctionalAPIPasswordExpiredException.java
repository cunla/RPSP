package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("serial")
@XmlRootElement

@JsonTypeName("FunctionalAPIPasswordExpiredException")
@XmlType(name = "FunctionalAPIPasswordExpiredException")
public class FunctionalAPIPasswordExpiredException extends BaseFunctionalAPIException {

    public FunctionalAPIPasswordExpiredException(String message) {
        super(message);
    }

    public FunctionalAPIPasswordExpiredException(String message, Throwable cause) {
        super(message, cause);
    }
}
