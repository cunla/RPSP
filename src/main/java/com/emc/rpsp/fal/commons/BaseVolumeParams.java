package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlSeeAlso({VolumeCreationParams.class, VolumeSelectionParam.class})
@SuppressWarnings("serial")


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "JsonSubType")
@JsonSubTypes({
    @Type(value = VolumeSelectionParam.class, name = "VolumeSelectionParam"),
    @Type(value = VolumeCreationParams.class, name = "VolumeCreationParams")})
@XmlRootElement
@XmlType(name = "BaseVolumeParams")
public abstract class BaseVolumeParams implements Validateable {
}
