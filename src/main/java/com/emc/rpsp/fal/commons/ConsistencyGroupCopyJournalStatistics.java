package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlType(name = "ConsistencyGroupCopyJournalStatistics")
public class ConsistencyGroupCopyJournalStatistics {

    private Boolean distributionFinished;
    private Long imageAccessSizeLeftInBytes;
    private Long imageAccessTimeLeftInSeconds;
    private Long imageAccessTotalSizeInBytes;
    private Double tspUsagePercentage;
    private Long tspUsageInBytes;
    private Long journalLagInBytes;
    private SnapshotConsolidationStatistics consolidationStatistics;
    private boolean fastForward;
    private RecoverPointTimeStamp movingFrom;
    private RecoverPointTimeStamp movingTo;
    private long actualJournalSizeInBytes;
    private long actualJournalUsageInBytes;
    private double usagePercentFromDistributionCapacity;
}
