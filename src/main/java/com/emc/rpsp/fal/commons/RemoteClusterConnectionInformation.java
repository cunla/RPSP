package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RemoteClusterConnectionInformation")
public class RemoteClusterConnectionInformation {

    private ClusterUID cluster;
    @XmlElement(nillable = true)
    private ConnectionType connectionType;

    public RemoteClusterConnectionInformation() {
    }

    public RemoteClusterConnectionInformation(ClusterUID cluster,
                                              ConnectionType connectionType) {
        super();
        this.cluster = cluster;
        this.connectionType = connectionType;
    }

    public ClusterUID getCluster() {
        return cluster;
    }

    public void setCluster(ClusterUID cluster) {
        this.cluster = cluster;
    }

    public ConnectionType getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(ConnectionType connectionType) {
        this.connectionType = connectionType;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((connectionType == null) ? 0 : connectionType.hashCode());
        result = prime * result + ((cluster == null) ? 0 : cluster.hashCode());
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
        RemoteClusterConnectionInformation other = (RemoteClusterConnectionInformation) obj;
        if (connectionType != other.connectionType)
            return false;
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
        builder.append("RemoteConnectionInformation [cluster=").append(cluster)
            .append(", connectionType=").append(connectionType).append("]");
        return builder.toString();
    }


}
