package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "PhoenixClusterState")
public class PhoenixClusterState {

    private ClusterUID cluster;
    private String clusterName;
    private long diskCapacity;
    private Long availableDisk;
    private PhoenixClusterStatus status;

    public PhoenixClusterState() {
    }

    public PhoenixClusterState(ClusterUID cluster, String clusterName, long diskCapacity, Long availableDisk, PhoenixClusterStatus status) {
        this.cluster = cluster;
        this.clusterName = clusterName;
        this.diskCapacity = diskCapacity;
        this.availableDisk = availableDisk;
        this.status = status;
    }

    public ClusterUID getCluster() {
        return cluster;
    }

    public void setCluster(ClusterUID cluster) {
        this.cluster = cluster;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public long getDiskCapacity() {
        return diskCapacity;
    }

    public void setDiskCapacity(long diskCapacity) {
        this.diskCapacity = diskCapacity;
    }

    public Long getAvailableDisk() {
        return availableDisk;
    }

    public void setAvailableDisk(Long availableDisk) {
        this.availableDisk = availableDisk;
    }

    public PhoenixClusterStatus getStatus() {
        return status;
    }

    public void setStatus(PhoenixClusterStatus status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((availableDisk == null) ? 0 : availableDisk.hashCode());
        result = prime * result
            + ((clusterName == null) ? 0 : clusterName.hashCode());
        result = prime * result + (int) (diskCapacity ^ (diskCapacity >>> 32));
        result = prime * result + ((cluster == null) ? 0 : cluster.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PhoenixClusterState other = (PhoenixClusterState) obj;
        if (availableDisk == null) {
            if (other.availableDisk != null)
                return false;
        } else if (!availableDisk.equals(other.availableDisk))
            return false;
        if (clusterName == null) {
            if (other.clusterName != null)
                return false;
        } else if (!clusterName.equals(other.clusterName))
            return false;
        if (diskCapacity != other.diskCapacity)
            return false;
        if (cluster == null) {
            if (other.cluster != null)
                return false;
        } else if (!cluster.equals(other.cluster))
            return false;
        if (status == null) {
            if (other.status != null)
                return false;
        } else if (!status.equals(other.status))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PhoenixClusterState [availableDisk=").append(
            availableDisk).append(", clusterName=").append(clusterName)
            .append(", diskCapacity=").append(diskCapacity).append(
            ", cluster=").append(cluster).append(", status=").append(
            status).append("]");
        return builder.toString();
    }
}
