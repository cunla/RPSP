package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement

@JsonTypeName("VCenterServerViewContext")
@XmlType(name = "VCenterServerViewContext")
public class VCenterServerViewContext extends FunctionalAPIContext {

    private ClusterUID cluster;

    public VCenterServerViewContext() {
    }

    public VCenterServerViewContext(long globalContext, ClusterUID cluster) {
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
        VCenterServerViewContext other = (VCenterServerViewContext) obj;
        if (cluster == null) {
            if (other.cluster != null)
                return false;
        } else if (!cluster.equals(other.cluster))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("VCenterServerViewContext [cluster=").append(cluster).append(
            ", super=").append(super.toString()).append("]");
        return builder.toString();
    }
}
