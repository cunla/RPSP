package com.emc.rpsp.fal.commons;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("serial")

@Data

@XmlSeeAlso({CreateVMParam.class, ExistingVMParam.class})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "JsonSubType")
@JsonSubTypes({
    @Type(value = CreateVMParam.class, name = "CreateVMParam"),
    @Type(value = ExistingVMParam.class, name = "ExistingVMParam")})
@XmlType(name = "VMParam")
public abstract
@XmlRootElement
class VMParam implements Validateable {

}
