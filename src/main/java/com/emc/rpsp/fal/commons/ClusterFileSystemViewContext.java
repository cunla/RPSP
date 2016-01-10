package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement

@JsonTypeName("ClusterFileSystemViewContext")
@XmlType(name = "ClusterFileSystemViewContext")
public class ClusterFileSystemViewContext extends FunctionalAPIContext {

    private ClusterUID cluster;

    public ClusterFileSystemViewContext() {
    }

    public ClusterFileSystemViewContext(long globalContext, ClusterUID cluster) {
        super(globalContext);
        this.cluster = cluster;
    }

    public ClusterUID getCluster() {
        return cluster;
    }

    public void setCluster(ClusterUID cluster) {
        this.cluster = cluster;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ClusterFileSystemViewContext [cluster=").append(cluster).append(", super=").append(super.toString()).append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((cluster == null) ? 0 : cluster.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        ClusterFileSystemViewContext other = (ClusterFileSystemViewContext) obj;
        if (cluster == null) {
            if (other.cluster != null)
                return false;
        } else if (!cluster.equals(other.cluster))
            return false;
        return true;
    }
}
