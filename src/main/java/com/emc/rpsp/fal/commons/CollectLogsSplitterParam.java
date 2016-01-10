package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import javax.xml.bind.annotation.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@SuppressWarnings("serial")
@XmlAccessorType(XmlAccessType.FIELD)

@XmlSeeAlso({CollectLogsSplitterParamWithCredentials.class})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "JsonSubType")
@JsonSubTypes({
    @Type(value = CollectLogsSplitterParamWithCredentials.class, name = "CollectLogsSplitterParamWithCredentials")})
@XmlType(name = "CollectLogsSplitterParam")
public class CollectLogsSplitterParam implements Validateable {

    @XmlElement(nillable = true, required = true)
    private SplitterUID splitterUID;

}
