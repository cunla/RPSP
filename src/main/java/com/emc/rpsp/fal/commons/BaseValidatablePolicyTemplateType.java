package com.emc.rpsp.fal.commons;

import lombok.Data;
import lombok.ToString;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * Wrapper class so FAPIImpl won't use Validatable Interface in exposed WS Methods.
 */
@SuppressWarnings("serial")
@Data
@XmlRootElement
@ToString

@XmlSeeAlso({ConsistencyGroupCopyPolicy.class, ConsistencyGroupLinkPolicy.class})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "JsonSubType")
@JsonSubTypes({
    @Type(value = ConsistencyGroupCopyPolicy.class, name = "ConsistencyGroupCopyPolicy"),
    @Type(value = ConsistencyGroupLinkPolicy.class, name = "ConsistencyGroupLinkPolicy")})
@XmlType(name = "BaseValidatablePolicyTemplateType")
public abstract class BaseValidatablePolicyTemplateType implements Validateable {

}
