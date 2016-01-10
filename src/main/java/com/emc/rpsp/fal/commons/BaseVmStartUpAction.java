package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlSeeAlso({VmStartUpPrompt.class,
    VmStartUpScript.class})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "JsonSubType")
@JsonSubTypes({
    @Type(value = VmStartUpPrompt.class, name = "VmStartUpPrompt"),
    @Type(value = VmStartUpScript.class, name = "VmStartUpScript")})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseVmStartUpAction")
public abstract class BaseVmStartUpAction implements Validateable {

    @XmlElement(required = true)
    private String title;
    protected int timeoutSecs;

}

