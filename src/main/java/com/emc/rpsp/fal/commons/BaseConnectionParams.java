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
@XmlSeeAlso({ScaleIoConnectionParams.class, VcConnectionParams.class, ClariionConnectionParams.class})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "JsonSubType")
@JsonSubTypes({
    @Type(value = ScaleIoConnectionParams.class, name = "ScaleIoConnectionParams"),
    @Type(value = VcConnectionParams.class, name = "VcConnectionParams"),
    @Type(value = ClariionConnectionParams.class, name = "ClariionConnectionParams")})
@XmlType(name = "BaseConnectionParams")
public class BaseConnectionParams implements Validateable {

    @XmlElement(required = true)
    private IPInformation mgmtIP;

}
