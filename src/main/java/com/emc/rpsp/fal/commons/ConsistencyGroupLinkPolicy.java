package com.emc.rpsp.fal.commons;

import lombok.*;
import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

@JsonTypeName("ConsistencyGroupLinkPolicy")
@XmlType(name = "ConsistencyGroupLinkPolicy")
public class ConsistencyGroupLinkPolicy extends BaseValidatablePolicyTemplateType {

    @XmlElement(required = true)
    private LinkProtectionPolicy protectionPolicy;
    @XmlElement(required = true)
    private LinkAdvancedPolicy advancedPolicy;
    @XmlElement(nillable = true)
    private SnapshotShippingPolicy snapshotShippingPolicy;

}
