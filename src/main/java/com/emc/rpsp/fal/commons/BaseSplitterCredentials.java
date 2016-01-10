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
@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({ClariionSplitterCredentials.class, VplexSplitterCredentials.class, VnxSplitterCredentials.class})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "JsonSubType")
@JsonSubTypes({
    @Type(value = ClariionSplitterCredentials.class, name = "ClariionSplitterCredentials"),
    @Type(value = VplexSplitterCredentials.class, name = "VplexSplitterCredentials"),
    @Type(value = VnxSplitterCredentials.class, name = "VnxSplitterCredentials")})
@XmlType(name = "BaseSplitterCredentials")
public abstract class BaseSplitterCredentials implements Validateable {

    @XmlElement(required = true)
    private String username;
    private boolean passwordConfigured;
    @XmlElement(required = true)
    private String ip; //This ip will also represent SPAip for clariion

}
