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
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@SuppressWarnings("serial")


@XmlAccessorType(XmlAccessType.FIELD)
@JsonTypeName("ConsistencyGroupLinkPolicyTemplate")
@XmlType(name = "ConsistencyGroupLinkPolicyTemplate")
public class ConsistencyGroupLinkPolicyTemplate extends BasePolicyTemplate {

    @XmlElement(required = true)
    private ConsistencyGroupLinkPolicy policy;

    public ConsistencyGroupLinkPolicyTemplate(String name, ConsistencyGroupLinkPolicy policy) {
        super(name);
        this.policy = policy;
    }

    public static void main(String[] args) {
        ConsistencyGroupLinkPolicyTemplate a = new ConsistencyGroupLinkPolicyTemplate("blat", new ConsistencyGroupLinkPolicy());
        System.out.println(a);
    }
}
