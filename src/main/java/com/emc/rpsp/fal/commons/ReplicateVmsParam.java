package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement
@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReplicateVmsParam")
public class ReplicateVmsParam implements Validateable {

    @XmlElement(required = true)
    private String cgName;
    @XmlElement(required = true)
    private GlobalCopyUID productionCopy;
    @XmlElement(required = true)
    private HashSet<VMReplicationSetParam> vmReplicationSets;
    private HashSet<FullConsistencyGroupLinkPolicy> links;
    @XmlElement(required = true)
    private HashSet<ConsistencyGroupCopyParam> copies;
    @XmlElement(required = true)
    private boolean startTransfer;

}
