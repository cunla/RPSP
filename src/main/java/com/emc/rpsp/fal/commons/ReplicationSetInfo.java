package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReplicationSetInfo")
public class ReplicationSetInfo {

    @XmlElement(nillable = true)
    private ReplicationSetUID replicationSetUID;
    private String replicationSetName;

    public ReplicationSetInfo() {
    }

    public ReplicationSetInfo(ReplicationSetUID replicationSetUID, String replicationSetName) {
        this.replicationSetUID = replicationSetUID;
        this.replicationSetName = replicationSetName;
    }

    public ReplicationSetUID getReplicationSetUID() {
        return replicationSetUID;
    }

    public void setReplicationSetUID(ReplicationSetUID replicationSetUID) {
        this.replicationSetUID = replicationSetUID;
    }

    public String getReplicationSetName() {
        return replicationSetName;
    }

    public void setReplicationSetName(String replicationSetName) {
        this.replicationSetName = replicationSetName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((replicationSetName == null) ? 0 : replicationSetName
            .hashCode());
        result = prime
            * result
            + ((replicationSetUID == null) ? 0 : replicationSetUID
            .hashCode());
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
        ReplicationSetInfo other = (ReplicationSetInfo) obj;
        if (replicationSetName == null) {
            if (other.replicationSetName != null)
                return false;
        } else if (!replicationSetName.equals(other.replicationSetName))
            return false;
        if (replicationSetUID == null) {
            if (other.replicationSetUID != null)
                return false;
        } else if (!replicationSetUID.equals(other.replicationSetUID))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ReplicationSetInfo [replicationSetName=").append(
            replicationSetName).append(", replicationSetUID=").append(
            replicationSetUID).append("]");
        return builder.toString();
    }
}
