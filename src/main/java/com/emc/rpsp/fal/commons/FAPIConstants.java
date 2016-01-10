package com.emc.rpsp.fal.commons;

import java.nio.charset.Charset;

public class FAPIConstants {

    public static final String STRING_TO_BYTES_CHARSET_NAME = "ISO-8859-1"; // TODO should this be tweakable?
    public static final Charset STRING_TO_BYTES_CHARSET = Charset.forName(STRING_TO_BYTES_CHARSET_NAME);
    public static final String JAVA_SCRIPT_FILE_EXTENSION = ".js";
    public static final String JAVA_SCRIPT_MEDIA_TYPE = "application/javascript";

    public static final int ILLEGAL_ID = -1;
    public static final int ILLEGAL_TIME = -10;
    public static final int ILLEGAL_DATA_SIZE = -1;

    public static final long INFINITE_TIME_COUNTER = -1;
    public static final long MICROS_IN_A_MILLISECOND = 1000l;
    public static final long MICROS_IN_A_SECOND = 1000 * MICROS_IN_A_MILLISECOND;
    public static final long MICROS_IN_A_MINUTE = 60 * MICROS_IN_A_SECOND;
    public static final long MICROS_IN_A_HOUR = 60 * MICROS_IN_A_MINUTE;
    public static final long MICROS_IN_A_DAY = 24 * MICROS_IN_A_HOUR;
    public static final long SECONDS_IN_A_DAY = MICROS_IN_A_DAY / MICROS_IN_A_SECOND;
    public static final long DAYS_IN_A_WEEK = 7l;
    public static final long HOURS_IN_A_DAY = 24l;
    public static final long MINUTES_IN_HOUR = 60l;
    public static final long MILIS_IN_A_MINUTE = MICROS_IN_A_MINUTE / MICROS_IN_A_MILLISECOND;
    public static final long SECONDS_IN_A_MINUTE = 60l;

    public static final long BLOCK_SIZE_IN_BYTES = 512l;

    public static final long BYTES_IN_KB = 1024l;
    public static final long BYTES_IN_MB = BYTES_IN_KB * 1024l;
    public static final long BYTES_IN_GB = BYTES_IN_MB * 1024l;
    public static final long BYTES_IN_TB = BYTES_IN_GB * 1024l;

    public static final String REPOSITORY_VOLUME_NAME_SUFFIX = " volume";
    public static final String VOLUME_NAME_LUN_PREFIX = "LUN: ";
    public static final String VOLUME_NAME_UID_PREFIX = "UID: ";
    public static final String CLARIION_AND_VNX_SPLITTER_TYPE = "Clariion/VNX";

    public static final String UNKNOWN_UVOL_NAME = "[UNKNOWN_PRODUCTION_VOLUME]";
    public static final String UNKNOWN_COPY_NAME = "UNKNOWN_COPY";

    public static final String EMPTY_STRING = "";
    public static final String NEWLINE = "\n";
    public static final String DOT = ".";
    public static final String COMMA = ",";
    public static final String OPEN_BR = "(";
    public static final String CLOSE_BR = ")";
    public static final String OPEN_SQUARE_BR = "[";
    public static final String CLOSE_SQUARE_BR = "]";

    public static final String SE_USER = "SE";

    public static final String VERSION_SP = ".SP";
    public static final String VERSION_PATCH = ".P";
    public static final String VERSION_HOT_FIX = ".HF";

    public static final int DEFAULT_TRANSACTION_OLD_AGE = 600;

    /* TWEAKS */
    public static final String TWEAK_REPOSITORY_NAME_PREFIX = "kashyaVolume";
    public static final String TWEAK_VISIBLE_VERSION = "t_extVersionVisibleString";
    public static final String TWEAK_SNAPSHOT_UPDATE_INTERVAL = "t_snapshotUpdateLongInterval";
    public static final String TWEAK_JOURNAL_SIZE_LIMIT = "t_journalSizeLimit";
    public static final String TWEAK_MIN_TSP_PERCENTAGE = "t_minTSPPercentage";
    public static final String TWEAK_MODEL_UPDATER_FREQUENCY = "t_modelUpdaterFrequency";
    public static final String TWEAK_EVENT_LOGS_MAX_ENTRIES = "t_ELGR_MaxNumberOfEntries";
    public static final String TWEAK_MAX_ACTIVITY_TIME = "t_mgmtMaxActivityTime";
    public static final String TWEAK_TSP_MEM_ALMOST_FULL_WATERMARK = "t_TSPMemoryAlmostFullWaterMark";
    public static final String TWEAK_MIN_UNCONSOLIDATED_DURATION = "t_minUnconsolidatedDuration";
    public static final String TWEAK_DEFAULT_UNCONSOLIDATED_DURATION = "t_defaultUnconsolidatedDuration";
    public static final String TWEAK_DEFAULT_DAILY_IMAGES = "t_defaultDailyImages";
    public static final String TWEAK_DEFAULT_WEEKLY_IMAGES = "t_defaultWeeklyImages";
    public static final String TWEAK_DEFAULT_MONTHLY_IMAGES = "t_defaultMonthlyImages";
    public static final String TWEAK_DAYS_PER_MONTH = "t_daysPerMonth";
    public static final String TWEAK_LOWEST_LATENCY_THRESHOLD = "t_lowestLatencyThreshold";
    public static final String TWEAK_HIGHEST_LATENCY_THRESHOLD = "t_highestLatencyThreshold";
    public static final String TWEAK_LOWEST_THROUGHPUT_THRESHOLD = "t_lowestThroughputThreshold";
    public static final String TWEAK_HIGHEST_THROUGHPUT_THRESHOLD = "t_highestThroughputThreshold";
    public static final String TWEAK_DEFAULT_START_ASYNC_ABOVE_LATENCY = "t_default_startAsyncAboveLatency";
    public static final String TWEAK_DEFAULT_RESUME_SYNC_BELOW_LATENCY = "t_default_resumeSyncBelowLatency";
    public static final String TWEAK_DEFAULT_START_ASYNC_ABOVE_THROUGHPUT = "t_default_startAsyncAboveThroughput";
    public static final String TWEAK_DEFAULT_RESUME_SYNC_BELOW_THROUGHPUT = "t_default_resumeSyncBelowThroughput";
    public static final String TWEAK_IS_SIMULATOR = "t_isSimulator";
    public static final String TWEAK_ENABLE_CLARIION_VIRTUAL_WITH_ROLL = "t_enableClariionVirtualWithRoll";
    public static final String TWEAK_DISPLAY_CERTIFICATE_EXTENSIONS = "t_displayCertificateExtensions";
    public static final String TWEAK_IS_REPLICATION_OVER_FC = "t_fcReplication";
    public static final String TWEAK_CLARIION_FIRST_SUFFIX = "t_clariionFirstSuffix";
    public static final String TWEAK_CLARIION_SECOND_SUFFIX = "t_clariionSecondSuffix";
    public static final String TWEAK_SINGLE_APPLIANCE_STRING = "t_singleAppliance";
    public static final String TWEAK_MULTIPLE_APPLIANCES_STRING = "t_multipleAppliances";
    public static final String TWEAK_IS_RPSE = "t_isRPSE";
    public static final String TWEAK_COMPANY_NAME = "company";
    public static final String TWEAK_RPSE_SET_GROUP_SETTINGS_TIME_FOR_SINGLE_OPERATION = "t_RPSESetGroupSettingsTimeForSingleOperation";
    public static final String TWEAK_MAX_GRID_COPIES_PER_GROUP = "t_maxGridCopiesPerGroup";
    public static final String TWEAK_E14_SERVER_NAME = "t_e14ServerName";
    public static final String TWEAK_CSC_NO_PATH_TXT = "t_CSC_no_path_text";
    public static final String TWEAK_FLEX_FILTER_RUN_INTERVAL = "t_flexFilterRunInterval";
    public static final String TWEAK_MAX_HOSTS_PER_SITE = "t_maxHostPerSite";
    public static final String TWEAK_SUPPORT_SYR = "t_supportSYR";
    public static final String TWEAK_PEER_STATE_UPDATE_INTERVAL = "t_SC_UpdatePeerStateRegulationTimeInterval";
    public static final String TWEAK_ROOT_CAUSES_STABILIZATION_TIME = "t_SC_RootCauseStabilizationTime";
    public static final String TWEAK_SNAPSHOT_CONSOLIDATION_TIME_ACCELERATION = "t_snapshotConsolidationTimeAcceleration";
    public static final String TWEAK_MAX_GRID_GROUPS = "t_maxGridGroups";
    public static final String TWEAK_MAX_GROUPS = "t_maxGroups";
    public static final String TWEAK_MONITOR_SPLITTER_STATE_LEASE = "t_HM_hostStateLease";
    public static final String TWEAK_CONTROL_WRITE_TIMEOUT = "t_lepWriteTimeOut";
    public static final String TWEAK_MAX_PERSISTENT_SNAPSHOTS = "t_MaxNumberOfPersistentSnapshots";
    public static final String TWEAK_TRACK_INIT_INCONSISTENCY = "t_trackInitInconsistency";
    public static final String TWEAK_USE_PWL_ON_WAN = "t_usePWLOnWAN";
    public static final String TWEAK_DYNAMIC_DONT_MOVE_TO_SYNC_TIME = "t_dynamicDontChangeToSyncTime";
    public static final String TWEAK_ADDITION_TO_SYNC_LATENCY = "t_additionToSyncLatency";
    public static final String TWEAK_PRODUCT = "product";
    public static final String TWEAK_SPLITTER_MONITOR_RPA_TIMEOUT = "t_HM_KboxCSCRimeout";
    public static final String TWEAK_PHOENIX_SYSTEM_TRADEMARK = "t_phoenixSystemTrademark";
    public static final String TWEAK_STATS_EXPORT_FILE = "t_statResultFile";
    public static final String TWEAK_MGMT_SCALED_MAX_ACTIVITY_TIME = "t_mgmtScaledEnvMaxActivityTime";
    public static final String TWEAK_MIN_NUM_OF_VOLUMES_IN_SCALED_ENV = "t_minNumOfVolumesInScaledEnv";
    public static final String TWEAK_LIMIT_MAINTENANCE_MODE_CHANGES = "t_limitMaintenanceModeChanges";
    public static final String TWEAK_MAX_NUMBER_OF_GROUP_SETS = "t_maxNumberOfGroupCollections";
    public static final String TWEAK_MAX_NUMBER_OF_CGS_IN_GROUP_SET = "t_maxNumberOfGroupsInConsistentGroupCollection";
    public static final String TWEAK_DEFAULT_SNAPSHOTS_SHIPPING_INTERVAL_IN_MINUTES = "t_defaultSnapshotShippingInterval";
    public static final String TWEAK_DEFAULT_TIME_RPO_IN_SECONDS = "t_defaultTimeRPOInSeconds";
    public static final String TWEAK_PLUGIN_VERSION = "t_pluginVersion";
    public static final String TWEAK_CHECK_LICENSE = "t_checkLicense";

    // XtremeIo
    public static final String TWEAK_MAX_SNAPSHOTS_ALLOWED = "t_maxSnapshotsAllowedByRP";
    public static final String TWEAK_MAX_DESIRED_SNAPSHOTS_DEFAULT_PERCENTAGE = "t_maxDesiredSnapshotsDefaultPercentage";

    // Policy Templates
    public static final String TWEAK_DEFAULT_CONSISTENCY_GROUP_COPY_POLICY_TEMPLATE_NAME = "t_defaultGroupCopyPolicyTemplateName";
    public static final String TWEAK_DEFAULT_CONSISTENCY_GROUP_LOCAL_LINK_POLICY_TEMPLATE_NAME = "t_defaultLocalLinkPolicyTemplateName";
    public static final String TWEAK_DEFAULT_CONSISTENCY_GROUP_REMOTE_LINK_POLICY_TEMPLATE_NAME = "t_defaultRemoteLinkPolicyTemplateName";

    /* DEFAULT TWEAKS VALUES */
    public static final String TWEAK_REPOSITORY_NAME_PREFIX_DEFAULT = "repository";
    public static final String TWEAK_CSC_NO_PATH_TXT_DEFAULT = "No path";
    public static final String TWEAK_STATS_EXPORT_FILE_DEFAULT = "stat";

    public static final int DEFAULT_CACHE_LOCKS_NUM = 50;
    public static final int DEFAULT_RPO_IN_SECONDS = 25;
    public static final int[] DEFAULT_CACHE_CAPACITY = new int[]{100, 100, 100};
    public static final boolean DEFAULT_PRINT_CACHE_STATISTICS = false;
    public static final boolean DEFAULT_PRINT_CONTEXTS = false;
    public static final boolean DEFAULT_USE_MGMT_OBJECTS_CACHE = true;
    public static final boolean DEFAULT_ALWAYS_ADD_TRAILING_ZEROS_TO_GUIDS = false;
    public static final boolean DEFAULT_SHOULD_FAIL_IF_RECOVERY_IMAGE_NOT_FOUND = true;

    // Policy Templates
    public static final String DEFAULT_TWEAK_DEFAULT_CONSISTENCY_GROUP_COPY_POLICY_TEMPLATE_NAME = "default copy";
    public static final String DEFAULT_TWEAK_DEFAULT_CONSISTENCY_GROUP_LOCAL_LINK_POLICY_TEMPLATE_NAME = "default local link";
    public static final String DEFAULT_TWEAK_DEFAULT_CONSISTENCY_GROUP_REMOTE_LINK_POLICY_TEMPLATE_NAME = "default remote link";

    public static final String RPELICA_NAME_POSTFIX = ".copy";
    public static final String DEFAULT_COPY_NAME_PREFIX = "copy_";
    public static final int DEFAULT_PRODUCTION_NAME_INDEX = 1;
    public static final int DEFAULT_COPY_NAME_INITIAL_INDEX = 2;

}
