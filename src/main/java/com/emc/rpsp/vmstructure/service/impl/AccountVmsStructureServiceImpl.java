package com.emc.rpsp.vmstructure.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.emc.rpsp.vmstructure.domain.AccountVmsStructure;
import com.emc.rpsp.vmstructure.domain.ClusterDefinition;
import com.emc.rpsp.vmstructure.domain.ConsistencyGroup;
import com.emc.rpsp.vmstructure.domain.GroupSet;
import com.emc.rpsp.vmstructure.domain.VmContainer;
import com.emc.rpsp.vmstructure.domain.VmDefinition;
import com.emc.rpsp.vmstructure.service.AccountVmsStructureService;

@Service
public class AccountVmsStructureServiceImpl implements
        AccountVmsStructureService {

	@Override
	public AccountVmsStructure getAccountVmsStrucure(String accountId) {
		AccountVmsStructure accountVmsStructure = getMockupData();
		return accountVmsStructure;
	}

	private AccountVmsStructure getMockupData() {

		// *************** create gs1 ***************
		GroupSet groupSet1 = new GroupSet();
		groupSet1.setName("Group Set1");

		// cg1
		ConsistencyGroup consistencyGroup1 = new ConsistencyGroup();
		consistencyGroup1.setName("Consistency Group1");

		// vms list
		List<VmDefinition> vmsList1 = new LinkedList<VmDefinition>();
		VmDefinition vm1 = new VmDefinition("1", "vm1");
		VmDefinition vm2 = new VmDefinition("2", "vm2");
		vmsList1.add(vm1);
		vmsList1.add(vm2);
		consistencyGroup1.setVms(vmsList1);

		// production cluster
		ClusterDefinition clusterDefinition1 = new ClusterDefinition("1",
		        "London");
		consistencyGroup1.setProductionCluster(clusterDefinition1);

		// replica clusters
		List<ClusterDefinition> replicaList1 = new LinkedList<ClusterDefinition>();
		ClusterDefinition clusterDefinition2 = new ClusterDefinition("2", "NY");
		ClusterDefinition clusterDefinition3 = new ClusterDefinition("3",
		        "Paris");
		replicaList1.add(clusterDefinition2);
		replicaList1.add(clusterDefinition3);
		consistencyGroup1.setReplicaClusters(replicaList1);

		groupSet1.addConsistencyGroup(consistencyGroup1);

		// *************** create cg2 ***************
		ConsistencyGroup consistencyGroup2 = new ConsistencyGroup();
		consistencyGroup2.setName("Consistency Group2");

		// vms list
		List<VmDefinition> vmsList2 = new LinkedList<VmDefinition>();
		VmDefinition vm3 = new VmDefinition("3", "vm3");
		VmDefinition vm4 = new VmDefinition("4", "vm4");
		vmsList2.add(vm3);
		vmsList2.add(vm4);
		consistencyGroup2.setVms(vmsList2);

		// production cluster
		ClusterDefinition clusterDefinition4 = new ClusterDefinition("4",
		        "Tel Aviv");
		consistencyGroup2.setProductionCluster(clusterDefinition4);

		// replica clusters
		List<ClusterDefinition> replicaList2 = new LinkedList<ClusterDefinition>();
		ClusterDefinition clusterDefinition5 = new ClusterDefinition("5",
		        "Jerusalem");
		;
		replicaList2.add(clusterDefinition5);
		consistencyGroup2.setReplicaClusters(replicaList2);

		// *************** create the list of unprotected vms ***************
		List<VmDefinition> vmsList3 = new LinkedList<VmDefinition>();
		VmDefinition vm5 = new VmDefinition("5", "vm5");
		VmDefinition vm6 = new VmDefinition("6", "vm6");
		VmDefinition vm7 = new VmDefinition("7", "vm7");
		VmDefinition vm8 = new VmDefinition("8", "vm8");
		vmsList3.add(vm5);
		vmsList3.add(vm6);
		vmsList3.add(vm7);
		vmsList3.add(vm8);

		// *************** create the account vms structure ***************
		AccountVmsStructure accountVmsStructure = new AccountVmsStructure();
		List<VmContainer> protectedVmsList = new LinkedList<VmContainer>();
		protectedVmsList.add(groupSet1);
		protectedVmsList.add(consistencyGroup2);
		accountVmsStructure.setProtectedVms(protectedVmsList);
		accountVmsStructure.setUnprotectedVms(vmsList3);

		return accountVmsStructure;

	}

}
