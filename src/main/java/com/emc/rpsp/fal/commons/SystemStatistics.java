package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@XmlRootElement
@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlType(name = "SystemStatistics")
//@LargeObject
public class SystemStatistics {
    // Add since GUI have no idea what is the RPA time when calling the getSystemStatistics API.
    // Theoretically they can call getCurrentTime, but it complicates their code...
    private RecoverPointTimeStamp currentRPATime;
    private HashSet<RPAStatistics> rpaStatistics;
    private HashSet<ConsistencyGroupStatistics> consistencyGroupStatistics;
    private HashSet<ClusterStatistics> clusterStatistics;
}
