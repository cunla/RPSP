package com.emc.rpsp.vmstructure.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emc.fapi.jaxws.v4_3.ConsistencyGroupCopySettings;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupCopySnapshots;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupCopyState;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupCopyUID;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupLinkState;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupLinkStatistics;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupLinkUID;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupSetSettings;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupSettings;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupSnapshots;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupState;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupStateSet;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupStatistics;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupStatisticsSet;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupUID;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupVolumesState;
import com.emc.fapi.jaxws.v4_3.ConsistencyGroupVolumesStateSet;
import com.emc.fapi.jaxws.v4_3.FullRecoverPointSettings;
import com.emc.fapi.jaxws.v4_3.GlobalCopyUID;
import com.emc.fapi.jaxws.v4_3.PipeState;
import com.emc.fapi.jaxws.v4_3.RecoverPointTimeStamp;
import com.emc.fapi.jaxws.v4_3.ReplicationSetVolumesState;
import com.emc.fapi.jaxws.v4_3.Snapshot;
import com.emc.fapi.jaxws.v4_3.SnapshotConsistencyType;
import com.emc.fapi.jaxws.v4_3.SnapshotUID;
import com.emc.fapi.jaxws.v4_3.StorageAccessState;
import com.emc.fapi.jaxws.v4_3.VmReplicationSetSettings;
import com.emc.fapi.jaxws.v4_3.VmReplicationSettings;
import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.accounts.service.AccountService;
import com.emc.rpsp.fal.Client;
import com.emc.rpsp.rpsystems.SystemSettings;
import com.emc.rpsp.users.domain.User;
import com.emc.rpsp.users.service.UserService;
import com.emc.rpsp.vms.domain.VmOwnership;
import com.emc.rpsp.vms.service.VmOwnershipService;
import com.emc.rpsp.vmstructure.constants.ConsistencyType;
import com.emc.rpsp.vmstructure.constants.ImageAccess;
import com.emc.rpsp.vmstructure.constants.TransferState;
import com.emc.rpsp.vmstructure.domain.AccountVmsStructure;
import com.emc.rpsp.vmstructure.domain.ClusterDefinition;
import com.emc.rpsp.vmstructure.domain.ConsistencyGroup;
import com.emc.rpsp.vmstructure.domain.CopySnapshot;
import com.emc.rpsp.vmstructure.domain.GroupCopySettings;
import com.emc.rpsp.vmstructure.domain.GroupSet;
import com.emc.rpsp.vmstructure.domain.VmContainer;
import com.emc.rpsp.vmstructure.domain.VmDefinition;
import com.emc.rpsp.vmstructure.service.AccountVmsStructureService;

@Service
public class AccountVmsStructureServiceImpl implements
		AccountVmsStructureService {

	@Autowired
	private UserService userService = null;

	@Autowired
	private AccountService accountService = null;

	@Autowired
	private VmOwnershipService vmOwnershipService = null;

	@Override
	public AccountVmsStructure getAccountVmsStrucure() {

		AccountVmsStructure accountVmsStructure = null;
		User user = userService.findCurrentUser().getUser();
		if (isNotImpersonatedAdmin(user)) {
			List<Account> accounts = accountService.findAll();
			accountVmsStructure = getAllAccountsData(accounts);
			updateVmNamesWithAccountInfo(accountVmsStructure);
		} else {
			Account account = user.getAccount();
			accountVmsStructure = getAccountData(account);
		}

		return accountVmsStructure;
	}

	private AccountVmsStructure getAccountData(Account account) {
		AccountVmsStructure accountVmsStructure = new AccountVmsStructure();

		if (account != null) {
			accountVmsStructure.setId(account.getId().toString());
			accountVmsStructure.setName(account.getName());
			List<SystemSettings> systems = account.getSystemSettings();
			for (SystemSettings currSystem : systems) {
				Client client = new Client(currSystem);
				AccountVmsStructure currAccountVmsStructure = getAccountVmsStrucure(
						client, account, currSystem);
				accountVmsStructure.getUnprotectedVms().addAll(
						currAccountVmsStructure.getUnprotectedVms());
				accountVmsStructure.getProtectedVms().addAll(
						currAccountVmsStructure.getProtectedVms());
			}
		}
		return accountVmsStructure;
	}

	private AccountVmsStructure getAllAccountsData(List<Account> accounts) {
		AccountVmsStructure accountVmsStructure = new AccountVmsStructure();
		if (accounts != null) {

			for (Account account : accounts) {
				List<SystemSettings> systems = account.getSystemSettings();
				for (SystemSettings currSystem : systems) {
					Client client = new Client(currSystem);
					AccountVmsStructure currAccountVmsStructure = getAccountVmsStrucure(
							client, account, currSystem);
					accountVmsStructure.getUnprotectedVms().addAll(
							currAccountVmsStructure.getUnprotectedVms());
					accountVmsStructure.getProtectedVms().addAll(
							currAccountVmsStructure.getProtectedVms());
				}
			}
		}
		return accountVmsStructure;
	}

	private boolean isNotImpersonatedAdmin(User user) {
		boolean res = false;
		if (user.getPermission().equals("ADMIN") && user.getAccount() == null) {
			res = true;
		}
		return res;
	}

	private void updateVmNamesWithAccountInfo(
			AccountVmsStructure accountVmsStructure) {
		List<VmDefinition> unprotectedVms = accountVmsStructure
				.getUnprotectedVms();
		updateVmNamesSubsetWithAccountInfo(unprotectedVms);

		List<VmContainer> protectedVms = accountVmsStructure.getProtectedVms();
		for (VmContainer currVmContainer : protectedVms) {
			if (currVmContainer instanceof ConsistencyGroup) {
				ConsistencyGroup consistencyGroup = (ConsistencyGroup) currVmContainer;
				List<VmDefinition> cgVms = consistencyGroup.getVms();
				updateVmNamesSubsetWithAccountInfo(cgVms);
			} else {
				GroupSet groupSet = (GroupSet) currVmContainer;
				List<VmContainer> cgList = groupSet.getConsistencyGroups();
				for (VmContainer vmContainer : cgList) {
					ConsistencyGroup consistencyGroup = (ConsistencyGroup) vmContainer;
					List<VmDefinition> cgVms = consistencyGroup.getVms();
					updateVmNamesSubsetWithAccountInfo(cgVms);
				}
			}
		}

	}

	private void updateVmNamesSubsetWithAccountInfo(List<VmDefinition> vmsList) {
		Map<String, Account> vmToAccountMap = getVmToAccountMap();
		for (VmDefinition currVmDef : vmsList) {
			currVmDef.setName(currVmDef.getName() + " " + "["
					+ vmToAccountMap.get(currVmDef.getId()).getLabel() + "]");
		}
		return;
	}

	private Map<String, Account> getVmToAccountMap() {
		List<VmOwnership> vmOwnerships = vmOwnershipService.findAll();
		Map<String, Account> vmToAccountMap = new HashMap<String, Account>();
		for (VmOwnership vmOwnership : vmOwnerships) {
			vmToAccountMap.put(vmOwnership.getVmId(), vmOwnership.getAccount());
		}
		return vmToAccountMap;
	}

	private AccountVmsStructure getAccountVmsStrucure(Client client,
			Account account, SystemSettings currSystem) {

		AccountVmsStructure accountVmsStructure = new AccountVmsStructure();
		List<VmContainer> protectedVms = new LinkedList<VmContainer>();

		FullRecoverPointSettings rpSettings = client
				.getFullRecoverPointSettings();

		Map<String, VmOwnership> vmsMap = getVmsMap(account);
		Map<Long, String> clusterNames = client.getClusterNames();
		/*Map<Long, Map<String, String>> vmNamesAllClusters = client
				.getVmNamesAllClusters();*/

		List<ConsistencyGroupSetSettings> groupSetsSettings = rpSettings
				.getGroupsSetsSettings();
		Map<String, GroupSet> groupIdToGroupSetMap = getGroupIdToGroupSetMap(groupSetsSettings);

		ConsistencyGroupStateSet consistencyGroupStateSet = client
				.getConsistencyGroupStateSet();

		Map<ConsistencyGroupCopyUID, String> transferStatesMap = getGroupCopiesTransferStates(consistencyGroupStateSet);
		Map<ConsistencyGroupCopyUID, ConsistencyGroupCopyState> copiesStatesMap = getGroupCopiesStates(consistencyGroupStateSet);
		Map<String, Long> volumesMaxSizesMap = getGroupVolumesMaxSizes(client);
		Map<ConsistencyGroupCopyUID, String> initCompletionPortionsMap = getInitCompletionPortion(client);

		List<ConsistencyGroupSettings> groupSettingsList = rpSettings
				.getGroupsSettings();
		for (ConsistencyGroupSettings groupSettings : groupSettingsList) {

			Map<ConsistencyGroupCopyUID, List<CopySnapshot>> copySnapshotsMap = getGroupCopiesSnapshots(
					client, groupSettings.getGroupUID().getId());
			Map<String, ClusterDefinition> handledCustersMap = new HashMap<String, ClusterDefinition>();
			ConsistencyGroup consistencyGroup = new ConsistencyGroup();
			String groupId = new Long(groupSettings.getGroupUID().getId())
					.toString();
			String groupName = groupSettings.getName();
			consistencyGroup.setId(groupId);
			consistencyGroup.setName(groupName);
			consistencyGroup.setMaxVolumeSize(volumesMaxSizesMap.get(groupId));

			List<VmReplicationSetSettings> vmReplicationSetSettingsList = groupSettings
					.getVmReplicationSetsSettings();

			ClusterDefinition productionCluster = null;
			List<ClusterDefinition> replicaClusters = new LinkedList<ClusterDefinition>();
			consistencyGroup.setReplicaClusters(replicaClusters);
			List<VmDefinition> vmsList = new LinkedList<VmDefinition>();
			consistencyGroup.setVms(vmsList);

			for (VmReplicationSetSettings vmReplicationSet : vmReplicationSetSettingsList) {
				List<VmReplicationSettings> vmReplicationSettingsList = vmReplicationSet
						.getReplicatedVMs();

				for (VmReplicationSettings vmReplication : vmReplicationSettingsList) {
					
					String vmId = vmReplication.getVmUID().getUuid();
					ConsistencyGroupCopyUID copyId = vmReplication
							.getGroupCopyUID();
					Long clusterId = copyId.getGlobalCopyUID().getClusterUID()
							.getId();
					String clusterName = clusterNames.get(clusterId);
					if (currSystem.getNameToClusterMap().get(clusterName) != null) {
						clusterName = currSystem.getNameToClusterMap()
								.get(clusterName).getFriendlyName();
					}
					//String vmName = vmNamesAllClusters.get(clusterId).get(vmId);
					List<ConsistencyGroupCopyUID> production = groupSettings
							.getProductionCopiesUID();
					// this vm belongs to production
					if (production.contains(copyId)) {
						// process vm only if it belongs to account
						if (vmsMap.get(vmId) != null) {							
							VmDefinition currVm = new VmDefinition(vmId, vmsMap.get(vmId).getVmName());
							currVm.setCritical(vmReplicationSet.getVmReplicationSetPolicy().isCritical());
							currVm.setSequenceNumber(vmReplicationSet.getVmReplicationSetPolicy().getPowerUpSequenceNumber());
							vmsList.add(currVm);
							productionCluster = new ClusterDefinition(
									clusterId.toString(), clusterName);
							consistencyGroup
									.setProductionCluster(productionCluster);
							// remove from unprotected candidates
							vmsMap.remove(vmId);
						}
					}
					// this vm belongs to replica
					else {
						ClusterDefinition replicaCluster = null;
						if (handledCustersMap.get(clusterId.toString()) != null) {
							replicaCluster = handledCustersMap.get(clusterId
									.toString());
						} else {
							replicaCluster = new ClusterDefinition(
									clusterId.toString(), clusterName);
							handledCustersMap.put(clusterId.toString(),
									replicaCluster);
							replicaClusters.add(replicaCluster);
						}
						GroupCopySettings groupCopySettings = getGroupCopySettings(
								copyId, groupSettings, transferStatesMap,
								copySnapshotsMap, copiesStatesMap, initCompletionPortionsMap);
						// add the copy in case it wasn't added in context of
						// another vm
						if (!replicaCluster.isExistingCopy(groupCopySettings)) {
							replicaCluster.addGroupCopy(groupCopySettings);
						}

					}

				}

			}

			if (!consistencyGroup.getVms().isEmpty()) {
				if (groupIdToGroupSetMap.get(consistencyGroup.getId()) != null) {
					GroupSet groupSet = groupIdToGroupSetMap
							.get(consistencyGroup.getId());
					groupSet.addConsistencyGroup(consistencyGroup);
				} else {
					protectedVms.add(consistencyGroup);
				}

			}
		}
		List<VmContainer> groupSets = getNotEmptyUniqueGroupSets(groupIdToGroupSetMap);
		accountVmsStructure.getProtectedVms().addAll(groupSets);
		accountVmsStructure.getProtectedVms().addAll(protectedVms);
		List<VmDefinition> unprotectedVms = getVmDefinitionsList(vmsMap);
		accountVmsStructure.setUnprotectedVms(unprotectedVms);
		return accountVmsStructure;
	}

	private Map<String, VmOwnership> getVmsMap(Account account) {
		List<VmOwnership> vms = account.getVms();
		Map<String, VmOwnership> vmsMap = vms.stream().collect(
				Collectors.toMap(VmOwnership::getVmId, (p) -> p));
		return vmsMap;
	}

	private List<VmDefinition> getVmDefinitionsList(
			Map<String, VmOwnership> vmsMap) {
		List<VmDefinition> vmsList = new LinkedList<VmDefinition>();
		if (vmsMap != null && !vmsMap.isEmpty()) {
			for (String vmId : vmsMap.keySet()) {
				VmDefinition vmDefinition = new VmDefinition(vmId, vmsMap.get(
						vmId).getVmName());
				vmsList.add(vmDefinition);
			}
		}
		return vmsList;
	}

	private Map<String, GroupSet> getGroupIdToGroupSetMap(
			List<ConsistencyGroupSetSettings> groupSetSettings) {
		Map<String, GroupSet> cgIdToGs = new HashMap<String, GroupSet>();
		if (groupSetSettings != null) {
			for (ConsistencyGroupSetSettings currGroupSetSettings : groupSetSettings) {
				GroupSet currGroupSet = new GroupSet();
				Long setUID = currGroupSetSettings.getSetUID().getId();
				currGroupSet.setId(setUID.toString());
				currGroupSet.setName(currGroupSetSettings.getName());
				for (ConsistencyGroupUID currConsistencyGroupUID : currGroupSetSettings
						.getGroupsUIDs()) {
					Long groupUID = currConsistencyGroupUID.getId();
					cgIdToGs.put(groupUID.toString(), currGroupSet);
				}
			}
		}
		return cgIdToGs;
	}

	private List<VmContainer> getNotEmptyUniqueGroupSets(
			Map<String, GroupSet> groupSets) {
		List<VmContainer> notEmptyGroupsSets = new LinkedList<VmContainer>();
		Map<String, GroupSet> visited = new HashMap<String, GroupSet>();
		for (Entry<String, GroupSet> entry : groupSets.entrySet()) {
			if (visited.get(entry.getValue().getId()) == null) {
				visited.put(entry.getValue().getId(), entry.getValue());
				if (!entry.getValue().getConsistencyGroups().isEmpty()) {
					notEmptyGroupsSets.add(entry.getValue());
				}
			}

		}
		return notEmptyGroupsSets;
	}

	private GroupCopySettings getGroupCopySettings(
			ConsistencyGroupCopyUID copyId,
			ConsistencyGroupSettings consistencyGroupSettings,
			Map<ConsistencyGroupCopyUID, String> transferStatesMap,
			Map<ConsistencyGroupCopyUID, List<CopySnapshot>> copySnapshotsMap,
			Map<ConsistencyGroupCopyUID, ConsistencyGroupCopyState> copiesStatesMap,
			Map<ConsistencyGroupCopyUID, String> initCompletionPortionsMap) {

		GroupCopySettings groupCopySettings = null;
		List<ConsistencyGroupCopySettings> allCopiesSettings = consistencyGroupSettings
				.getGroupCopiesSettings();
		for (ConsistencyGroupCopySettings currGroupCopySettings : allCopiesSettings) {
			if (currGroupCopySettings.getCopyUID().equals(copyId)) {
				Long imageAccessTimeStamp = 0L;
				groupCopySettings = new GroupCopySettings();
				groupCopySettings.setId(new Integer(copyId.getGlobalCopyUID()
						.getCopyUID()).toString());
				groupCopySettings.setName(currGroupCopySettings.getName());
				groupCopySettings.setClusterId(new Long(currGroupCopySettings
						.getCopyUID().getGlobalCopyUID().getClusterUID()
						.getId()).toString());
				
				List<CopySnapshot> allSnapshots = copySnapshotsMap
						.get(currGroupCopySettings.getCopyUID());
				
				if (currGroupCopySettings.getImageAccessInformation() != null
						&& currGroupCopySettings.getImageAccessInformation()
								.isImageAccessEnabled()) {
					
					ConsistencyGroupCopyState consistencyGroupCopyState = copiesStatesMap.get(copyId);
					//setting more detailed status for enabled image access
					if(consistencyGroupCopyState.getStorageAccessState().
							        equals(StorageAccessState.ENABLING_LOGGED_ACCESS)){
						groupCopySettings.setImageAccess(ImageAccess.ENABLING
								.value());
					}
					else{
						groupCopySettings.setImageAccess(ImageAccess.ENABLED
							.value());
					}
					imageAccessTimeStamp = currGroupCopySettings
							.getImageAccessInformation().getImageInformation()
							.getTimeStamp().getTimeInMicroSeconds();
					setSnapshotImageAccess(allSnapshots, imageAccessTimeStamp);
				} else {
					groupCopySettings.setImageAccess(ImageAccess.DISABLED
							.value());
				}
				groupCopySettings.setReplication(transferStatesMap
						.get(currGroupCopySettings.getCopyUID()));
				groupCopySettings.setInitCompletionPortion(initCompletionPortionsMap.
						  get(currGroupCopySettings.getCopyUID()));
				
				
				groupCopySettings.setSnapshots(getSnapshotsByType(allSnapshots,
						false));
				groupCopySettings.setBookmarks(getSnapshotsByType(allSnapshots,
						true));
			}
		}

		return groupCopySettings;
	}

	private void setSnapshotImageAccess(List<CopySnapshot> allSnapshots,
			Long imageAccessTimeStamp) {
		if (allSnapshots != null) {
			for (CopySnapshot currCopySnapshot : allSnapshots) {
				if (currCopySnapshot.getOriginalClosingTimeStamp().equals(
						imageAccessTimeStamp)) {
					currCopySnapshot.setImageAccessEnabled(true);
				}
			}
		}
	}

	private Map<ConsistencyGroupCopyUID, String> getGroupCopiesTransferStates(
			ConsistencyGroupStateSet consistencyGroupStateSet) {
		Map<ConsistencyGroupCopyUID, String> statesMap = new HashMap<ConsistencyGroupCopyUID, String>();
		List<ConsistencyGroupState> groupsStates = consistencyGroupStateSet
				.getInnerSet();

		for (ConsistencyGroupState currGroupState : groupsStates) {

			List<ConsistencyGroupLinkState> linksStates = currGroupState
					.getLinksState();
			for (ConsistencyGroupLinkState consistencyGroupLinkState : linksStates) {
				ConsistencyGroupUID consistencyGroupUID = consistencyGroupLinkState
						.getGroupLinkUID().getGroupUID();
				GlobalCopyUID globalCopyUID = consistencyGroupLinkState
						.getGroupLinkUID().getFirstCopy();
				ConsistencyGroupCopyUID consistencyGroupCopyUID = new ConsistencyGroupCopyUID(
						consistencyGroupUID, globalCopyUID);
				PipeState pipeState = consistencyGroupLinkState.getPipeState();
				switch (pipeState) {
				case INITIALIZING:
					statesMap.put(consistencyGroupCopyUID,
							TransferState.INITIALIZING.value());
					break;
				case ACTIVE:
					statesMap.put(consistencyGroupCopyUID,
							TransferState.ACTIVE.value());
					break;
				case STAND_BY:
					statesMap.put(consistencyGroupCopyUID,
							TransferState.STAND_BY.value());
					break;
				case READY_TO_REPLICATE:
					statesMap.put(consistencyGroupCopyUID,
							TransferState.READY_TO_REPLICATE.value());
					break;
				case PAUSED:
					statesMap.put(consistencyGroupCopyUID,
							TransferState.PAUSED.value());
					break;
				case PAUSED_BY_SYSTEM:
					statesMap.put(consistencyGroupCopyUID,
							TransferState.PAUSED_BY_SYSTEM.value());
					break;
				case ERROR:
					statesMap.put(consistencyGroupCopyUID,
							TransferState.ERROR.value());
					break;
				case UNKNOWN:
					statesMap.put(consistencyGroupCopyUID,
							TransferState.UNKNOWN.value());
					break;
				default:
					statesMap.put(consistencyGroupCopyUID,
							TransferState.UNKNOWN.value());
					break;
				}
			}
		}

		return statesMap;

	}

	private Map<ConsistencyGroupCopyUID, ConsistencyGroupCopyState> getGroupCopiesStates(
			ConsistencyGroupStateSet consistencyGroupStateSet) {
		Map<ConsistencyGroupCopyUID, ConsistencyGroupCopyState> statesMap = 
				             new HashMap<ConsistencyGroupCopyUID, ConsistencyGroupCopyState>();
		List<ConsistencyGroupState> groupsStates = consistencyGroupStateSet
				.getInnerSet();

		for (ConsistencyGroupState currGroupState : groupsStates) {			
			List<ConsistencyGroupCopyState> groupCopiesStates = currGroupState.getGroupCopiesState();			
			for(ConsistencyGroupCopyState currConsistencyGroupCopyState : groupCopiesStates){
				ConsistencyGroupCopyUID consistencyGroupCopyUID = currConsistencyGroupCopyState.getCopyUID();
				statesMap.put(consistencyGroupCopyUID, currConsistencyGroupCopyState);
			}

		}	

		return statesMap;

	}

	

	private Map<String, Long> getGroupVolumesMaxSizes(Client client) {
		Map<String, Long> volumesMaxSizes = new HashMap<String, Long>();
		ConsistencyGroupVolumesStateSet volumesStateSet = client
				.getConsistencyGroupVolumesStateSet();
		List<ConsistencyGroupVolumesState> volumesStates = volumesStateSet
				.getInnerSet();
		for (ConsistencyGroupVolumesState consistencyGroupVolumesState : volumesStates) {
			Long groupId = consistencyGroupVolumesState.getGroupUID().getId();
			List<ReplicationSetVolumesState> replicationSetVolumesState = consistencyGroupVolumesState
					.getReplicationSetsVolumesState();
			long totalVolumeSize = 0;
			for (ReplicationSetVolumesState volumeState : replicationSetVolumesState) {
				totalVolumeSize += volumeState.getMaxPossibleSizeInBytes();
			}
			Long totalVolumeSizeGB = totalVolumeSize / 1000 / 1000 / 1000;
			volumesMaxSizes.put(groupId.toString(), totalVolumeSizeGB);
		}
		return volumesMaxSizes;
	}

	private Map<ConsistencyGroupCopyUID, List<CopySnapshot>> getGroupCopiesSnapshots(
			Client client, Long groupId) {
		Map<ConsistencyGroupCopyUID, List<CopySnapshot>> copyUIDToSnapshotsMap = new HashMap<ConsistencyGroupCopyUID, List<CopySnapshot>>();
		ConsistencyGroupSnapshots consistencyGroupSnapshots = client
				.getGroupSnapshots(groupId);
		List<ConsistencyGroupCopySnapshots> copiesSnapshots = consistencyGroupSnapshots
				.getCopiesSnapshots();

		for (ConsistencyGroupCopySnapshots currCopy : copiesSnapshots) {
			ConsistencyGroupCopyUID copyUID = currCopy.getCopyUID();
			List<Snapshot> snapshots = currCopy.getSnapshots();
			List<CopySnapshot> snapshotsList = new LinkedList<CopySnapshot>();
			int maxSnapshots = 50;
			int currSnapshotCounter = 0;
			for (Snapshot currSnapshot : snapshots) {
				if (currSnapshotCounter < maxSnapshots
						|| (currSnapshot.getRelevantEvent() != null && !StringUtils
								.isEmpty(currSnapshot.getRelevantEvent()
										.getDetails()))) {
					RecoverPointTimeStamp timestamp = currSnapshot
							.getClosingTimeStamp();
					SimpleDateFormat dateFormat = new SimpleDateFormat(
							"MM/dd/yyyy hh:mm:ss a");
					String dateStr = dateFormat.format(new Date(timestamp
							.getTimeInMicroSeconds() / 1000));
					SnapshotUID snapshotUID = currSnapshot.getSnapshotUID();
					CopySnapshot snapshot = new CopySnapshot();
					snapshot.setId(snapshotUID.getId());
					snapshot.setClosingTimestamp(dateStr);
					snapshot.setOriginalClosingTimeStamp(timestamp
							.getTimeInMicroSeconds());
					if (currSnapshot.getRelevantEvent() != null &&
							!StringUtils.contains(currSnapshot.getRelevantEvent()
									.getDetails(), "GUID")) {
						snapshot.setName(currSnapshot.getRelevantEvent()
								.getDetails());
					}
					ConsistencyType consistencyType = getConsistencyType(currSnapshot.getConsistencyType());
					snapshot.setConsistencyType(consistencyType.value());
			
					snapshotsList.add(snapshot);
				}
				currSnapshotCounter++;
			}
			copyUIDToSnapshotsMap.put(copyUID, snapshotsList);
		}
		return copyUIDToSnapshotsMap;

	}
	
	private ConsistencyType getConsistencyType(SnapshotConsistencyType snapshotConsistencyType){
		ConsistencyType res = null;
		switch (snapshotConsistencyType) {
		case APPLICATION_CONSISTENT:
			res = ConsistencyType.APPLICATION_CONSISTENT_SHORTCUT;
			break;
		/*case CONSISTENCY_UNKNOWN:
		case UNKNOWN:
			res = ConsistencyType.UNKNOWN;
			break;*/
		default:
			res = ConsistencyType.CRASH_CONSISTENT_SHORTCUT;
			break;
		}
		return res;
	}

	private List<CopySnapshot> getSnapshotsByType(List<CopySnapshot> snapshots,
			boolean isBookmark) {
		List<CopySnapshot> res = new LinkedList<CopySnapshot>();
		if (snapshots != null) {
			for (CopySnapshot currSnapshot : snapshots) {
				if (isBookmark) {
					if (!StringUtils.isEmpty(currSnapshot.getName())) {
						res.add(currSnapshot);
					}
				} else {
					if (StringUtils.isEmpty(currSnapshot.getName())) {
						res.add(currSnapshot);
					}
				}
			}
		}
		return res;
	}
	
	private Map<ConsistencyGroupCopyUID, String> getInitCompletionPortion(Client client){
		ConsistencyGroupStatisticsSet consistencyGroupStatisticsSet = client.getGroupStatistics();
		Map<ConsistencyGroupCopyUID, String> completionPortionsMap = new HashMap<ConsistencyGroupCopyUID, String>();
		List<ConsistencyGroupStatistics> groupsStatistics = consistencyGroupStatisticsSet.getInnerSet();
		for(ConsistencyGroupStatistics currGroupStatistics : groupsStatistics){
			List<ConsistencyGroupLinkStatistics> linkStatistics = currGroupStatistics.getConsistencyGroupLinkStatistics();
			for(ConsistencyGroupLinkStatistics currLinkStatistics : linkStatistics){
				ConsistencyGroupLinkUID linkUID = currLinkStatistics.getLinkUID();
				ConsistencyGroupCopyUID consistencyGroupCopyUID = new ConsistencyGroupCopyUID();
				consistencyGroupCopyUID.setGroupUID(linkUID.getGroupUID());
				consistencyGroupCopyUID.setGlobalCopyUID(linkUID.getFirstCopy());
				Double initCompletionValue = new Double(currLinkStatistics.getInitStatistics().getInitCompletionPortion()*100);
				String initCompletionValueStr = new Integer(initCompletionValue.intValue()).toString();
				completionPortionsMap.put(consistencyGroupCopyUID, initCompletionValueStr);
			}
		}
		return completionPortionsMap;
	}

}
