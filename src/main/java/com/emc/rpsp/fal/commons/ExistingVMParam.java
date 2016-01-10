package com.emc.rpsp.fal.commons;

import lombok.*;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@XmlAccessorType(XmlAccessType.FIELD)

@JsonTypeName("ExistingVMParam")
@XmlSeeAlso({SourceVmParam.class})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "JsonSubType")
@JsonSubTypes({
    @Type(value = SourceVmParam.class, name = "SourceVmParam")})
@XmlType(name = "ExistingVMParam")
public class ExistingVMParam extends VMParam {

    @XmlElement(nillable = true, required = true)
    private VmUID vmUID;

}
