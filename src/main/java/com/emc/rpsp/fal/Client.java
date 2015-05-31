package com.emc.rpsp.fal;

import java.io.EOFException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit.RetrofitError;

import com.emc.fapi.jaxws.ClusterInfo;
import com.emc.fapi.jaxws.ClusterVirtualInfrastructuresState;
import com.emc.fapi.jaxws.ClusterVirtualInfrastructuresStateSet;
import com.emc.fapi.jaxws.ConsistencyGroupCopyUID;
import com.emc.fapi.jaxws.ConsistencyGroupSettings;
import com.emc.fapi.jaxws.EnableLatestImageAccessParams;
import com.emc.fapi.jaxws.FullRecoverPointSettings;
import com.emc.fapi.jaxws.ImageAccessMode;
import com.emc.fapi.jaxws.ImageAccessScenario;
import com.emc.fapi.jaxws.RecoverPointClustersInformation;
import com.emc.fapi.jaxws.VmReplicationSetSettings;
import com.emc.fapi.jaxws.VmReplicationSettings;
import com.emc.fapi.jaxws.VmState;
import com.emc.rpsp.RpspException;
import com.emc.rpsp.StatesConsts;
import com.emc.rpsp.repository.SystemConnectionInfoRepository;
import com.emc.rpsp.rpsystems.SystemSettings;

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

	/**
	 * @return Map of vmId => vmName in the cluster
	 */
	public Map<String, String> getVmNamesInCluster(long clusterId) {
		ClusterVirtualInfrastructuresState state = connector
		        .getVirtualInfrastructuresStateFromCluster(clusterId);
		List<VmState> vmStateList = state.getVirtualInfrastructuresState()
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
			List<VmState> vmStateList = state.getVirtualInfrastructuresState()
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
		FullRecoverPointSettings rpSettings = connector
		        .getFullRecoverPointSettings();
		return rpSettings;
	}

	public Map<String, String> getVmState() {
		FullRecoverPointSettings rpSettings = connector
		        .getFullRecoverPointSettings();
		return getVmState(rpSettings);
	}
	
	public void enableImageAccess(Long clusterId, Long groupId) {
		EnableLatestImageAccessParams params = new EnableLatestImageAccessParams();
		params.setScenario(ImageAccessScenario.TEST_REPLICA);
		params.setMode(ImageAccessMode.LOGGED_ACCESS);
		try{
			connector.enableLatestImageAccess(clusterId, groupId, params);
		}
		catch (Throwable e){
			if(!isEOFCause(e)){
				throw e;
			}
		}
	}
	
	
	public void disableImageAccess(Long clusterId, Long groupId) {
		try{
			connector.disableLatestImageAccess(clusterId, groupId);
		}
		catch (Throwable e){
			if(!isEOFCause(e)){
				throw e;
			}
		}
	}

	private Map<String, String> getVmState(FullRecoverPointSettings rpSettings) {
		Map<String, String> res = new HashMap<>();
		Map<Long, List<ConsistencyGroupCopyUID>> productionCopies = getProductionCopies(rpSettings);

		List<ConsistencyGroupSettings> groupSettingsList = rpSettings
		        .getGroupsSettings();
		for (ConsistencyGroupSettings groupSettings : groupSettingsList) {
			
			
			List<VmReplicationSetSettings> vmReplicationSetSettingsList = groupSettings
			        .getVmReplicationSetsSettings();
			
			
			for (VmReplicationSetSettings vmReplicationSet : vmReplicationSetSettingsList) {
				
				
				List<VmReplicationSettings> vmReplicationSettingsList = vmReplicationSet
				        .getReplicatedVMs();
				
				
				for (VmReplicationSettings vmReplication : vmReplicationSettingsList) {
					String vmId = vmReplication.getVmUID().getUuid();
					ConsistencyGroupCopyUID copyId = vmReplication
					        .getGroupCopyUID();
					Long clusterId = copyId.getGlobalCopyUID().getClusterUID()
					        .getId();
					List<ConsistencyGroupCopyUID> production = productionCopies
					        .get(copyId.getGroupUID().getId());
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

	// Propogate to data a map groupId --> Set of production copies
	private Map<Long, List<ConsistencyGroupCopyUID>> getProductionCopies(
	        FullRecoverPointSettings rpSettings) {
		Map<Long, List<ConsistencyGroupCopyUID>> res = new HashMap<>();
		List<ConsistencyGroupSettings> groupSettingsList = rpSettings
		        .getGroupsSettings();
		for (ConsistencyGroupSettings groupSettings : groupSettingsList) {
			List<ConsistencyGroupCopyUID> productionCopiesList = groupSettings
			        .getProductionCopiesUID();
			res.put(groupSettings.getGroupUID().getId(), productionCopiesList);

		}
		return res;
	}
	
	private boolean isEOFCause(Throwable e){
		boolean res = false;
		if(e.getCause() != null 
				&& e.getCause().getCause() != null
				    && e.getCause().getCause() instanceof EOFException){
			res = true;
		}
		return res;
	}
	
	
	

}
