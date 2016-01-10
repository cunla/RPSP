package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("serial")

@XmlSeeAlso({CreateTargetVMAutomaticResourcePlacementParam.class, CreateTargetVMManualResourcePlacementParam.class})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "JsonSubType")
@JsonSubTypes({
    @Type(value = CreateTargetVMAutomaticResourcePlacementParam.class, name = "CreateTargetVMAutomaticResourcePlacementParam"),
    @Type(value = CreateTargetVMManualResourcePlacementParam.class, name = "CreateTargetVMManualResourcePlacementParam")})
@XmlType(name = "CreateTargetVMResourcePlacementParam")
public abstract
@XmlRootElement
class CreateTargetVMResourcePlacementParam implements Validateable {

}
