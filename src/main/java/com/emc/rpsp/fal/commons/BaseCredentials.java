package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@ToString(exclude = "password")
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({VcCredentials.class,
    ClariionCredentials.class,
    XioCredentials.class,
    VplexCredentials.class})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "JsonSubType")
@JsonSubTypes({
    @Type(value = VcCredentials.class, name = "VcCredentials"),
    @Type(value = ClariionCredentials.class, name = "ClariionCredentials"),
    @Type(value = XioCredentials.class, name = "XioCredentials"),
    @Type(value = VplexCredentials.class, name = "VplexCredentials")})
@XmlType(name = "BaseCredentials")
public class BaseCredentials implements Validateable {

    @XmlElement(required = true)
    private String username;
    @XmlElement(required = true)
    private byte[] password;

}
