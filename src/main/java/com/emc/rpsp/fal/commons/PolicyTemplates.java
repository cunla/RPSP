package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Set;

@XmlRootElement
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@XmlType(name = "PolicyTemplates")
public class PolicyTemplates {

    private Set<ConsistencyGroupCopyPolicyTemplate> consistencyGroupCopyPolicyTemplate;
    private Set<ConsistencyGroupLinkPolicyTemplate> consistencyGroupLinkPolicyTemplate;

    // Default name cannot be 'default' - remote and local link are on the same map, and might have different default policy
    private String defaultGroupCopyPolicyName;
    private String defaultLocalGroupLinkPolicyName;
    private String defaultRemoteGroupLinkPolicyName;

}
