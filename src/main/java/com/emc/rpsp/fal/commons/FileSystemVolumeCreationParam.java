package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@SuppressWarnings("serial")
@XmlRootElement
@XmlType(name = "FileSystemVolumeCreationParam")
public class FileSystemVolumeCreationParam implements Validateable {

    private HashSet<ReplicaFileSystemCreationParam> replicaFileSystemCreationInfo;
    private DefaultDataMoverParam defaultDataMover;

    public FileSystemVolumeCreationParam() {
    }

    public FileSystemVolumeCreationParam(HashSet<ReplicaFileSystemCreationParam> replicaFileSystemCreationInfo, DefaultDataMoverParam defaultDataMover) {
        this.replicaFileSystemCreationInfo = replicaFileSystemCreationInfo;
        this.defaultDataMover = defaultDataMover;
    }

    public HashSet<ReplicaFileSystemCreationParam> getReplicaFileSystemCreationInfo() {
        return replicaFileSystemCreationInfo;
    }

    public void setReplicaFileSystemCreationInfo(
        HashSet<ReplicaFileSystemCreationParam> replicaFileSystemCreationInfo) {
        this.replicaFileSystemCreationInfo = replicaFileSystemCreationInfo;
    }

    public DefaultDataMoverParam getDefaultDataMover() {
        return defaultDataMover;
    }

    public void setDefaultDataMover(DefaultDataMoverParam defaultDataMover) {
        this.defaultDataMover = defaultDataMover;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((defaultDataMover == null) ? 0 : defaultDataMover
            .hashCode());
        result = prime
            * result
            + ((replicaFileSystemCreationInfo == null) ? 0
            : replicaFileSystemCreationInfo.hashCode());
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
        FileSystemVolumeCreationParam other = (FileSystemVolumeCreationParam) obj;
        if (defaultDataMover == null) {
            if (other.defaultDataMover != null)
                return false;
        } else if (!defaultDataMover.equals(other.defaultDataMover))
            return false;
        if (replicaFileSystemCreationInfo == null) {
            if (other.replicaFileSystemCreationInfo != null)
                return false;
        } else if (!replicaFileSystemCreationInfo
            .equals(other.replicaFileSystemCreationInfo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(
            "FileSystemVolumeCreationParam [replicaFileSystemCreationInfo=")
            .append(replicaFileSystemCreationInfo)
            .append(", defaultDataMover=").append(defaultDataMover)
            .append("]");
        return builder.toString();
    }

}
