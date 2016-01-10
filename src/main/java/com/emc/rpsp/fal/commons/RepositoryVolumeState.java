package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@XmlRootElement

@JsonTypeName("RepositoryVolumeState")
@XmlType(name = "RepositoryVolumeState")
public class RepositoryVolumeState extends VolumeState {

    public RepositoryVolumeState() {
    }

    public RepositoryVolumeState(ClusterUID clusterUID, DeviceUID volumeID, HashSet<VolumeRPAAccessStatus> rpasAccessStatus) {
        super(VolumeType.REPOSITORY, clusterUID, volumeID, rpasAccessStatus);
    }

    public RepositoryVolumeState(VolumeType type, ClusterUID clusterUID, DeviceUID volumeID, HashSet<VolumeRPAAccessStatus> rpasAccessStatus) {
        this(clusterUID, volumeID, rpasAccessStatus);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append("RepositoryVolumeState [super=").append(super.toString()).append("]");
        return builder.toString();
    }
}
