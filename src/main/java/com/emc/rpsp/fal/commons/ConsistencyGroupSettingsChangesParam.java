package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsistencyGroupSettingsChangesParam")
public class ConsistencyGroupSettingsChangesParam implements Validateable {

    @XmlElement(required = true)
    private ConsistencyGroupUID groupUID;
    private HashSet<ReplicationSetSettingsChangesParam> replicationSetsChanges;
    private HashSet<VmReplicationSetSettingsChangesParam> vmReplicationSetsChanges;
    private HashSet<ReplicationSetUID> removedReplicationSets;
    private HashSet<ConsistencyGroupCopySettingsChangesParam> copiesChanges;
    private ActivationSettingsChangesParams activationParams;

}
