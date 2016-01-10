package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ConsistencyGroupLinkPolicyTemplate;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement
@NoArgsConstructor
@Data
public class ConsistencyGroupLinkPolicyTemplateSet {
    private Set<ConsistencyGroupLinkPolicyTemplate> innerSet;

    public ConsistencyGroupLinkPolicyTemplateSet(
        Set<ConsistencyGroupLinkPolicyTemplate> consistencyGroupLinkPolicyTemplateSet) {
        this.innerSet = consistencyGroupLinkPolicyTemplateSet;
    }
}
