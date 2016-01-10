package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReplicaFileSystemCreationParam")
public class ReplicaFileSystemCreationParam implements Validateable {

    @XmlElement(required = true)
    private ConsistencyGroupCopyUID targetCopyUID;
    @XmlElement(required = true)
    private String defaultDataMover;
    @XmlElement(required = true)
    private String storagePool;

    public ReplicaFileSystemCreationParam() {
    }

    public ReplicaFileSystemCreationParam(ConsistencyGroupCopyUID targetCopyUID, String defaultDataMover, String storagePool) {
        this.targetCopyUID = targetCopyUID;
        this.defaultDataMover = defaultDataMover;
        this.storagePool = storagePool;
    }

    public ConsistencyGroupCopyUID getTargetCopyUID() {
        return targetCopyUID;
    }

    public void setTargetCopyUID(ConsistencyGroupCopyUID targetCopyUID) {
        this.targetCopyUID = targetCopyUID;
    }

    public String getDefaultDataMover() {
        return defaultDataMover;
    }

    public void setDefaultDataMover(String defaultDataMover) {
        this.defaultDataMover = defaultDataMover;
    }

    public String getStoragePool() {
        return storagePool;
    }

    public void setStoragePool(String storagePool) {
        this.storagePool = storagePool;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((defaultDataMover == null) ? 0 : defaultDataMover.hashCode());
        result = prime * result
            + ((storagePool == null) ? 0 : storagePool.hashCode());
        result = prime * result
            + ((targetCopyUID == null) ? 0 : targetCopyUID.hashCode());
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
        ReplicaFileSystemCreationParam other = (ReplicaFileSystemCreationParam) obj;
        if (defaultDataMover == null) {
            if (other.defaultDataMover != null)
                return false;
        } else if (!defaultDataMover.equals(other.defaultDataMover))
            return false;
        if (storagePool == null) {
            if (other.storagePool != null)
                return false;
        } else if (!storagePool.equals(other.storagePool))
            return false;
        if (targetCopyUID == null) {
            if (other.targetCopyUID != null)
                return false;
        } else if (!targetCopyUID.equals(other.targetCopyUID))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ReplicaFileSystemCreationParam [targetCopyUID=")
            .append(targetCopyUID).append(", defaultDataMover=")
            .append(defaultDataMover).append(", storagePool=")
            .append(storagePool).append("]");
        return builder.toString();
    }

}
