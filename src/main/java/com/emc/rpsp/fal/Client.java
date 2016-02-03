package com.emc.rpsp.fal;

import com.emc.rpsp.RpspException;
import com.emc.rpsp.StatesConsts;
import com.emc.rpsp.fal.commons.*;
import com.emc.rpsp.fal.wrappers.*;
import com.emc.rpsp.packages.domain.PackageConfig;
import com.emc.rpsp.rpsystems.SystemConnectionInfoRepository;
import com.emc.rpsp.rpsystems.SystemSettings;
import com.emc.rpsp.vmstructure.domain.CopySnapshot;
import retrofit.RetrofitError;
import retrofit.client.Response;

import java.io.EOFException;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by morand3 on 1/14/2015.
 */
public class Client {
    private SystemConnectionInfoRepository systemsRepo = null;
    private SystemSettings systemSettings;
    private ClusterConnector connector;

    public Client(SystemSettings settings) {
        this.systemSettings = settings;
        connector = ClusterConnectorFactory.getConnector(settings);
    }

    public Client(SystemSettings systemSettings,
                  SystemConnectionInfoRepository systemConnectionInfoRepository) {
        this(systemSettings);
        this.systemsRepo = systemConnectionInfoRepository;
    }

    public SystemSettings getSystemSettings() {
        return systemSettings;
    }

    public long getSystemTime() {
        try {
            long res = connector.getSystemTime().getTimeInMicroSeconds() / 1000;
            String version = connector.getSystemVersion().getVersion();
            if (null != systemsRepo) {
                systemSettings.setSystemVersion(version);
                systemSettings.setTestResult(true);
                systemsRepo.saveAndFlush(systemSettings);
            }
            return res;
        } catch (RetrofitError e) {
            if (null != systemsRepo) {
                systemSettings.setTestResult(false);
                systemsRepo.saveAndFlush(systemSettings);
            }
            throw new RpspException("Couldn't access host "
                + systemSettings.getSystemIp());
        }
    }
    
    
    public long getSystemTimeStateless() {
        try {
            long res = connector.getSystemTime().getTimeInMicroSeconds() / 1000;
            return res;
        } catch (RetrofitError e) {
            throw new RpspException("Couldn't access host "
                + systemSettings.getSystemIp());
        }
    }

    /**
     * @return Map of vmId => vmName in the cluster
     */
    public Map<String, String> getVmNamesInCluster(long clusterId) {
        ClusterVirtualInfrastructuresState state = connector
            .getVirtualInfrastructuresStateFromCluster(clusterId);
        Collection<VmState> vmStateList = state.getVirtualInfrastructuresState()
            .getVmsState();
        Map<String, String> res = new HashMap<>();
        for (VmState vmState : vmStateList) {
            String vmId = vmState.getVmUID().getUuid();
            String vmName = vmState.getName();
            res.put(vmId, vmName);
        }
        return res;
    }

    /**
     * Provides a list of VMs per cluster
     *
     * @return Map of clusterId => (Map of vmId => vmName)
     */
    public Map<Long, Map<String, String>> getVmNamesAllClusters() {
        ClusterVirtualInfrastructuresStateSet stateSet = connector
            .getVirtualInfrastructuresStateFromAllCluster();
        return getVmNames(stateSet);
    }

    /**
     * @return Map of clusterId => clusterName
     */
    public Map<Long, String> getClusterNames() {
        RecoverPointClustersInformation rpClusters = connector
            .getRpClustersInformation();
        systemSettings.setTestResult(true);
        return getClusterNames(rpClusters);
    }

    public Map<Long, String> getGroupNames() {
        ConsistencyGroupSettingsSet consistencyGroupSettingsSet = connector
            .getAllGroupsSettings();
        Map<Long, String> groupIdToNameMap = new HashMap<Long, String>();
        for (ConsistencyGroupSettings consistencyGroupSettings : consistencyGroupSettingsSet
            .getInnerSet()) {
            groupIdToNameMap.put(
                consistencyGroupSettings.getGroupUID().getId(),
                consistencyGroupSettings.getName());
        }
        return groupIdToNameMap;
    }

    public Map<Long, String> getGroupSetNames() {
        ConsistencyGroupSetSettingsSet consistencyGroupSetSettingsSet = connector
            .getAllGroupSetsSettings();
        Map<Long, String> groupSetIdToNameMap = new HashMap<Long, String>();
        for (ConsistencyGroupSetSettings consistencyGroupSetSettings : consistencyGroupSetSettingsSet
            .getInnerSet()) {
            groupSetIdToNameMap.put(consistencyGroupSetSettings.getSetUID()
                .getId(), consistencyGroupSetSettings.getName());
        }
        return groupSetIdToNameMap;
    }

    private Map<Long, String> getClusterNames(
        RecoverPointClustersInformation rpClusters) {
        Map<Long, String> res = new HashMap<>();
        for (ClusterInfo clusterInfo : rpClusters.getClustersInformation()) {
            res.put(clusterInfo.getClusterUID().getId(),
                clusterInfo.getClusterName());
        }
        return res;
    }

    private Map<Long, Map<String, String>> getVmNames(
        ClusterVirtualInfrastructuresStateSet stateSet) {
        Map<Long, Map<String, String>> res = new HashMap<>();
        for (ClusterVirtualInfrastructuresState state : stateSet.getInnerSet()) {
            Collection<VmState> vmStateList = state.getVirtualInfrastructuresState()
                .getVmsState();
            long clusterId = state.getClusterUID().getId();
            Map<String, String> vms = res.get(clusterId);
            if (null == vms) {
                vms = new HashMap<>();
                res.put(clusterId, vms);
            }
            for (VmState vmState : vmStateList) {
                String vmId = vmState.getVmUID().getUuid();
                String vmName = vmState.getName();
                vms.put(vmId, vmName);
            }
        }
        return res;
    }

    public FullRecoverPointSettings getFullRecoverPointSettings() {
        FullRecoverPointSettings rpSettings = connector.getFullRecoverPointSettings();
        return rpSettings;
    }

    public Map<String, String> getVmState() {
        FullRecoverPointSettings rpSettings = connector.getFullRecoverPointSettings();
        return getVmState(rpSettings);
    }

    public void enableLatestImageAccess(Long clusterId, Long groupId,
                                        Integer copyId) {
        EnableLatestImageAccessParams params = new EnableLatestImageAccessParams();
        params.setScenario(ImageAccessScenario.TEST_REPLICA);
        params.setMode(ImageAccessMode.LOGGED_ACCESS);
        try {
            connector.enableLatestImageAccess(clusterId, groupId, copyId,
                params);
        } catch (Throwable e) {
            if (!isEOFCause(e)) {
                throw e;
            }
        }
    }

    public void disableImageAccess(Long clusterId, Long groupId, Integer copyId) {
        try {
            connector.disableLatestImageAccess(clusterId, groupId, copyId);
        } catch (Throwable e) {
            if (!isEOFCause(e)) {
                throw e;
            }
        }
    }

    public ConsistencyGroupStateSet getConsistencyGroupStateSet() {
        ConsistencyGroupStateSet consistencyGroupStateSet = connector
            .getConsistencyGroupStateSet();
        return consistencyGroupStateSet;
    }

    public ConsistencyGroupVolumesStateSet getConsistencyGroupVolumesStateSet() {
        ConsistencyGroupVolumesStateSet consistencyGroupVolumesStateSet = connector
            .getConsistencyGroupVolumesStateSet();
        return consistencyGroupVolumesStateSet;
    }

    public ConsistencyGroupSnapshots getGroupSnapshots(Long groupId) {

		/*
         * long dayInMicroseconds = 1000 * 1000 * 60 * 60 * 24; long currTime =
		 * connector.getSystemTime().getTimeInMicroSeconds() -
		 * dayInMicroseconds; Long startTime = new Long(currTime -
		 * dayInMicroseconds); Long endTime = new Long(currTime);
		 */

        Long startTime = null;
        Long endTime = null;
        ConsistencyGroupSnapshots consistencyGroupSnapshots = connector
            .getGroupSnapshots(groupId, startTime, endTime);
        return consistencyGroupSnapshots;
    }

    public void enableSnapshotImageAccess(Long clusterId, Long groupId,
                                          int copyId, CopySnapshot copySnapshot) {
        EnableImageAccessParams enableImageAccessParams = new EnableImageAccessParams();
        enableImageAccessParams.setScenario(ImageAccessScenario.TEST_REPLICA);
        enableImageAccessParams.setMode(ImageAccessMode.LOGGED_ACCESS);
        Snapshot snapshot = new Snapshot();
        snapshot.setSnapshotUID(new SnapshotUID(copySnapshot.getId()));
        snapshot.setClosingTimeStamp(new RecoverPointTimeStamp(copySnapshot
            .getOriginalClosingTimeStamp()));
        snapshot.setDescription("");
        enableImageAccessParams.setSnapshot(snapshot);
        try {
            connector.enableSnapshotImageAccess(clusterId, groupId, copyId,
                enableImageAccessParams);
        } catch (Throwable e) {
            if (!isEOFCause(e)) {
                throw e;
            }
        }

    }

    @SuppressWarnings("unused")
    public void addVmToCG(String vmId, Long groupId,
                          List<PackageConfig> accountConfig) {

        ConsistencyGroupCopySettingsSet consistencyGroupCopySettingsSet = connector
            .getAllGroupCopies(groupId);
        Collection<ConsistencyGroupCopySettings> consistencyGroupCopySettingsList =
            consistencyGroupCopySettingsSet.getInnerSet();
        Long productionClusterId = 0L;
        int productionCopyId = 0;
        for (ConsistencyGroupCopySettings currConsistencyGroupCopySettings : consistencyGroupCopySettingsList) {
            if (currConsistencyGroupCopySettings.getRoleInfo()
                .getSourceCopyUID() == null) {
                productionClusterId = currConsistencyGroupCopySettings
                    .getCopyUID().getGlobalCopyUID().getClusterUID()
                    .getId();
                productionCopyId = currConsistencyGroupCopySettings
                    .getCopyUID().getGlobalCopyUID().getCopyUID();
            }
        }

        List<ReplicatedVMParams> replicatedVmParams = new LinkedList<ReplicatedVMParams>();
        Map<Long, PackageConfig> accountConfigsMap = getAccountConfigsMap(accountConfig);

        for (ConsistencyGroupCopySettings currConsistencyGroupCopySettings : consistencyGroupCopySettingsList) {
            if (currConsistencyGroupCopySettings.getRoleInfo()
                .getSourceCopyUID() != null) {

                // add source parameter
                ReplicatedVMParams sourceReplicatedVMParam = new ReplicatedVMParams();

                SourceVmParam sourceVmParam = new SourceVmParam();
                VmUID vmUID = new VmUID();
                vmUID.setUuid(vmId);
                String prodVcId = accountConfigsMap.get(productionClusterId)
                    .getVcId();
                VirtualCenterUID virtualCenterUID = new VirtualCenterUID(
                    prodVcId);
                vmUID.setVirtualCenterUID(virtualCenterUID);
                sourceVmParam.setVmUID(vmUID);
                sourceVmParam
                    .setClusterUID(new ClusterUID(productionClusterId));

                GlobalCopyUID globalCopyUID = new GlobalCopyUID(new ClusterUID(
                    productionClusterId), productionCopyId);

                sourceReplicatedVMParam.setVmParam(sourceVmParam);
                sourceReplicatedVMParam.setCopyUID(globalCopyUID);

                replicatedVmParams.add(sourceReplicatedVMParam);

                // add target parameter
                ReplicatedVMParams targetReplicatedVMParam = new ReplicatedVMParams();
                CreateVMParam createVMParam = new CreateVMParam();
                GlobalCopyUID targetGlobalCopyUID = currConsistencyGroupCopySettings
                    .getCopyUID().getGlobalCopyUID();
                String replicaVcId = accountConfigsMap.get(
                    targetGlobalCopyUID.getClusterUID().getId()).getVcId();
                String replicaDataStoreId = accountConfigsMap.get(
                    targetGlobalCopyUID.getClusterUID().getId())
                    .getDatastoreId();
                String replicaEsxId = accountConfigsMap.get(
                    targetGlobalCopyUID.getClusterUID().getId()).getEsxId();
                createVMParam.setTargetVirtualCenterUID(new VirtualCenterUID(replicaVcId));
                createVMParam.setTargetDatastoreUID(new DatastoreUID(replicaDataStoreId));
                createVMParam
                    .setTargetResourcePlacementParam(new CreateTargetVMManualResourcePlacementParam(
                        new EsxUID(replicaEsxId)));

                targetReplicatedVMParam.setVmParam(createVMParam);
                targetReplicatedVMParam.setCopyUID(targetGlobalCopyUID);

                replicatedVmParams.add(targetReplicatedVMParam);
            }
        }

        VirtualHardwareReplicationPolicy virtualHardwareReplicationPolicy = new VirtualHardwareReplicationPolicy();
        virtualHardwareReplicationPolicy
            .setProvisionPolicy(DiskProvisionPolicy.SAME_AS_SOURCE);
        virtualHardwareReplicationPolicy
            .setHwChangesPolicy(HardwareChangesPolicy.REPLICATE_HW_CHANGES);

        VirtualDisksReplicationPolicy virtualDisksReplicationPolicy = new VirtualDisksReplicationPolicy();
        virtualDisksReplicationPolicy.setAutoReplicateNewVirtualDisks(true);

        VMReplicationSetParam replicationSetParam = new VMReplicationSetParam(
            replicatedVmParams, virtualHardwareReplicationPolicy,
            virtualDisksReplicationPolicy);

        List<VMReplicationSetParam> innerSet = new LinkedList<VMReplicationSetParam>();
        innerSet.add(replicationSetParam);
        VmReplicationSetParamSet vmReplicationSetParamSet = new VmReplicationSetParamSet(innerSet);

        Response response = connector.addVmToCG(groupId,
            vmReplicationSetParamSet);
    }

    @SuppressWarnings("static-access")
    public void changeVmsPowerUpSequence(String vmId, Long groupId,
                                         boolean isCritical, int sequenceNumber) {
        VmReplicationSetSettings vmReplicationSetSettings = getVmReplicationSettingsWithRetryOption(
            vmId, 3);
        if (vmReplicationSetSettings != null) {
            VmPowerUpSequenceParamSet vmPowerUpSequenceParamSet = new VmPowerUpSequenceParamSet();
            VmPowerUpSequenceParam vmPowerUpSequenceParam = new VmPowerUpSequenceParam();
            vmPowerUpSequenceParam
                .setVmReplicationSetUID(vmReplicationSetSettings
                    .getVmReplicationSetUID());
            vmPowerUpSequenceParam.setIsCritical(isCritical);
            vmPowerUpSequenceParam.setPowerUpSequenceNumber(sequenceNumber);
            vmPowerUpSequenceParamSet.getInnerSet().add(vmPowerUpSequenceParam);
            connector.changeVmsPowerUpSequence(groupId,
                vmPowerUpSequenceParamSet);
        }
    }

    public void removeVmsFromCG(String vmId, Long groupId,
                                List<PackageConfig> accountConfig) {

        ConsistencyGroupCopySettingsSet consistencyGroupCopySettingsSet = connector
            .getAllGroupCopies(groupId);
        Collection<ConsistencyGroupCopySettings> consistencyGroupCopySettingsList = consistencyGroupCopySettingsSet
            .getInnerSet();
        Long productionClusterId = 0L;
        for (ConsistencyGroupCopySettings currConsistencyGroupCopySettings : consistencyGroupCopySettingsList) {
            if (currConsistencyGroupCopySettings.getRoleInfo()
                .getSourceCopyUID() == null) {
                productionClusterId = currConsistencyGroupCopySettings
                    .getCopyUID().getGlobalCopyUID().getClusterUID()
                    .getId();
            }
        }
        PackageConfig packageConfig = getAccountConfigsMap(accountConfig).get(
            productionClusterId);
        if (null == packageConfig) {
            throw new RpspException("No package defined");
        }
        String productionVcId = packageConfig.getVcId();
        VirtualCenterUID productionVirtualCenterUID = new VirtualCenterUID(
            productionVcId);
        VmUID vmUID = new VmUID(vmId, productionVirtualCenterUID);
        List<VmUID> innerSet = new LinkedList<VmUID>();
        innerSet.add(vmUID);
        VmUIDSet vmUIDSet = new VmUIDSet(innerSet);
        connector.removeVmsFromCG(groupId, vmUIDSet);
    }


    @SuppressWarnings("static-access")
    public boolean verifyCopyImageAccessActivation(Long clusterId, Long groupId, Integer copyId, int retryAttempts) {
        boolean res = false;
        for (int i = 0; i < retryAttempts; i++) {
            try {
                Thread.currentThread().sleep(TimeUnit.SECONDS.toMillis(GeneralFalConsts.IMAGE_ACCESS_STATUS_WAIT_TIME_PERIOD_SEC));
            } catch (InterruptedException e) {
            }
            res = isCopyImageAccessEnabled(clusterId, groupId, copyId);
            if (res == true) {
                break;
            }

        }
        return res;
    }

    private boolean isCopyImageAccessEnabled(Long clusterId, Long groupId,
                                             Integer copyId) {

        ConsistencyGroupCopySettingsSet consistencyGroupCopySettingsSet = connector
            .getAllGroupCopies(groupId);

        boolean res = false;
        Collection<ConsistencyGroupCopySettings> allCopiesSettings = consistencyGroupCopySettingsSet
            .getInnerSet();

        ConsistencyGroupCopyUID targetGroupCopyUID = new ConsistencyGroupCopyUID(
            new ConsistencyGroupUID(groupId), new GlobalCopyUID(
            new ClusterUID(clusterId), copyId));
        for (ConsistencyGroupCopySettings currGroupCopySettings : allCopiesSettings) {
            if (currGroupCopySettings.getCopyUID().equals(targetGroupCopyUID)) {
                if (currGroupCopySettings.getImageAccessInformation() != null
                    && currGroupCopySettings.getImageAccessInformation().isImageAccessEnabled()
                    && currGroupCopySettings.getImageAccessInformation()
                    .getImageInformation().getMode()
                    .equals(ImageAccessMode.LOGGED_ACCESS)) {

                    res = true;
                }
            }
        }

        return res;
    }

    @SuppressWarnings("unused")
    public void createGroupBookmark(Long groupId, String bookmarkName,
                                    String consistencyType) {
        CreateBookmarkParams createBookmarkParams = new CreateBookmarkParams();
        createBookmarkParams.getGroups().add(new ConsistencyGroupUID(groupId));
        createBookmarkParams.setBookmarkName(bookmarkName);
        createBookmarkParams
            .setConsistencyType(SnapshotConsistencyType.APPLICATION_CONSISTENT);
        /*
         * if(consistencyType.equals(GeneralFalConsts.APPLICATION_CONSISTENCY_TYPE
		 * )){ createBookmarkParams.setConsistencyType(SnapshotConsistencyType.
		 * APPLICATION_CONSISTENT); } else{
		 * createBookmarkParams.setConsistencyType
		 * (SnapshotConsistencyType.UNKNOWN); }
		 */
        createBookmarkParams
            .setConsolidationPolicy(BookmarkConsolidationPolicy.NEVER_CONSOLIDATE);
        Response response = connector.createGroupBookmark(createBookmarkParams);
    }

    @SuppressWarnings("unused")
    public void createGroupSetBookmark(Long groupSetId, String bookmarkName,
                                       String consistencyType) {
        CreateBookmarkForGroupSetSubSetParams createBookmarkForGroupSetSubSetParams = new CreateBookmarkForGroupSetSubSetParams();
        ConsistencyGroupSetSubset consistencyGroupSetSubset = new ConsistencyGroupSetSubset();
        consistencyGroupSetSubset.setGroupSetUID(new ConsistencyGroupSetUID(
            groupSetId));
        createBookmarkForGroupSetSubSetParams
            .setGroupSetSubset(consistencyGroupSetSubset);
        createBookmarkForGroupSetSubSetParams.getGroupSetSubset()
            .setGroupSetUID(new ConsistencyGroupSetUID(groupSetId));
        createBookmarkForGroupSetSubSetParams.setBookmarkName(bookmarkName);
        createBookmarkForGroupSetSubSetParams
            .setConsistencyType(SnapshotConsistencyType.APPLICATION_CONSISTENT);
		/*
		 * if(consistencyType.equals(GeneralFalConsts.APPLICATION_CONSISTENCY_TYPE
		 * )){ createBookmarkForGroupSetSubSetParams.setConsistencyType(
		 * SnapshotConsistencyType.APPLICATION_CONSISTENT); } else{
		 * createBookmarkForGroupSetSubSetParams
		 * .setConsistencyType(SnapshotConsistencyType.UNKNOWN); }
		 */
        createBookmarkForGroupSetSubSetParams
            .setConsolidationPolicy(BookmarkConsolidationPolicy.NEVER_CONSOLIDATE);
        Response response = connector
            .createGroupSetBookmark(createBookmarkForGroupSetSubSetParams);

    }

    public ConsistencyGroupStatisticsSet getGroupStatistics() {
        ConsistencyGroupStatisticsSet consistencyGroupStatisticsSet = connector
            .getGroupStatistics();
        return consistencyGroupStatisticsSet;
    }

    public void failOver(Long clusterId, Long groupId, int copyId) {

        ConsistencyGroupCopySettingsSet consistencyGroupCopySettingsSet = connector
            .getAllGroupCopies(groupId);
        ConsistencyGroupLinkPolicy localDefaultLinkPolicy = connector
            .getDefaultLocalGroupLinkPolicy();
        ConsistencyGroupLinkPolicy remoteDefaultLinkPolicy = connector
            .getDefaultRemoteGroupLinkPolicy();
        GlobalCopyUID globalCopyUIDParam = new GlobalCopyUID(new ClusterUID(clusterId), copyId);

        Collection<ConsistencyGroupCopySettings> consistencyGroupCopySettingsList = consistencyGroupCopySettingsSet
            .getInnerSet();
        ConsistencyGroupTopologyParams consistencyGroupTopologyParams = new ConsistencyGroupTopologyParams();
        for (ConsistencyGroupCopySettings currConsistencyGroupCopySettings : consistencyGroupCopySettingsList) {
            GlobalCopyUID currGlobalCopy = currConsistencyGroupCopySettings
                .getCopyUID().getGlobalCopyUID();
            // it is not the the failover target copy
            if (!currGlobalCopy.equals(globalCopyUIDParam)
                // it is not the current(!) production copy for which the link is
                // created automatically
                && currConsistencyGroupCopySettings.getRoleInfo()
                .getSourceCopyUID() != null) {
                ConsistencyGroupLinkSettings consistencyGroupLinkSettings = new ConsistencyGroupLinkSettings();
                ConsistencyGroupLinkUID consistencyGroupLinkUID = new ConsistencyGroupLinkUID();
                consistencyGroupLinkUID.setGroupUID(new ConsistencyGroupUID(
                    groupId));
                consistencyGroupLinkUID.setFirstCopy(globalCopyUIDParam);
                consistencyGroupLinkUID.setSecondCopy(currGlobalCopy);
                consistencyGroupLinkSettings
                    .setGroupLinkUID(consistencyGroupLinkUID);
                // local link for new production
                if (currGlobalCopy.getClusterUID().equals(
                    globalCopyUIDParam.getClusterUID())) {
                    consistencyGroupLinkSettings
                        .setLinkPolicy(localDefaultLinkPolicy);
                } else {
                    consistencyGroupLinkSettings
                        .setLinkPolicy(remoteDefaultLinkPolicy);
                }
                consistencyGroupTopologyParams.getLinksToAdd().add(
                    consistencyGroupLinkSettings);
            }
        }

        if (consistencyGroupTopologyParams.getLinksToAdd() != null
            && !consistencyGroupTopologyParams.getLinksToAdd().isEmpty()) {
            connector.failOver(clusterId, groupId, copyId, false);
            connector.setConsistencyGroupTopology(clusterId, groupId, copyId,
                consistencyGroupTopologyParams);
        } else {
            connector.failOver(clusterId, groupId, copyId, true);
        }

    }

    public void recoverProduction(Long clusterId, Long groupId, int copyId) {
        connector.recoverProduction(clusterId, groupId, copyId, true);
    }

    public ClusterVirtualInfraConfiguration getClusterVirtualInfraConfiguration(
        Long clusterId) {
        ClusterVirtualInfraConfiguration clusterVirtualInfraConfiguration = connector
            .getClusterVirtualInfraConfiguration(clusterId);
        return clusterVirtualInfraConfiguration;
    }

    public VmEntitiesInformationSet getAvailableVMsForReplication(
        Long clusterId, String vcUID, String dcUID, String esxClusterUID) {
        VmEntitiesInformationSet vmEntitiesInformationSet = connector
            .getAvailableVMsForReplication(clusterId, vcUID, dcUID,
                esxClusterUID);
        return vmEntitiesInformationSet;
    }

    @SuppressWarnings("unused")
    public void enableImageAccessForGroupSetSubset(Long clusterId,
                                                   Long groupSetId, CopySnapshot copySnapshot) {
        EnableImageAccessForGroupSetsSubsetParams params = new EnableImageAccessForGroupSetsSubsetParams();

        ConsistencyGroupSetSubset groupSetSubset = new ConsistencyGroupSetSubset();
        groupSetSubset.setGroupSetUID(new ConsistencyGroupSetUID(groupSetId));
        params.setGroupSetSubset(groupSetSubset);

        params.setScenario(ImageAccessScenario.TEST_REPLICA);

        ImageAccessParameters imageAccessParams = new ImageAccessParameters();
        imageAccessParams.setMode(ImageAccessMode.LOGGED_ACCESS);
        imageAccessParams.setTimeStamp(new RecoverPointTimeStamp(copySnapshot
            .getOriginalClosingTimeStamp()));
        params.setParams(imageAccessParams);

        Response response = connector.enableImageAccessForGroupSetSubset(
            clusterId, params);
    }

    @SuppressWarnings("unused")
    public void disableImageAccessForGroupSetSubset(Long clusterId,
                                                    Long groupSetId) {

        ConsistencyGroupSetSubset groupSetSubset = new ConsistencyGroupSetSubset();
        groupSetSubset.setGroupSetUID(new ConsistencyGroupSetUID(groupSetId));
        Response response = connector.disableImageAccessForGroupSetSubset(
            clusterId, groupSetSubset, true);
    }

	/*
	 * @SuppressWarnings("unused") public void failoverGroupSetSubset(Long
	 * clusterId, Long groupSetId){
	 *
	 * ConsistencyGroupSetSubset groupSetSubset = new
	 * ConsistencyGroupSetSubset(); groupSetSubset.setGroupSetUID(new
	 * ConsistencyGroupSetUID(groupSetId)); Response response =
	 * connector.failoverGroupSetSubset(clusterId, groupSetSubset, true); }
	 */

    @SuppressWarnings("unused")
    public void failoverGroupSetSubset(Long clusterId, Long groupSetId) {
        ConsistencyGroupSetSettings consistencyGroupSetSettings = connector
            .getGroupSetSettings(groupSetId);
        Collection<ConsistencyGroupUID> groupsUIDs = consistencyGroupSetSettings.getGroupsUIDs();
        for (ConsistencyGroupUID consistencyGroupUID : groupsUIDs) {
            failOver(clusterId, consistencyGroupUID.getId(), 0);
        }
    }

	/*
	 * @SuppressWarnings("unused") public void
	 * recoverProductionForGroupSetSubset(Long clusterId, Long groupSetId){
	 *
	 * ConsistencyGroupSetSubset groupSetSubset = new
	 * ConsistencyGroupSetSubset(); groupSetSubset.setGroupSetUID(new
	 * ConsistencyGroupSetUID(groupSetId)); Response response =
	 * connector.recoverProductionForGroupSetSubset(clusterId, groupSetSubset,
	 * true); }
	 */

    public void recoverProductionForGroupSetSubset(Long clusterId,
                                                   Long groupSetId) {
        ConsistencyGroupSetSettings consistencyGroupSetSettings = connector
            .getGroupSetSettings(groupSetId);
        Collection<ConsistencyGroupUID> groupsUIDs = consistencyGroupSetSettings
            .getGroupsUIDs();
        for (ConsistencyGroupUID consistencyGroupUID : groupsUIDs) {
            recoverProduction(clusterId, consistencyGroupUID.getId(), 0);
        }
    }

    public long createConsistencyGroup(String cgName, List<String> vmIds,
                                       List<PackageConfig> accountConfigList, int rpo,
                                       boolean startReplication) {
        Map<Long, PackageConfig> accountConfigsMap = getAccountConfigsMap(accountConfigList);
        ReplicateVmsParam replicateVmsParam = new ReplicateVmsParam();

        // CG name
        replicateVmsParam.setCgName(cgName);
        replicateVmsParam.setStartTransfer(startReplication);

        // production copy ID
        PackageConfig productionConfig = null;
        // List<AccountConfig> replicasConfig = new LinkedList<AccountConfig>();
        for (PackageConfig accountConfig : accountConfigList) {
            if (accountConfig.getIsProductionCluster()) {
                productionConfig = accountConfig;
            }
        }

        GlobalCopyUID productionCopy = new GlobalCopyUID();
        productionCopy.setCopyUID(0);
        Long productionClusterId = productionConfig.getClusterId();
        productionCopy.setClusterUID(new ClusterUID(productionClusterId));
        replicateVmsParam.setProductionCopy(productionCopy);

        // replication sets
        Collection<VMReplicationSetParam> vmReplicationSets = replicateVmsParam
            .getVmReplicationSets();

        for (String vmId : vmIds) {
            List<ReplicatedVMParams> replicatedVmParams = new LinkedList<ReplicatedVMParams>();

            // create source vm parameter
            ReplicatedVMParams sourceReplicatedVMParam = new ReplicatedVMParams();

            SourceVmParam sourceVmParam = new SourceVmParam();
            VmUID vmUID = new VmUID();
            vmUID.setUuid(vmId);
            String prodVcId = accountConfigsMap.get(productionClusterId)
                .getVcId();
            VirtualCenterUID virtualCenterUID = new VirtualCenterUID(prodVcId);
            vmUID.setVirtualCenterUID(virtualCenterUID);
            sourceVmParam.setVmUID(vmUID);
            sourceVmParam.setClusterUID(new ClusterUID(productionClusterId));

            sourceReplicatedVMParam.setVmParam(sourceVmParam);
            sourceReplicatedVMParam.setCopyUID(productionCopy);

            // replicatedVmParams.add(sourceReplicatedVMParam);

            // add source and targets
            for (PackageConfig accountConfig : accountConfigList) {
                if (!accountConfig.getIsProductionCluster()) {
                    // add source vm parameter
                    replicatedVmParams.add(sourceReplicatedVMParam);
                    // add target vm parameter
                    ReplicatedVMParams targetReplicatedVMParam = new ReplicatedVMParams();
                    CreateVMParam createVMParam = new CreateVMParam();
                    GlobalCopyUID targetGlobalCopyUID = new GlobalCopyUID(
                        new ClusterUID(accountConfig.getClusterId()), 0);
                    String replicaVcId = accountConfigsMap.get(
                        targetGlobalCopyUID.getClusterUID().getId())
                        .getVcId();
                    String replicaDataStoreId = accountConfigsMap.get(
                        targetGlobalCopyUID.getClusterUID().getId())
                        .getDatastoreId();
                    String replicaEsxId = accountConfigsMap.get(
                        targetGlobalCopyUID.getClusterUID().getId())
                        .getEsxId();
                    createVMParam
                        .setTargetVirtualCenterUID(new VirtualCenterUID(
                            replicaVcId));
                    createVMParam.setTargetDatastoreUID(new DatastoreUID(
                        replicaDataStoreId));
                    createVMParam
                        .setTargetResourcePlacementParam(new CreateTargetVMManualResourcePlacementParam(
                            new EsxUID(replicaEsxId)));

                    targetReplicatedVMParam.setVmParam(createVMParam);
                    targetReplicatedVMParam.setCopyUID(targetGlobalCopyUID);

                    replicatedVmParams.add(targetReplicatedVMParam);
                }
            }

            VirtualHardwareReplicationPolicy virtualHardwareReplicationPolicy = new VirtualHardwareReplicationPolicy();
            virtualHardwareReplicationPolicy
                .setProvisionPolicy(DiskProvisionPolicy.SAME_AS_SOURCE);
            virtualHardwareReplicationPolicy
                .setHwChangesPolicy(HardwareChangesPolicy.REPLICATE_HW_CHANGES);

            VirtualDisksReplicationPolicy virtualDisksReplicationPolicy = new VirtualDisksReplicationPolicy();
            virtualDisksReplicationPolicy.setAutoReplicateNewVirtualDisks(true);

            // create and add new replication set
            VMReplicationSetParam replicationSetParam = new VMReplicationSetParam(
                replicatedVmParams, virtualHardwareReplicationPolicy,
                virtualDisksReplicationPolicy);
            vmReplicationSets.add(replicationSetParam);

        }

        // create copies
        Collection<ConsistencyGroupCopyParam> copiesList = replicateVmsParam.getCopies();
        for (PackageConfig accountConfig : accountConfigList) {
            GlobalCopyUID copyUID = new GlobalCopyUID(new ClusterUID(
                accountConfig.getClusterId()), 0);
            ConsistencyGroupCopyParam consistencyGroupCopyParam = new ConsistencyGroupCopyParam();
            consistencyGroupCopyParam.setCopyUID(copyUID);
            consistencyGroupCopyParam.setCopyName(accountConfig
                .getClusterFriendlyName());

            ConsistencyGroupCopyVolumeCreationParams consistencyGroupCopyVolumeCreationParams = new ConsistencyGroupCopyVolumeCreationParams();
            VolumeCreationParams volumeCreationParams = new VolumeCreationParams();

            volumeCreationParams.setVolumeSize(new VolumeSize(
                10l * 1024l * 1024l * 1024l));

            ResourcePoolUID resourcePoolUID = getRelevantResourcePool(
                accountConfig.getClusterId(), accountConfig.getVcId(),
                accountConfig.getDatastoreId());

            volumeCreationParams.setPoolUid(resourcePoolUID);
            volumeCreationParams
                .setResourcePoolType(ArrayResourcePoolType.VC_DATASTORE);
            volumeCreationParams.setArrayUid(resourcePoolUID.getArrayUid());

            consistencyGroupCopyVolumeCreationParams.getVolumeParams().add(
                volumeCreationParams);
            consistencyGroupCopyParam
                .setVolumeCreationParams(consistencyGroupCopyVolumeCreationParams);
            copiesList.add(consistencyGroupCopyParam);

        }

        // create links
        Collection<FullConsistencyGroupLinkPolicy> linkPoliciesList = replicateVmsParam.getLinks();
        ConsistencyGroupLinkPolicy remoteDefaultLinkPolicy = connector
            .getDefaultRemoteGroupLinkPolicy();
        remoteDefaultLinkPolicy.getProtectionPolicy().getRpoPolicy()
            .setMaximumAllowedLag(new Quantity(rpo, QuantityType.MINUTES));
        for (PackageConfig accountConfig : accountConfigList) {
            if (!accountConfig.getIsProductionCluster()) {
                ConsistencyGroupLinkUID linkUID = new ConsistencyGroupLinkUID();
                linkUID.setGroupUID(new ConsistencyGroupUID(0));
                linkUID.setFirstCopy(productionCopy);
                GlobalCopyUID copyUID = new GlobalCopyUID(new ClusterUID(
                    accountConfig.getClusterId()), 0);
                linkUID.setSecondCopy(copyUID);
                FullConsistencyGroupLinkPolicy fullConsistencyGroupLinkPolicy = new FullConsistencyGroupLinkPolicy();
                fullConsistencyGroupLinkPolicy
                    .setLinkPolicy(remoteDefaultLinkPolicy);
                fullConsistencyGroupLinkPolicy.setLinkUID(linkUID);
                linkPoliciesList.add(fullConsistencyGroupLinkPolicy);
            }
        }

        ConsistencyGroupUID consistencyGroupUID = connector.replicateVms(
            replicateVmsParam, true);
        return consistencyGroupUID.getId();
    }

    public void setGroupPackage(Long groupId, Long packageId) {
        UserDefinedProperties userProps = connector.getUserProperties();
        Property property = new Property(groupId + "-pkg", packageId.toString());
        userProps.getProperties().add(property);
        connector.setUserProperties(userProps);
    }

    public Long getGroupPackage(Long groupId) {
        Long res = null;
        UserDefinedProperties userProps = connector.getUserProperties();
        for (Property prop : userProps.getProperties()) {
            if (prop.getKey().equals(groupId + "-pkg")) {
                res = Long.parseLong(prop.getValue());
            }
        }
        return res;
    }

    public Map<String, String> getUserPropertiesMap() {
        Map<String, String> propsMap = new HashMap<String, String>();
        UserDefinedProperties userProps = connector.getUserProperties();
        for (Property prop : userProps.getProperties()) {
            propsMap.put(prop.getKey(), prop.getValue());
        }
        return propsMap;
    }

    public ResourcePoolUID getRelevantResourcePool(long clusterId, String vcId,
                                                   String datastoreId) {
        ResourcePoolUID res = null;
        ClusterSettings clusterSettings = getClusterSettings(clusterId);
        Collection<ArrayManagementProviderSettings> arrayManagementProviderSettings = clusterSettings
            .getAmpsSettings();
        for (ArrayManagementProviderSettings currProviderSettings : arrayManagementProviderSettings) {
            if (currProviderSettings.getType().equals(
                ArrayManagementProviderType.VC)) {
                Collection<ArraySettings> managedArrays = currProviderSettings
                    .getManagedArrays();
                for (ArraySettings currArraySettings : managedArrays) {
                    String serialNumber = currArraySettings.getSerialNumber();
                    if (vcId.equals(serialNumber)) {
                        Collection<ArrayResourcePoolSettings> resourcePools = currArraySettings
                            .getResourcePools();
                        for (ArrayResourcePoolSettings currArrayResourcePoolSettings : resourcePools) {
                            ResourcePoolUID resourcePoolUid = currArrayResourcePoolSettings
                                .getResourcePoolUID();
                            if (resourcePoolUid.getStorageResourcePoolId()
                                .equals(datastoreId)) {
                                res = resourcePoolUid;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    public ClusterSettings getClusterSettings(long clusterId) {
        ClusterSettings clusterSettings = connector
            .getClusterSettings(clusterId);
        return clusterSettings;
    }

    private VmReplicationSetSettings getVmReplicationSettingsWithRetryOption(
        String vmId, int retryAttempts) {
        Map<String, VmReplicationSetSettings> vmToReplicationSetMap = getVmToReplicationSetSettingsMap();
        VmReplicationSetSettings vmReplicationSetSettings = vmToReplicationSetMap
            .get(vmId);
        if (vmReplicationSetSettings == null) {
            for (int i = 0; i < retryAttempts; i++) {
                try {
                    Thread.currentThread().sleep(TimeUnit.SECONDS.toMillis(5));
                } catch (InterruptedException e) {
                }
                vmToReplicationSetMap = getVmToReplicationSetSettingsMap();
                if (vmToReplicationSetMap != null) {
                    vmReplicationSetSettings = vmToReplicationSetMap.get(vmId);
                    break;
                }
            }
        }
        return vmReplicationSetSettings;
    }

    private Map<String, String> getVmState(FullRecoverPointSettings rpSettings) {
        Map<String, String> res = new HashMap<>();
        Map<Long, Collection<ConsistencyGroupCopyUID>> productionCopies = getProductionCopies(rpSettings);

        Collection<ConsistencyGroupSettings> groupSettingsList = rpSettings
            .getGroupsSettings();
        for (ConsistencyGroupSettings groupSettings : groupSettingsList) {

            Collection<VmReplicationSetSettings> vmReplicationSetSettingsList = groupSettings
                .getVmReplicationSetsSettings();

            for (VmReplicationSetSettings vmReplicationSet : vmReplicationSetSettingsList) {

                Collection<VmReplicationSettings> vmReplicationSettingsList = vmReplicationSet
                    .getReplicatedVMs();

                for (VmReplicationSettings vmReplication : vmReplicationSettingsList) {
                    String vmId = vmReplication.getVmUID().getUuid();
                    ConsistencyGroupCopyUID copyId = vmReplication.getGroupCopyUID();
                    Long clusterId =
                        copyId.getGlobalCopyUID().getClusterUID().getId();
                    Collection<ConsistencyGroupCopyUID> production =
                        productionCopies.get(copyId.getGroupUID().getId());
                    if (production.contains(copyId)) {
                        res.put(vmId, StatesConsts.STATE_SOURCE);
                    } else {
                        String state = StatesConsts.STATE_REMOTE;
                        for (ConsistencyGroupCopyUID copy : production) {
                            if (clusterId == copy.getGlobalCopyUID()
                                .getClusterUID().getId()) {
                                state = StatesConsts.STATE_LOCAL;
                            }
                        }
                        res.put(vmId, state);
                    }
                }
            }
        }
        return res;
    }

    private Map<String, VmReplicationSetSettings> getVmToReplicationSetSettingsMap() {
        FullRecoverPointSettings rpSettings = getFullRecoverPointSettings();
        Map<String, VmReplicationSetSettings> res = new HashMap<>();

        Collection<ConsistencyGroupSettings> groupSettingsList = rpSettings
            .getGroupsSettings();
        for (ConsistencyGroupSettings groupSettings : groupSettingsList) {

            Collection<VmReplicationSetSettings> vmReplicationSetSettingsList = groupSettings
                .getVmReplicationSetsSettings();

            for (VmReplicationSetSettings vmReplicationSet : vmReplicationSetSettingsList) {

                Collection<VmReplicationSettings> vmReplicationSettingsList = vmReplicationSet
                    .getReplicatedVMs();

                for (VmReplicationSettings vmReplication : vmReplicationSettingsList) {
                    String vmId = vmReplication.getVmUID().getUuid();
                    res.put(vmId, vmReplicationSet);

                }
            }
        }
        return res;
    }

    public Map<String, Map<String, Object>> getVmInfoMap() {
        Map<String, Map<String, Object>> res = new HashMap<String, Map<String, Object>>();
        FullRecoverPointSettings rpSettings = getFullRecoverPointSettings();
        Map<Long, Map<String, String>> vmNamesAllClusters = getVmNamesAllClusters();

        Collection<ConsistencyGroupSettings> groupSettingsList = rpSettings
            .getGroupsSettings();
        for (ConsistencyGroupSettings groupSettings : groupSettingsList) {

            Collection<VmReplicationSetSettings> vmReplicationSetSettingsList = groupSettings
                .getVmReplicationSetsSettings();

            for (VmReplicationSetSettings vmReplicationSet : vmReplicationSetSettingsList) {// /
                Collection<VmReplicationSettings> vmReplicationSettingsList = vmReplicationSet
                    .getReplicatedVMs();
                Map<String, Object> singleVmInfoMap = new HashMap<String, Object>();
                String productionVmId = null;

                for (VmReplicationSettings vmReplication : vmReplicationSettingsList) {
                    String vmId = vmReplication.getVmUID().getUuid();
                    ConsistencyGroupCopyUID copyId = vmReplication
                        .getGroupCopyUID();
                    Long clusterId = copyId.getGlobalCopyUID().getClusterUID()
                        .getId();

                    Collection<ConsistencyGroupCopyUID> production = groupSettings
                        .getProductionCopiesUID();
                    if (production.contains(copyId)) {
                        productionVmId = vmId;

                        Map<String, String> vmNamesMap = vmNamesAllClusters
                            .get(clusterId);
                        String vmName = vmNamesMap.get(vmId);
                        singleVmInfoMap.put(GeneralFalConsts.PRODUCTION_VM_NAME,
                            vmName);
                    } else {
                        Map<String, String> vmNamesMap = vmNamesAllClusters
                            .get(clusterId);
                        String vmName = vmNamesMap.get(vmId);
                        singleVmInfoMap.put(GeneralFalConsts.REPLICA_CLUSTER_ID,
                            clusterId);
                        singleVmInfoMap.put(GeneralFalConsts.REPLICA_GROUP_ID,
                            copyId.getGroupUID().getId());
                        singleVmInfoMap.put(GeneralFalConsts.REPLICA_COPY_ID,
                            copyId.getGlobalCopyUID().getCopyUID());
                        singleVmInfoMap.put(GeneralFalConsts.REPLICA_VM_NAME,
                            vmName);
                    }

                }

                res.put(productionVmId, singleVmInfoMap);

            }
        }
        return res;
    }

    public Map<String, Object> getReplicaInfoByProductionVmId(
        String productionVmId) {
        Map<String, Object> res = null;
        new HashMap<String, Object>();
        FullRecoverPointSettings rpSettings = getFullRecoverPointSettings();

        Collection<ConsistencyGroupSettings> groupSettingsList = rpSettings
            .getGroupsSettings();
        for (ConsistencyGroupSettings groupSettings : groupSettingsList) {

            Collection<VmReplicationSetSettings> vmReplicationSetSettingsList = groupSettings
                .getVmReplicationSetsSettings();

            for (VmReplicationSetSettings vmReplicationSet : vmReplicationSetSettingsList) {
                if (isContainsVm(vmReplicationSet, productionVmId)) {
                    Collection<VmReplicationSettings> vmReplicationSettingsList = vmReplicationSet
                        .getReplicatedVMs();

                    for (VmReplicationSettings vmReplication : vmReplicationSettingsList) {
                        String vmId = vmReplication.getVmUID().getUuid();
                        ConsistencyGroupCopyUID copyId = vmReplication
                            .getGroupCopyUID();
                        Long clusterId = copyId.getGlobalCopyUID()
                            .getClusterUID().getId();

                        Collection<ConsistencyGroupCopyUID> production = groupSettings
                            .getProductionCopiesUID();
                        if (!production.contains(copyId)) {
                            res = new HashMap<String, Object>();
                            Map<Long, Map<String, String>> vmNamesAllClusters = getVmNamesAllClusters();
                            Map<String, String> vmNamesMap = vmNamesAllClusters
                                .get(clusterId);
                            String vmName = vmNamesMap.get(vmId);
                            res.put(GeneralFalConsts.REPLICA_CLUSTER_ID, clusterId);
                            res.put(GeneralFalConsts.REPLICA_GROUP_ID, copyId
                                .getGroupUID().getId());
                            res.put(GeneralFalConsts.REPLICA_COPY_ID, copyId
                                .getGlobalCopyUID().getCopyUID());
                            res.put(GeneralFalConsts.REPLICA_VM_NAME, vmName);
                        }

                    }
                }
            }
        }
        return res;
    }

    private boolean isContainsVm(VmReplicationSetSettings vmReplicationSet,
                                 String vmId) {
        boolean res = false;
        Collection<VmReplicationSettings> vmReplicationSettingsList = vmReplicationSet
            .getReplicatedVMs();

        for (VmReplicationSettings vmReplication : vmReplicationSettingsList) {
            String currVmId = vmReplication.getVmUID().getUuid();
            if (currVmId.equals(vmId)) {
                res = true;
            }
        }
        return res;
    }

    // Propogate to data a map groupId --> Set of production copies
    private Map<Long, Collection<ConsistencyGroupCopyUID>> getProductionCopies(
        FullRecoverPointSettings rpSettings) {
        Map<Long, Collection<ConsistencyGroupCopyUID>> res = new HashMap<>();
        Collection<ConsistencyGroupSettings> groupSettingsList = rpSettings
            .getGroupsSettings();
        for (ConsistencyGroupSettings groupSettings : groupSettingsList) {
            Collection<ConsistencyGroupCopyUID> productionCopiesList = groupSettings
                .getProductionCopiesUID();
            res.put(groupSettings.getGroupUID().getId(), productionCopiesList);

        }
        return res;
    }

    private boolean isEOFCause(Throwable e) {
        boolean res = false;
        if (e.getCause() != null && e.getCause().getCause() != null
            && e.getCause().getCause() instanceof EOFException) {
            res = true;
        }
        return res;
    }

    private Map<Long, PackageConfig> getAccountConfigsMap(
        List<PackageConfig> accountConfigs) {
        Map<Long, PackageConfig> accountConfigsMap = new HashMap<Long, PackageConfig>();
        for (PackageConfig currPackageConfig : accountConfigs) {
            accountConfigsMap.put(currPackageConfig.getClusterId(),
                currPackageConfig);
        }
        return accountConfigsMap;
    }

	/*
	 * private Map<Long, PackageConfig> getAccountConfigsMap(List<PackageConfig>
	 * accountConfigs) { Map<Long, PackageConfig> accountConfigsMap =
	 * accountConfigs.stream()
	 * .collect(Collectors.toMap(PackageConfig::getClusterId, (p) -> p)); return
	 * accountConfigsMap; }
	 */

}
