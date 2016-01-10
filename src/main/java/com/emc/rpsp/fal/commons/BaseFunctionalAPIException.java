package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("serial")

@XmlSeeAlso({FunctionalAPIPasswordExpiredException.class, FunctionalAPIActionFailedException.class, FunctionalAPIInternalError.class, FunctionalAPIValidationException.class})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "JsonSubType")
@JsonSubTypes({
    @Type(value = FunctionalAPIPasswordExpiredException.class, name = "FunctionalAPIPasswordExpiredException"),
    @Type(value = FunctionalAPIActionFailedException.class, name = "FunctionalAPIActionFailedException"),
    @Type(value = FunctionalAPIInternalError.class, name = "FunctionalAPIInternalError"),
    @Type(value = FunctionalAPIValidationException.class, name = "FunctionalAPIValidationException")})
@JsonTypeName("BaseFunctionalAPIException")
@XmlType(name = "BaseFunctionalAPIException")
public abstract
@XmlRootElement
class BaseFunctionalAPIException extends Exception {

    protected BaseFunctionalAPIException(String message) {
        this(message, null);
    }

    protected BaseFunctionalAPIException(String message, Throwable cause) {
        super(message, cause);
    }
}
