package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "ConnectionCompressionRatio")
public class ConnectionCompressionRatio {

    private ClusterUID cluster;
    private double compressionRatio;

    public ConnectionCompressionRatio() {
    }

    public ConnectionCompressionRatio(ClusterUID cluster, double compressionRatio) {
        this.cluster = cluster;
        this.compressionRatio = compressionRatio;
    }

    public ClusterUID getCluster() {
        return cluster;
    }

    public void setCluster(ClusterUID cluster) {
        this.cluster = cluster;
    }

    public double getCompressionRatio() {
        return compressionRatio;
    }

    public void setCompressionRatio(double compressionRatio) {
        this.compressionRatio = compressionRatio;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cluster == null) ? 0 : cluster.hashCode());
        long temp;
        temp = Double.doubleToLongBits(compressionRatio);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        ConnectionCompressionRatio other = (ConnectionCompressionRatio) obj;
        if (cluster == null) {
            if (other.cluster != null)
                return false;
        } else if (!cluster.equals(other.cluster))
            return false;
        if (Double.doubleToLongBits(compressionRatio) != Double
            .doubleToLongBits(other.compressionRatio))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ConnectionCompressionRatio [cluster=").append(cluster)
            .append(", compressionRatio=").append(compressionRatio)
            .append("]");
        return builder.toString();
    }


}
