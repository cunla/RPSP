package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlSeeAlso({FiberChannelInitiatorInformation.class, ISCSIInitiatorInformation.class})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "JsonSubType")
@JsonSubTypes({
    @Type(value = FiberChannelInitiatorInformation.class, name = "FiberChannelInitiatorInformation"),
    @Type(value = ISCSIInitiatorInformation.class, name = "ISCSIInitiatorInformation")})
@XmlType(name = "InitiatorInformation")
public abstract
@XmlRootElement
class InitiatorInformation {

    public InitiatorInformation() {
    }

}
