package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@XmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlType(name = "ConsistencyGroupSettings")
////@LargeObject
public class ConsistencyGroupSettings {

    private ConsistencyGroupUID groupUID;
    private String name;
    private boolean enabled;
    private HashSet<ConsistencyGroupCopyUID> productionCopiesUID;
    private ConsistencyGroupCopyUID latestSourceCopyUID;
    private HashSet<ConsistencyGroupCopySettings> groupCopiesSettings;
    private HashSet<ReplicationSetSettings> replicationSetsSettings;
    private ConsistencyGroupPolicy policy;
    private HashSet<ConsistencyGroupLinkSettings> activeLinksSettings;
    private HashSet<ConsistencyGroupLinkSettings> passiveLinksSettings;
    private HashSet<VmReplicationSetSettings> vmReplicationSetsSettings;
}
