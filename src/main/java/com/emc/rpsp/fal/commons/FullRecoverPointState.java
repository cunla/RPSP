package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FullRecoverPointState")
////@LargeObject
public class FullRecoverPointState {

    private HashSet<ConsistencyGroupState> groupsState;
    private HashSet<ConsistencyGroupVolumesState> groupsVolumesState;
    private HashSet<ClusterSplittersState> splittersState;
    private HashSet<ClusterArrayManagementProvidersState> arrayManagementProvidersState;
    private HashSet<ClusterRPAsState> rpasState;
    @XmlElement(nillable = true)
    private AccountState accountState;
    private HashSet<RepositoryVolumeState> repositoriesState;
    private HashSet<PhoenixClusterState> clustersPhoenixClustersState;
    @XmlElement(nillable = true)
    private MonitoredParametersStatus monitoredParametersStatus;
    private boolean internalConfigParamsConflict;
    private HashSet<GlobalLinkState> linksState;
    @XmlElement(nillable = true)
    private SystemVersionState systemVersionState;
    private HashSet<ClusterVirtualInfrastructuresState> virtualInfrastructuresState;
    private HashSet<VirtualCenterProtectedVmCountState> protectedVMsCount;
}
