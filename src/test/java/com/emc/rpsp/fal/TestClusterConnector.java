package com.emc.rpsp.fal;

import com.emc.fapi.jaxws.*;
import com.emc.rpsp.domain.SystemSettings;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by morand3 on 1/13/2015.
 */
public class TestClusterConnector {
	private static SystemSettings systemSettings = new SystemSettings(
			"10.76.16.150", "admin", "admin");

	// private static ClusterSettings clusterSettings = new
	// ClusterSettings("10.64.125.226", "admin", "admin", "Israel");

	@Test
	public void testClusterGetTime() {
		ClusterConnector connector = ClusterConnectorFactory
				.getConnector(systemSettings);
		long time = connector.getSystemTime().getTimeInMicroSeconds();
		DateTime d = new DateTime(time / 1000);
		System.out.println("Time on the server: " + d);
	}

	@Test
	public void testClusterGetVms() {
		ClusterConnector connector = ClusterConnectorFactory
				.getConnector(systemSettings);
		FullRecoverPointSettings rpSettings = connector
				.getFullRecoverPointSettings();
		assertNotNull(rpSettings);
		List<ConsistencyGroupSettings> groupSettingsList = rpSettings
				.getGroupsSettings();
		assertNotNull(groupSettingsList);
		for (ConsistencyGroupSettings groupSettings : groupSettingsList) {
			List<ConsistencyGroupCopyUID> productionCopies = groupSettings
					.getProductionCopiesUID();
			assertTrue(productionCopies.size() > 0);
			for (ConsistencyGroupCopyUID productionCopy : productionCopies) {
				int copyId = productionCopy.getGlobalCopyUID().getCopyUID();
				long clusterId = productionCopy.getGlobalCopyUID()
						.getClusterUID().getId();
				System.out.println(
						String.format("Found copy %d in cluster %d", copyId,
								clusterId));
			}
			List<VmReplicationSetSettings> vmReplicationSetSettingsList = groupSettings
					.getVmReplicationSetsSettings();
			for (VmReplicationSetSettings replicationSetSettings : vmReplicationSetSettingsList) {
				List<VmReplicationSettings> vms = replicationSetSettings
						.getReplicatedVMs();
				for (VmReplicationSettings vm : vms) {
					String vmId = vm.getVmUID().getUuid();
					String vCenterId = vm.getVmUID().getVirtualCenterUID()
							.getUuid();
					int copyId = vm.getGroupCopyUID().getGlobalCopyUID()
							.getCopyUID();
					long clusterId = vm.getGroupCopyUID().getGlobalCopyUID()
							.getClusterUID().getId();
					System.out.println(String.format(
							"VM %s in vCenter %s is under copy %d in cluster %d",
							vmId, vCenterId, copyId, clusterId));
				}
			}
		}
	}

	@Test
	public void testgetClusterVirtualInfrastructuresStateSet() {
		ClusterConnector connector = ClusterConnectorFactory
				.getConnector(systemSettings);
		ClusterVirtualInfrastructuresStateSet stateSet = connector
				.getVirtualInfrastructuresStateFromAllCluster();
		for (ClusterVirtualInfrastructuresState state : stateSet
				.getInnerSet()) {
			List<VmState> vmStateList = state.getVirtualInfrastructuresState()
					.getVmsState();
			long clusterId = state.getClusterUID().getId();
			for (VmState vmState : vmStateList) {
				String vmId = vmState.getVmUID().getUuid();
				String vmName = vmState.getName();
				System.out.println(
						String.format("VM %s in cluster %d has name %s", vmId,
								clusterId, vmName));
			}
		}
	}

	@Test
	public void testGetClusterVirtualInfrastructuresStateForCluster() {
		ClusterConnector connector = ClusterConnectorFactory
				.getConnector(systemSettings);
		RecoverPointClustersInformation rpClusters = connector
				.getRpClustersInformation();
		for (ClusterInfo clusterInfo : rpClusters.getClustersInformation()) {
			ClusterVirtualInfrastructuresState state = connector
					.getVirtualInfrastructuresStateFromCluster(
							clusterInfo.getClusterUID().getId());
			List<VmState> vmStateList = state.getVirtualInfrastructuresState()
					.getVmsState();
			long clusterId = state.getClusterUID().getId();
			for (VmState vmState : vmStateList) {
				String vmId = vmState.getVmUID().getUuid();
				String vmName = vmState.getName();
				System.out.println(
						String.format("VM %s in cluster %d has name %s", vmId,
								clusterId, vmName));
			}
		}
	}
}
