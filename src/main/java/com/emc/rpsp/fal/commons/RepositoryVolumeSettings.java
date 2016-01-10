package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement

@JsonTypeName("RepositoryVolumeSettings")
@XmlType(name = "RepositoryVolumeSettings")
public class RepositoryVolumeSettings extends VolumeSettings {

    public RepositoryVolumeSettings() {
    }

    public RepositoryVolumeSettings(ClusterUID clusterUID, VolumeInformation volumeInfo) {
        super(VolumeType.REPOSITORY, clusterUID, volumeInfo);
    }

    public RepositoryVolumeSettings(VolumeType type, ClusterUID clusterUID, VolumeInformation volumeInfo) {
        this(clusterUID, volumeInfo);
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
        builder.append("RepositoryVolumeSettings [super=").append(super.toString()).append("]");
        return builder.toString();
    }
}
