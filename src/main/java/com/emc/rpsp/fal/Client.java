package com.emc.rpsp.fal;

import java.io.EOFException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.Body;

import com.emc.fapi.jaxws.v4_3.BookmarkConsolidationPolicy;
import com.emc.fapi.jaxws.v4_3.ClusterInfo;
import com.emc.fapi.jaxws.v4_3.ClusterUID;
import com.emc.fapi.jaxws.v4_3.ClusterVirtualInfrastructuresState;
import com.emc.fapi.jaxws.v4_3.ClusterVirtualInfrastructuresStateSet;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupCopySettings;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupCopySettingsSet;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupCopyUID;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupSetSubset;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupSetUID;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupSettings;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupSnapshots;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupStateSet;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupStatisticsSet;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupUID;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupVolumesStateSet;
import com.emc.fapi.jaxws.v4_3.CreateBookmarkForGroupSetSubSetParams;
import com.emc.fapi.jaxws.v4_3.CreateBookmarkParams;
import com.emc.fapi.jaxws.v4_3.CreateTargetVMManualResourcePlacementParam;
import com.emc.fapi.jaxws.v4_3.CreateVMParam;
import com.emc.fapi.jaxws.v4_3.DatastoreUID;
import com.emc.fapi.jaxws.v4_3.DiskProvisionPolicy;
import com.emc.fapi.jaxws.v4_3.EnableImageAccessParams;
import com.emc.fapi.jaxws.v4_3.EnableLatestImageAccessParams;
import com.emc.fapi.jaxws.v4_3.EsxUID;
import com.emc.fapi.jaxws.v4_3.FullRecoverPointSettings;
import com.emc.fapi.jaxws.v4_3.GlobalCopyUID;
import com.emc.fapi.jaxws.v4_3.HardwareChangesPolicy;
import com.emc.fapi.jaxws.v4_3.ImageAccessMode;
import com.emc.fapi.jaxws.v4_3.ImageAccessScenario;
import com.emc.fapi.jaxws.v4_3.RecoverPointClustersInformation;
import com.emc.fapi.jaxws.v4_3.RecoverPointTimeStamp;
import com.emc.fapi.jaxws.v4_3.ReplicatedVMParams;
import com.emc.fapi.jaxws.v4_3.Snapshot;
import com.emc.fapi.jaxws.v4_3.SnapshotConsistencyType;
import com.emc.fapi.jaxws.v4_3.SnapshotUID;
import com.emc.fapi.jaxws.v4_3.SourceVmParam;
import com.emc.fapi.jaxws.v4_3.VMReplicationSetParam;
import com.emc.fapi.jaxws.v4_3.VirtualCenterUID;
import com.emc.fapi.jaxws.v4_3.VirtualDisksReplicationPolicy;
import com.emc.fapi.jaxws.v4_3.VirtualHardwareReplicationPolicy;
import com.emc.fapi.jaxws.v4_3.VmPowerUpSequenceParam;
import com.emc.fapi.jaxws.v4_3.VmPowerUpSequenceParamSet;
import com.emc.fapi.jaxws.v4_3.VmReplicationSetParamSet;
import com.emc.fapi.jaxws.v4_3.VmReplicationSetSettings;
import com.emc.fapi.jaxws.v4_3.VmReplicationSettings;
import com.emc.fapi.jaxws.v4_3.VmState;
import com.emc.fapi.jaxws.v4_3.VmUID;
import com.emc.fapi.jaxws.v4_3.VmUIDSet;
import com.emc.rpsp.RpspException;
import com.emc.rpsp.StatesConsts;
import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.accounts.domain.AccountConfig;
import com.emc.rpsp.repository.SystemConnectionInfoRepository;
import com.emc.rpsp.rpsystems.SystemSettings;
import com.emc.rpsp.vmstructure.domain.CopySnapshot;

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
            throw new RpspException("Couldn't access host " + systemSettings.getSystemIp());
        }
    }

    /**
     * @return Map of vmId => vmName in the cluster
     */
    public Map<String, String> getVmNamesInCluster(long clusterId) {
        ClusterVirtualInfrastructuresState state = connector
        .getVirtualInfrastructuresStateFromCluster(clusterId);
        List<VmState> vmStateList = state.getVirtualInfrastructuresState().getVmsState();
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
        RecoverPointClustersInformation rpClusters = connector.getRpClustersInformation();
        systemSettings.setTestResult(true);
        return getClusterNames(rpClusters);
    }

    private Map<Long, String> getClusterNames(RecoverPointClustersInformation rpClusters) {
        Map<Long, String> res = new HashMap<>();
        for (ClusterInfo clusterInfo : rpClusters.getClustersInformation()) {
            res.put(clusterInfo.getClusterUID().getId(), clusterInfo.getClusterName());
        }
        return res;
    }

    private Map<Long, Map<String, String>> getVmNames(
    ClusterVirtualInfrastructuresStateSet stateSet) {
        Map<Long, Map<String, String>> res = new HashMap<>();
        for (ClusterVirtualInfrastructuresState state : stateSet.getInnerSet()) {
            List<VmState> vmStateList = state.getVirtualInfrastructuresState().getVmsState();
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

    public void enableLatestImageAccess(Long clusterId, Long groupId, Integer copyId) {
        EnableLatestImageAccessParams params = new EnableLatestImageAccessParams();
        params.setScenario(ImageAccessScenario.TEST_REPLICA);
        params.setMode(ImageAccessMode.LOGGED_ACCESS);
        try {
            connector.enableLatestImageAccess(clusterId, groupId, copyId, params);
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
        ConsistencyGroupStateSet consistencyGroupStateSet = connector.getConsistencyGroupStateSet();
        return consistencyGroupStateSet;
    }

    public ConsistencyGroupVolumesStateSet getConsistencyGroupVolumesStateSet() {
        ConsistencyGroupVolumesStateSet consistencyGroupVolumesStateSet = connector
        .getConsistencyGroupVolumesStateSet();
        return consistencyGroupVolumesStateSet;
    }

    public ConsistencyGroupSnapshots getGroupSnapshots(Long groupId) {

		/*long dayInMicroseconds = 1000 * 1000 * 60 * 60 * 24;
        long currTime = connector.getSystemTime().getTimeInMicroSeconds() - dayInMicroseconds;
		Long startTime = new Long(currTime - dayInMicroseconds);
		Long endTime = new Long(currTime);*/

        Long startTime = null;
        Long endTime = null;
        ConsistencyGroupSnapshots consistencyGroupSnapshots = connector
        .getGroupSnapshots(groupId, startTime, endTime);
        return consistencyGroupSnapshots;
    }

    public void enableSnapshotImageAccess(Long clusterId, Long groupId, int copyId,
    CopySnapshot copySnapshot) {
        EnableImageAccessParams enableImageAccessParams = new EnableImageAccessParams();
        enableImageAccessParams.setScenario(ImageAccessScenario.TEST_REPLICA);
        enableImageAccessParams.setMode(ImageAccessMode.LOGGED_ACCESS);
        Snapshot snapshot = new Snapshot();
        snapshot.setSnapshotUID(new SnapshotUID(copySnapshot.getId()));
        snapshot
        .setClosingTimeStamp(new RecoverPointTimeStamp(copySnapshot.getOriginalClosingTimeStamp()));
        snapshot.setDescription("");
        enableImageAccessParams.setSnapshot(snapshot);
        try {
            connector
            .enableSnapshotImageAccess(clusterId, groupId, copyId, enableImageAccessParams);
        } catch (Throwable e) {
            if (!isEOFCause(e)) {
                throw e;
            }
        }

    }
    
    @SuppressWarnings("unused")
	public void addVmToCG(String vmId, Long groupId, Account account){
    	
    	ConsistencyGroupCopySettingsSet consistencyGroupCopySettingsSet = connector.getAllGroupCopies(groupId);   	
    	List<ConsistencyGroupCopySettings> consistencyGroupCopySettingsList = consistencyGroupCopySettingsSet.getInnerSet();
    	Long productionClusterId = 0L;
    	int productionCopyId = 0;
    	for(ConsistencyGroupCopySettings currConsistencyGroupCopySettings : consistencyGroupCopySettingsList){
    		if(currConsistencyGroupCopySettings.getRoleInfo().getSourceCopyUID() == null){
    			productionClusterId = currConsistencyGroupCopySettings.getCopyUID().getGlobalCopyUID().getClusterUID().getId();
    			productionCopyId = currConsistencyGroupCopySettings.getCopyUID().getGlobalCopyUID().getCopyUID();
    		}
    	}
    	
    	
    	List<ReplicatedVMParams> replicatedVmParams = new LinkedList<ReplicatedVMParams>();
    	Map<Long, AccountConfig> accountConfigsMap = account.getAccountConfigsMap();
    	
    	for(ConsistencyGroupCopySettings currConsistencyGroupCopySettings : consistencyGroupCopySettingsList){
    		if(currConsistencyGroupCopySettings.getRoleInfo().getSourceCopyUID() != null){
    			
    			
    			//add source parameter
    	    	ReplicatedVMParams sourceReplicatedVMParam = new ReplicatedVMParams();   
    	    	
    	    	SourceVmParam sourceVmParam = new SourceVmParam();
    	    	VmUID vmUID = new VmUID();
    	    	vmUID.setUuid(vmId);
    	    	String prodVcId = accountConfigsMap.get(productionClusterId).getVcId();
    	    	VirtualCenterUID virtualCenterUID = new VirtualCenterUID(prodVcId);   	
    	    	vmUID.setVirtualCenterUID(virtualCenterUID);    	
    	    	sourceVmParam.setVmUID(vmUID);
    	    	sourceVmParam.setClusterUID(new ClusterUID(productionClusterId));
    	    	
    	    	GlobalCopyUID globalCopyUID = new GlobalCopyUID(new ClusterUID(productionClusterId), productionCopyId);
    	    	
    	    	sourceReplicatedVMParam.setVmParam(sourceVmParam);
    	    	sourceReplicatedVMParam.setCopyUID(globalCopyUID);
    	    	
    	    	replicatedVmParams.add(sourceReplicatedVMParam);
    	    	
    	    	
    	    	//add target parameter
    	    	ReplicatedVMParams targetReplicatedVMParam = new ReplicatedVMParams();
    	    	CreateVMParam createVMParam = new CreateVMParam();
    	    	GlobalCopyUID targetGlobalCopyUID = currConsistencyGroupCopySettings.getCopyUID().getGlobalCopyUID();
    	    	String replicaVcId = accountConfigsMap.get(targetGlobalCopyUID.getClusterUID().getId()).getVcId();
    	    	String replicaDataStoreId = accountConfigsMap.get(targetGlobalCopyUID.getClusterUID().getId()).getDatastoreId();
    	    	String replicaEsxId = accountConfigsMap.get(targetGlobalCopyUID.getClusterUID().getId()).getEsxId();
    	    	createVMParam.setTargetVirtualCenterUID(new VirtualCenterUID(replicaVcId));
    	    	createVMParam.setTargetDatastoreUID(new DatastoreUID(replicaDataStoreId));    	    	
    	    	createVMParam.setTargetResourcePlacementParam(new CreateTargetVMManualResourcePlacementParam(new EsxUID(replicaEsxId)));    	    	
    	    	
    	    	
    	    	targetReplicatedVMParam.setVmParam(createVMParam);
    	    	targetReplicatedVMParam.setCopyUID(targetGlobalCopyUID);
    	    	
    	    	replicatedVmParams.add(targetReplicatedVMParam);
    		}
    	}
  	
    	VirtualHardwareReplicationPolicy virtualHardwareReplicationPolicy = new VirtualHardwareReplicationPolicy();
    	virtualHardwareReplicationPolicy.setProvisionPolicy(DiskProvisionPolicy.SAME_AS_SOURCE);
    	virtualHardwareReplicationPolicy.setHwChangesPolicy(HardwareChangesPolicy.REPLICATE_HW_CHANGES);
    	
    	VirtualDisksReplicationPolicy virtualDisksReplicationPolicy = new VirtualDisksReplicationPolicy();
    	virtualDisksReplicationPolicy.setAutoReplicateNewVirtualDisks(true);
    	
    	
    	VMReplicationSetParam replicationSetParam = new VMReplicationSetParam(replicatedVmParams, virtualHardwareReplicationPolicy, virtualDisksReplicationPolicy);
    	
    	List<VMReplicationSetParam> innerSet = new LinkedList<VMReplicationSetParam>(); 
    	innerSet.add(replicationSetParam);
    	VmReplicationSetParamSet vmReplicationSetParamSet = new VmReplicationSetParamSet(innerSet);   	    	

		Response response = connector.addVmToCG(groupId, vmReplicationSetParamSet);
    }
    
    
    @SuppressWarnings("static-access")
	public void changeVmsPowerUpSequence(String vmId, Long groupId, boolean isCritical, int sequenceNumber) {   	
    	VmReplicationSetSettings vmReplicationSetSettings = getVmReplicationSettingsWithRetryOption(vmId, 3);    	
    	if(vmReplicationSetSettings != null){
	    	VmPowerUpSequenceParamSet vmPowerUpSequenceParamSet = new VmPowerUpSequenceParamSet();
	    	VmPowerUpSequenceParam vmPowerUpSequenceParam = new VmPowerUpSequenceParam();
	    	vmPowerUpSequenceParam.setVmReplicationSetUID(vmReplicationSetSettings.getVmReplicationSetUID());
	    	vmPowerUpSequenceParam.setIsCritical(isCritical);
	    	vmPowerUpSequenceParam.setPowerUpSequenceNumber(sequenceNumber);
	    	vmPowerUpSequenceParamSet.getInnerSet().add(vmPowerUpSequenceParam);
	    	connector.changeVmsPowerUpSequence(groupId, vmPowerUpSequenceParamSet);
    	}
    }
   
    
    public void removeVmsFromCG(String vmId, Long groupId, Account account){
    	
    	ConsistencyGroupCopySettingsSet consistencyGroupCopySettingsSet = connector.getAllGroupCopies(groupId);   	
    	List<ConsistencyGroupCopySettings> consistencyGroupCopySettingsList = consistencyGroupCopySettingsSet.getInnerSet();
    	Long productionClusterId = 0L;
    	for(ConsistencyGroupCopySettings currConsistencyGroupCopySettings : consistencyGroupCopySettingsList){
    		if(currConsistencyGroupCopySettings.getRoleInfo().getSourceCopyUID() == null){
    			productionClusterId = currConsistencyGroupCopySettings.getCopyUID().getGlobalCopyUID().getClusterUID().getId();
    		}
    	}
    	String productionVcId = account.getAccountConfigsMap().get(productionClusterId).getVcId();
    	VirtualCenterUID productionVirtualCenterUID = new VirtualCenterUID(productionVcId);
    	VmUID vmUID = new VmUID(vmId, productionVirtualCenterUID);
    	List<VmUID> innerSet = new LinkedList<VmUID>();
    	innerSet.add(vmUID);
    	VmUIDSet vmUIDSet = new VmUIDSet(innerSet);
    	connector.removeVmsFromCG(groupId, vmUIDSet);
    }
    
    
    @SuppressWarnings("unused")
   	public void createGroupBookmark(Long groupId, String bookmarkName, String consistencyType){
       	CreateBookmarkParams createBookmarkParams = new CreateBookmarkParams();
       	createBookmarkParams.getGroups().add(new ConsistencyGroupUID(groupId));
       	createBookmarkParams.setBookmarkName(bookmarkName);    	
       	createBookmarkParams.setConsistencyType(SnapshotConsistencyType.APPLICATION_CONSISTENT);
       /*	if(consistencyType.equals(GeneralFalConsts.APPLICATION_CONSISTENCY_TYPE)){
       		createBookmarkParams.setConsistencyType(SnapshotConsistencyType.APPLICATION_CONSISTENT);
       	}
       	else{
       		createBookmarkParams.setConsistencyType(SnapshotConsistencyType.UNKNOWN);   		
       	}*/
       	createBookmarkParams.setConsolidationPolicy(BookmarkConsolidationPolicy.NEVER_CONSOLIDATE);
       	Response response = connector.createGroupBookmark(createBookmarkParams);
       }
       
       
   	@SuppressWarnings("unused")
   	public void createGroupSetBookmark(Long groupSetId, String bookmarkName, String consistencyType){
   		CreateBookmarkForGroupSetSubSetParams createBookmarkForGroupSetSubSetParams = 
   				                                         new CreateBookmarkForGroupSetSubSetParams();
   		ConsistencyGroupSetSubset consistencyGroupSetSubset = new ConsistencyGroupSetSubset();
   		consistencyGroupSetSubset.setGroupSetUID(new ConsistencyGroupSetUID(groupSetId));
   		createBookmarkForGroupSetSubSetParams.setGroupSetSubset(consistencyGroupSetSubset);
   		createBookmarkForGroupSetSubSetParams.getGroupSetSubset().setGroupSetUID(new ConsistencyGroupSetUID(groupSetId));
   		createBookmarkForGroupSetSubSetParams.setBookmarkName(bookmarkName);
       	createBookmarkForGroupSetSubSetParams.setConsistencyType(SnapshotConsistencyType.APPLICATION_CONSISTENT);   		
   		/*if(consistencyType.equals(GeneralFalConsts.APPLICATION_CONSISTENCY_TYPE)){
   			createBookmarkForGroupSetSubSetParams.setConsistencyType(SnapshotConsistencyType.APPLICATION_CONSISTENT);
       	}
       	else{
       		createBookmarkForGroupSetSubSetParams.setConsistencyType(SnapshotConsistencyType.UNKNOWN);   		
       	}*/
   		createBookmarkForGroupSetSubSetParams.setConsolidationPolicy(BookmarkConsolidationPolicy.NEVER_CONSOLIDATE);
   		Response response = connector.createGroupSetBookmark(createBookmarkForGroupSetSubSetParams);
   		
   	}
   	
   	public ConsistencyGroupStatisticsSet getGroupStatistics(){
   		ConsistencyGroupStatisticsSet consistencyGroupStatisticsSet = connector.getGroupStatistics();
   		return consistencyGroupStatisticsSet;
   	}
   	
   	
    private VmReplicationSetSettings getVmReplicationSettingsWithRetryOption(String vmId, int retryAttempts){
    	Map<String, VmReplicationSetSettings> vmToReplicationSetMap = getVmToReplicationSetSettingsMap();
    	VmReplicationSetSettings vmReplicationSetSettings = vmToReplicationSetMap.get(vmId);
    	if(vmReplicationSetSettings == null){
    		for(int i=0; i<retryAttempts; i++){
	    		try {
					Thread.currentThread().sleep(TimeUnit.SECONDS.toMillis(5));
				} catch (InterruptedException e) {
				}
	    		vmToReplicationSetMap = getVmToReplicationSetSettingsMap();
	    		if(vmToReplicationSetMap != null){
	    			vmReplicationSetSettings = vmToReplicationSetMap.get(vmId);
	    			break;
	    		}
    		}
    	}
    	return vmReplicationSetSettings;
    }
   	
   	
    private Map<String, String> getVmState(FullRecoverPointSettings rpSettings) {
        Map<String, String> res = new HashMap<>();
        Map<Long, List<ConsistencyGroupCopyUID>> productionCopies = getProductionCopies(rpSettings);

        List<ConsistencyGroupSettings> groupSettingsList = rpSettings.getGroupsSettings();
        for (ConsistencyGroupSettings groupSettings : groupSettingsList) {

            List<VmReplicationSetSettings> vmReplicationSetSettingsList = groupSettings
            .getVmReplicationSetsSettings();

            for (VmReplicationSetSettings vmReplicationSet : vmReplicationSetSettingsList) {

                List<VmReplicationSettings> vmReplicationSettingsList = vmReplicationSet
                .getReplicatedVMs();

                for (VmReplicationSettings vmReplication : vmReplicationSettingsList) {
                    String vmId = vmReplication.getVmUID().getUuid();
                    ConsistencyGroupCopyUID copyId = vmReplication.getGroupCopyUID();
                    Long clusterId = copyId.getGlobalCopyUID().getClusterUID().getId();
                    List<ConsistencyGroupCopyUID> production = productionCopies
                    .get(copyId.getGroupUID().getId());
                    if (production.contains(copyId)) {
                        res.put(vmId, StatesConsts.STATE_SOURCE);
                    } else {
                        String state = StatesConsts.STATE_REMOTE;
                        for (ConsistencyGroupCopyUID copy : production) {
                            if (clusterId == copy.getGlobalCopyUID().getClusterUID().getId()) {
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

        List<ConsistencyGroupSettings> groupSettingsList = rpSettings.getGroupsSettings();
        for (ConsistencyGroupSettings groupSettings : groupSettingsList) {

            List<VmReplicationSetSettings> vmReplicationSetSettingsList = groupSettings
            .getVmReplicationSetsSettings();

            for (VmReplicationSetSettings vmReplicationSet : vmReplicationSetSettingsList) {

                List<VmReplicationSettings> vmReplicationSettingsList = vmReplicationSet
                .getReplicatedVMs();

                for (VmReplicationSettings vmReplication : vmReplicationSettingsList) {
                    String vmId = vmReplication.getVmUID().getUuid();
                    res.put(vmId, vmReplicationSet);

                }
            }
        }
        return res;
    }

    // Propogate to data a map groupId --> Set of production copies
    private Map<Long, List<ConsistencyGroupCopyUID>> getProductionCopies(
    FullRecoverPointSettings rpSettings) {
        Map<Long, List<ConsistencyGroupCopyUID>> res = new HashMap<>();
        List<ConsistencyGroupSettings> groupSettingsList = rpSettings.getGroupsSettings();
        for (ConsistencyGroupSettings groupSettings : groupSettingsList) {
            List<ConsistencyGroupCopyUID> productionCopiesList = groupSettings
            .getProductionCopiesUID();
            res.put(groupSettings.getGroupUID().getId(), productionCopiesList);

        }
        return res;
    }

    private boolean isEOFCause(Throwable e) {
        boolean res = false;
        if (e.getCause() != null && e.getCause().getCause() != null && e.getCause()
        .getCause() instanceof EOFException) {
            res = true;
        }
        return res;
    }

}
