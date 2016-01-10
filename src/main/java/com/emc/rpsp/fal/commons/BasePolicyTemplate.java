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
@AllArgsConstructor
@XmlRootElement
@ToString

@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({ConsistencyGroupCopyPolicyTemplate.class, ConsistencyGroupLinkPolicyTemplate.class})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "JsonSubType")
@JsonSubTypes({
    @Type(value = ConsistencyGroupCopyPolicyTemplate.class, name = "ConsistencyGroupCopyPolicyTemplate"),
    @Type(value = ConsistencyGroupLinkPolicyTemplate.class, name = "ConsistencyGroupLinkPolicyTemplate")})
@XmlType(name = "BasePolicyTemplate")
public abstract class BasePolicyTemplate implements Validateable {

    @XmlElement(required = true)
    protected String name;

}
