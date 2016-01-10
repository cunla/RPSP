package com.emc.rpsp.fal.commons;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.*;

@XmlRootElement
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuppressWarnings("serial")

@XmlAccessorType(XmlAccessType.FIELD)
@JsonTypeName("ConsistencyGroupCopyPolicyTemplate")
@XmlType(name = "ConsistencyGroupCopyPolicyTemplate")
public class ConsistencyGroupCopyPolicyTemplate extends BasePolicyTemplate {

    @XmlElement(required = true)
    private ConsistencyGroupCopyPolicy policy;

    public ConsistencyGroupCopyPolicyTemplate(String name, ConsistencyGroupCopyPolicy policy) {
        super(name);
        this.policy = policy;
    }
}
