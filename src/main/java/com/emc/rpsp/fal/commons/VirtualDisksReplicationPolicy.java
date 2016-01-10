package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualDisksReplicationPolicy")
public class VirtualDisksReplicationPolicy implements Validateable {
    @XmlElement(required = true)
    private boolean autoReplicateNewVirtualDisks;
    @XmlElement(nillable = true)
    private HashSet<VirtualDiskSettings> diskSettings;

}
