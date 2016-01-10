package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@XmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmReplicationSetSettings")
public class VmReplicationSetSettings {

    private HashSet<VmReplicationSettings> replicatedVMs;
    @XmlElement(nillable = true)
    private VmReplicationSetUID vmReplicationSetUID;
    private boolean autoReplicateNewVirtualDisks;
    private HashSet<VirtualDiskSettings> diskSettings;
    @XmlElement(nillable = true)
    private VmReplicationSetPolicy vmReplicationSetPolicy;
}
