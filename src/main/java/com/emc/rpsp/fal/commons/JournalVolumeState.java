package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@XmlRootElement

@JsonTypeName("JournalVolumeState")
@XmlType(name = "JournalVolumeState")
public class JournalVolumeState extends VolumeState {

    private ConsistencyGroupCopyUID groupCopyUID;

    public JournalVolumeState() {
    }

    public JournalVolumeState(ConsistencyGroupCopyUID groupCopyUID, DeviceUID volumeID, HashSet<VolumeRPAAccessStatus> rpasAccessStatus) {
        super(VolumeType.JOURNAL, groupCopyUID.getGlobalCopyUID().getClusterUID(), volumeID, rpasAccessStatus);
        this.groupCopyUID = groupCopyUID;
    }

    public JournalVolumeState(VolumeType type, ClusterUID clusterUID, ConsistencyGroupCopyUID groupCopyUID, DeviceUID volumeID, HashSet<VolumeRPAAccessStatus> rpasAccessStatus) {
        super(VolumeType.JOURNAL, groupCopyUID.getGlobalCopyUID().getClusterUID(), volumeID, rpasAccessStatus);
        this.groupCopyUID = groupCopyUID;
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
        JournalVolumeState other = (JournalVolumeState) obj;
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
        builder.append(super.toString());
        builder.append("JournalVolumeState [groupCopyUID=")
            .append(groupCopyUID).append(", super=").append(super.toString()).append("]");
        return builder.toString();
    }
}
