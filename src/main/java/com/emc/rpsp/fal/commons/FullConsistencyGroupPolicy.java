package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@SuppressWarnings("serial")
@XmlRootElement
@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FullConsistencyGroupPolicy")
public class FullConsistencyGroupPolicy implements Validateable {

    @XmlElement(required = true)
    private ConsistencyGroupUID groupUID;
    private ConsistencyGroupPolicy groupPolicy;
    @XmlElement(required = true)
    private String groupName;
    private HashSet<ConsistencyGroupCopyUID> productionCopies;
    private HashSet<FullConsistencyGroupCopyPolicy> copiesPolicies;
    private HashSet<FullConsistencyGroupLinkPolicy> linksPolicies;
    private HashSet<FullVmReplicationSetPolicy> vmReplicationSetsPolicies;

}
