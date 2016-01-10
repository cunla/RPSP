package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement

@JsonTypeName("JournalVolumeSettings")
@XmlType(name = "JournalVolumeSettings")
public class JournalVolumeSettings extends VolumeSettings {

    private ConsistencyGroupCopyUID groupCopyUID;

    public JournalVolumeSettings() {
    }

    public JournalVolumeSettings(ConsistencyGroupCopyUID groupCopyUID,
                                 VolumeInformation volumeInformation) {
        super(VolumeType.JOURNAL, groupCopyUID.getGlobalCopyUID().getClusterUID(), volumeInformation);
        this.groupCopyUID = groupCopyUID;
    }

    public JournalVolumeSettings(VolumeType type, ClusterUID clusterUID, VolumeInformation volumeInfo, ConsistencyGroupCopyUID groupCopyUID) {
        this(groupCopyUID, volumeInfo);
    }

    public ConsistencyGroupCopyUID getGroupCopyUID() {
        return groupCopyUID;
    }

    public void setGroupCopyUID(ConsistencyGroupCopyUID groupCopyUID) {
        this.groupCopyUID = groupCopyUID;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
            + ((groupCopyUID == null) ? 0 : groupCopyUID.hashCode());
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
        JournalVolumeSettings other = (JournalVolumeSettings) obj;
        if (groupCopyUID == null) {
            if (other.groupCopyUID != null)
                return false;
        } else if (!groupCopyUID.equals(other.groupCopyUID))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("JournalVolumeSettings [groupCopyUID=").append(
            groupCopyUID).append(", super=").append(super.toString()).append("]");
        return builder.toString();
    }
}
