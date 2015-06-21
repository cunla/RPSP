package com.emc.rpsp.vmstructure.domain;

import java.util.List;

public class ConsistencyGroup implements VmContainer {

    private String id;
    private String name;
    private Long maxVolumeSize;
    private List<VmDefinition> vms;
    private ClusterDefinition productionCluster;
    private List<ClusterDefinition> replicaClusters;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<VmDefinition> getVms() {
        return vms;
    }

    public void setVms(List<VmDefinition> vms) {
        this.vms = vms;
    }

    public ClusterDefinition getProductionCluster() {
        return productionCluster;
    }

    public void setProductionCluster(ClusterDefinition productionCluster) {
        this.productionCluster = productionCluster;
    }

    public List<ClusterDefinition> getReplicaClusters() {
        return replicaClusters;
    }

    public void setReplicaClusters(List<ClusterDefinition> replicaClusters) {
        this.replicaClusters = replicaClusters;
    }

    @Override public String getType() {
        return "cg";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getMaxVolumeSize() {
        return maxVolumeSize;
    }

    public void setMaxVolumeSize(Long maxVolumeSize) {
        this.maxVolumeSize = maxVolumeSize;
    }

}
