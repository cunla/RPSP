package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("serial")

@XmlSeeAlso({ImageAccessTargetVirtualNetworkAutomaticCreationParam.class, ImageAccessTargetVirtualNetworkManualSelectionParam.class})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "JsonSubType")
@JsonSubTypes({
    @Type(value = ImageAccessTargetVirtualNetworkAutomaticCreationParam.class, name = "ImageAccessTargetVirtualNetworkAutomaticCreationParam"),
    @Type(value = ImageAccessTargetVirtualNetworkManualSelectionParam.class, name = "ImageAccessTargetVirtualNetworkManualSelectionParam")})
@XmlType(name = "ImageAccessTargetVirtualNetworkParam")
public abstract
@XmlRootElement
class ImageAccessTargetVirtualNetworkParam implements Validateable {

}
