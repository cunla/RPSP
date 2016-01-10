package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.FullVmReplicationSetPolicy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;

@AllArgsConstructor
@XmlRootElement
@NoArgsConstructor
@Data
public class FullVmReplicationSetPoliciesSet {
    private HashSet<FullVmReplicationSetPolicy> innerSet;
}
