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

    private long snapshotUpdateInterval; // tweak 't_snapshotUpdateLongInterval'
    private long journalSizeLimitInGB; // tweak 't_JournalSizeLimit'
    private int minTSPPercentage; // tweak 't_minTSPPercentage'
    private int modelUpdaterFrequency; // tweak 't_modelUpdaterFrequency'
    private long eventLogsMaxNumberOfEntries; // tweak 't_ELGR_MaxNumberOfEntries'
    private int mgmtMaxActivityTime; // tweak 't_mgmtMaxActivityTime'
    private double tspMemoryAlmostFullWaterMark; // tweak 't_TSPMemoryAlmostFullWaterMark'
    private int minUnconsolidatedDuration; // Noted in seconds (tweak 't_minUnconsolidatedDuration')
    private int defaultUnconsolidatedDuration; // Noted in seconds (tweak 't_defaultUnconsolidatedDuration')
    private int defaultDailyImages; // tweak 't_defaultDailyImages'
    private int defaultWeeklyImages; // tweak 't_defaultWeeklyImages'
    private int defaultMonthlyImages; // unlimited (tweak 't_defaultMonthlyImages')
    private int daysPerMonth; // tweak 't_daysPerMonth'
    private int lowestLatencyThreshold; // In microseconds (tweak 't_lowestLatencyThreshold')
    private int highestLatencyThreshold; // In microseconds (tweak 't_highestLatencyThreshold')
    private int lowestThroughputThreshold; // In Kbyte per sec (tweak 't_lowestThroughputThreshold')
    private int highestThroughputThreshold; // In Kbyte per sec (tweak 't_highestThroughputThreshold')
    private int defaultStartAsyncAboveLatency; // In microseconds (tweak 't_default_startAsyncAboveLatency')
    private int defaultResumeSyncBelowLatency; // In microseconds (tweak 't_default_resumeSyncBelowLatency')
    private int defaultStartAsyncAboveThroughput; // In Kbyte per sec (tweak 't_default_startAsyncAboveThroughput')
    private int defaultResumeSyncBelowThroughput; // In Kbyte per sec (tweak 't_default_resumeSyncBelowThroughput')
    private boolean simulator; // tweak 't_isSimulator'
    private boolean enableClariionVirtualWithRoll; // tweak 't_enableClariionVirtualWithRoll'
    private boolean displayCertificateExtensions; // tweak 't_displayCertificateExtensions'
    private boolean fcReplication; // tweak 't_fcReplication'
    private String clariionFirstSuffix; // tweak 't_clariionFirstSuffix'
    private String clariionSecondSuffix; // tweak 't_clariionSecondSuffix'
    private String singleApplianceString; // tweak 't_singleAppliance'
    private String multipleAppliancesString; // tweak 't_multipleAppliances'
    private boolean rpse; // tweak 't_isRPSE'
    private String companyName; // tweak 'company'
    private int rpseSetGroupSettingsTimeForSingleOperation; // tweak 't_RPSESetGroupSettingsTimeForSingleOperation'
    private int maxGridCopiesPerGroup; // tweak 't_maxGridCopiesPerGroup'
    private String e14ServerName; // tweak 't_e14ServerName'
    private String version; // tweak 't_extVersionVisibleString'
    private int flexFiltersRunIntervalInMinutes; // tweak 't_flexFilterRunInterval'
    private int maximumSplittersPerCluster; // tweak 't_maxHostPerCluster'
    private boolean syrSupported; // tweak 't_supportSYR'
    private int peerStateUpdateInterval; // tweak 't_SC_UpdatePeerStateRegulationTimeInterval'
    private int rootCausesStabilizationTime; // tweak 't_SC_RootCauseStabilizationTime'
    private long snapshotConsolidationTimeAcceleration; // tweak 't_snapshotConsolidationTimeAcceleration'
    private int maxGridGroups; // tweak 't_maxGridGroups'
    private int maxGroups; // tweak 't_maxGroups'
    private long monitorSplitterStateLease; // tweak 't_HM_hostStateLease'
    private long controlWriteTimeout; // tweak 't_lepWriteTimeOut'
    private int maxPersistentSnapshots; // tweak 't_MaxNumberOfPersistentSnapshots'
    private boolean trackInitInconsistency; // tweak 't_trackInitInconsistency'
    private boolean usePWLOnWAN; // tweak 't_usePWLOnWAN'
    private long dynamicDontMoveToSyncTime; // tweak 't_dynamicDontChangeToSyncTime'
    private long additionToSyncLatency; // tweak 't_additionToSyncLatency'
    private String product; // tweak 'product'
    private long splitterMonitorRPATimeout; // tweak 't_HM_KboxCSCRimeout'
    private String oem; // String value of 'OEMType' in the MgmtState
    private String phoenixSystemTM; // tweak 't_phoenixSystemTrademark'
    private int mgmtScaledMaxActivityTime; // tweak 't_mgmtScaledEnvMaxActivityTime'
    private int minNumOfVolumesInScaledEnv; // tweak 't_minNumOfVolumesInScaledEnv'
    private boolean allowSettingsChangesDuringMaintenance;// tweak 't_limitMaintenanceModeChanges'
    private int maxNumberOfGroupSets;// tweak 't_maxNumberOfGroupCollections'
    private int maxNumberOfCGsInConsistentGroupSet;// tweak 't_maxNumberOfGroupsInConsistentGroupCollection'
    private int maxDesiredSnapshotsDefaultPercentage; // tweak t_maxDesiredSnapshotsDefaultPercentage
    private int maxAllowedSnapshots; // t_maxSnapshotsAllowedByRP
    private int defaultSnapshotShippingIntervalInMinutes; // In minutes (tweak 't_defaultSnapshotShippingInterval') //#######################
    private boolean displayTrialVersion; //'t_checkLicense'
}
