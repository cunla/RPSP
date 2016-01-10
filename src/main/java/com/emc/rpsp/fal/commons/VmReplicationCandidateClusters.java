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
@XmlType(name = "VmReplicationCandidateClusters")
public class VmReplicationCandidateClusters {

    private HashSet<VmReplicationNonCandidateClusterReasons> nonCandidateClustersReasons;
    private HashSet<VmReplicationCandidateCluster> replicationCandidateClusters;
}
