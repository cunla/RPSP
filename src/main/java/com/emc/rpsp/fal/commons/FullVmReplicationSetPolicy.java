package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@SuppressWarnings("serial")
@XmlRootElement
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FullVmReplicationSetPolicy")
public class FullVmReplicationSetPolicy implements Validateable {

    @XmlElement(nillable = true, required = true)
    private VmReplicationSetUID vmReplicationSetUID;
    @XmlElement(nillable = true, required = true)
    private VmReplicationSetPolicy vmReplicationSetPolicy;
    @XmlElement(required = true)
    private HashSet<FullVmReplicationPolicy> vmReplicationPolicies;

}

