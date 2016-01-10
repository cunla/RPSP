package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum MonitoredParameterType {
    NUMBER_OF_GROUPS("NumberOfGroups"),
    NUMBER_OF_TRANSFERRING_GROUPS("NumberOfTransferringGroups"),
    NUMBER_OF_REPLICATING_SETS("NumberOfReplicatingSets"),
    NUMBER_OF_SPLITTING_HOSTS("NumberOfSplittingHosts"),
    NUMBER_OF_CLARIION_HOSTS("NumberOfClariionHosts"),
    DAYS_LICENSE_LEFT("DaysLicenseLeft"),
    LOCAL_REPLICATED_ARRAY("LocalReplicatedArray"),
    REMOTE_REPLICATED_ARRAY("RemoteReplicatedArray"),
    LOCAL_REPLICATED_CLUSTER("LocalReplicatedCluster"),
    REMOTE_REPLICATED_CLUSTER("RemoteReplicatedCluster"),
    NUMBER_OF_GRID_GROUPS("NumberOfGridGroups"),
    LAG_TRANSACTION("LagTransaction"),
    LAG_TIME("LagTime"),
    LAG_DATA("LagData"),
    PAUSE_JOURNAL_TSP_USAGE("PauseJournalTSPUsage"),
    PAUSE_VIRTUAL_MEMORY_USAGE("PauseVirtualMemoryUsage"),
    NUMBER_OF_SPLITTER_CLUSTERS("NumberOfSplitterClusters"),
    TOTAL_NUMBER_OF_SPLITTER_LUNS("TotalNumberOfSplitterLUNs"),
    SYMMETRIX_PROTECTED_VOLUMES("SymmetrixProtectedVolumes"),
    NUMBER_OF_VPLEX_HOSTS("NumberOfVplexHosts"),
    NUMBER_OF_VPLEX_DIRECTORS("NumberOfVplexDirectors"),
    NUMBER_OF_SYMMETRIX_HOSTS("NumberOfSymmetrixHosts"),
    SYMMETRIX_SESSIONS("SymmetrixSessions"),
    NUMBER_OF_WLPS("NumberOfWLPS"),
    NUMBER_OF_GUIDS("NumberOfGUIDS"),
    NUMBER_OF_ESX_CLUSTERS("NumberOfESXClusters"),
    MAX_NUMBER_OF_CX_ARRAYS("MaxNumberOfCXArrays"),
    MAX_NUMBER_OF_VNX_ARRAYS("MaxNumberOfVNXArrays"),
    MAX_NUMBER_OF_VC_ARRAYS("MaxNumberOfVCArrays"),
    MAX_NUMBER_OF_VPLEX_ARRAYS("MaxNumberOfVPLEXArrays"),
    MAX_NUMBER_OF_XTREME_ARRAYS("MaxNumberOfXtremeIoArrays"),
    MAX_NUMBER_OF_SCALE_IO_ARRAYS("MaxNumberOfScaleIoArrays"),
    MAX_NUMBER_OF_SNAPSHOTS("MaxNumberOfSnapshots"),
    MAX_NUMBER_OF_SNAPSHOT_MOUNT_POINTS("MaxNumberOfSnapshotMountPoints"),
    MAX_NUMBER_OF_SNAPSHOTS_PER_DEVICE("MaxNumberOfSnapshotsPerDevice"),
    MAX_NUMBER_OF_DEVICES("MaxNumberOfDevices"),
    MAX_NUMBER_OF_DEVICES_PER_RESOURCE_POOL("MaxNumberOfDevicesPerResourcePool"),
    MAX_NUMBER_OF_DEVICES_PER_MASKING_GROUP("MaxNumberOfDevicesPerMaskingGroup"),
    MAX_NUMBER_OF_MEMBERS_PER_ARRAY_CGS("MaxNumberOfMembersPerArrayCGs"),
    MAX_NUMBER_OF_ARRAY_CGS("MaxNumberOfArrayCGs"),
    MAX_NUMBER_OF_BRICKS("MaxNumberOfBricks"),
    MAX_DEVICE_SIZE_GB("MaxDeviceSizeGB"),
    NUMBER_OF_EXTERNAL_AMPS_PER_CLUSER("NumberOfExternalAmpsPerCluser"),
    NUMBER_OF_SYMM_V3_HOSTS("NumberOfSymmV3Hosts"),
    NUMBER_OF_VIRTUAL_JOURNALS("NumberOfVirtualJournals"),
    NUMBER_OF_ESX_HOSTS_WITH_SPLITTER("NumberOfEsxHostsWithSplitter"),
    NUMBER_OF_PROTECTED_VMS("NumberOfProtectedVms"),
    NUMBER_OF_PROTECTED_VMDKS("NumberOfProtectedVmdks"),
    NUMBER_OF_SITES("NumberOfSites"),
    NUMBER_OF_VMS_PER_GROUP("NumberOfVmsPerGroup"),
    NUMBER_OF_REPLICA_COPIES_PER_GROUP("NumberOfReplicaCopiesPerGroup"),
    NUMBER_OF_SITES_CONNECTED_TO_VC("NumberOfSitesConnectedToVc"),
    NUMBER_OF_VMS_PROTECTED_PER_VC("NumberOfVmsProtectedPerVc"),
    UNKNOWN("Unknown");


    private String name;

    public String toString() {
        return name;
    }

}
