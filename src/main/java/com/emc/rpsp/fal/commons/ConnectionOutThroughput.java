package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "ConnectionOutThroughput")
public class ConnectionOutThroughput {

    private ClusterUID cluster;
    private long outThroughput;

    public ConnectionOutThroughput() {
    }

    public ConnectionOutThroughput(ClusterUID cluster, long outThroughput) {
        this.cluster = cluster;
        this.outThroughput = outThroughput;
    }

    public ClusterUID getCluster() {
        return cluster;
    }

    public void setCluster(ClusterUID cluster) {
        this.cluster = cluster;
    }

    public long getOutThroughput() {
        return outThroughput;
    }

    public void setOutThroughput(long outThroughput) {
        this.outThroughput = outThroughput;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cluster == null) ? 0 : cluster.hashCode());
        result = prime * result
            + (int) (outThroughput ^ (outThroughput >>> 32));
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
        ConnectionOutThroughput other = (ConnectionOutThroughput) obj;
        if (cluster == null) {
            if (other.cluster != null)
                return false;
        } else if (!cluster.equals(other.cluster))
            return false;
        if (outThroughput != other.outThroughput)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ConnectionOutThroughput [cluster=").append(cluster)
            .append(", outThroughput=").append(outThroughput).append("]");
        return builder.toString();
    }

}
