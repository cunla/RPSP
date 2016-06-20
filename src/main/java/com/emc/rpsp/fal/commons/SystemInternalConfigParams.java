package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlType(name = "SystemInternalConfigParams")
public class SystemInternalConfigParams {

    private long snapshotUpdateInterval;
    private long journalSizeLimitInGB;
    private int minTSPPercentage;
    private int modelUpdaterFrequency;
    private long eventLogsMaxNumberOfEntries;
    private int mgmtMaxActivityTime;
    private double tspMemoryAlmostFullWaterMark;
    private int minUnconsolidatedDuration;
    private int defaultUnconsolidatedDuration;
    private int defaultDailyImages;
    private int defaultWeeklyImages;
    private int defaultMonthlyImages;
    private int daysPerMonth;
    private int lowestLatencyThreshold;
    private int highestLatencyThreshold;
    private int lowestThroughputThreshold;
    private int highestThroughputThreshold;
    private int defaultStartAsyncAboveLatency;
    private int defaultResumeSyncBelowLatency;
    private int defaultStartAsyncAboveThroughput;
    private int defaultResumeSyncBelowThroughput;
    private boolean simulator;
    private boolean enableClariionVirtualWithRoll;
    private boolean displayCertificateExtensions;
    private boolean fcReplication;
    private String clariionFirstSuffix;
    private String clariionSecondSuffix;
    private String singleApplianceString;
    private String multipleAppliancesString;
    private boolean rpse;
    private String companyName;
    private int rpseSetGroupSettingsTimeForSingleOperation;
    private int maxGridCopiesPerGroup;
    private String e14ServerName;
    private String version;
    private int flexFiltersRunIntervalInMinutes;
    private int maximumSplittersPerCluster;
    private boolean syrSupported;
    private int peerStateUpdateInterval;
    private int rootCausesStabilizationTime;
    private long snapshotConsolidationTimeAcceleration;
    private int maxGridGroups;
    private int maxGroups;
    private long monitorSplitterStateLease;
    private long controlWriteTimeout;
    private int maxPersistentSnapshots;
    private boolean trackInitInconsistency;
    private boolean usePWLOnWAN;
    private long dynamicDontMoveToSyncTime;
    private long additionToSyncLatency;
    private String product;
    private long splitterMonitorRPATimeout;
    private String oem;
    private String phoenixSystemTM;
    private int mgmtScaledMaxActivityTime;
    private int minNumOfVolumesInScaledEnv;
    private boolean allowSettingsChangesDuringMaintenance;
    private int maxNumberOfGroupSets;
    private int maxNumberOfCGsInConsistentGroupSet;
    private int maxDesiredSnapshotsDefaultPercentage;
    private int maxAllowedSnapshots;
    private int defaultSnapshotShippingIntervalInMinutes;
    private boolean displayTrialVersion;
}
