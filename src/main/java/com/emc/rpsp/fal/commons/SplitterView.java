package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.LinkedList;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SplitterView")
public class SplitterView {

    @XmlElement(nillable = true)
    private SplitterInfo splitterInfo;
    private LinkedList<ConsistencyGroupCopyInfo> groupCopies;
    private LinkedList<DeviceInfo> volumes;

    public SplitterView() {
    }

    public SplitterView(SplitterInfo splitterInfo, LinkedList<ConsistencyGroupCopyInfo> groupCopies, LinkedList<DeviceInfo> volumes) {
        this.splitterInfo = splitterInfo;
        this.groupCopies = groupCopies;
        this.volumes = volumes;
    }

    public SplitterInfo getSplitterInfo() {
        return splitterInfo;
    }

    public void setSplitterInfo(SplitterInfo splitterInfo) {
        this.splitterInfo = splitterInfo;
    }

    public LinkedList<ConsistencyGroupCopyInfo> getGroupCopies() {
        return groupCopies;
    }

    public void setGroupCopies(LinkedList<ConsistencyGroupCopyInfo> groupCopies) {
        this.groupCopies = groupCopies;
    }

    public LinkedList<DeviceInfo> getVolumes() {
        return volumes;
    }

    public void setVolumes(LinkedList<DeviceInfo> volumes) {
        this.volumes = volumes;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((groupCopies == null) ? 0 : groupCopies.hashCode());
        result = prime * result
            + ((splitterInfo == null) ? 0 : splitterInfo.hashCode());
        result = prime * result + ((volumes == null) ? 0 : volumes.hashCode());
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
        SplitterView other = (SplitterView) obj;
        if (groupCopies == null) {
            if (other.groupCopies != null)
                return false;
        } else if (!groupCopies.equals(other.groupCopies))
            return false;
        if (splitterInfo == null) {
            if (other.splitterInfo != null)
                return false;
        } else if (!splitterInfo.equals(other.splitterInfo))
            return false;
        if (volumes == null) {
            if (other.volumes != null)
                return false;
        } else if (!volumes.equals(other.volumes))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SplitterView [groupCopies=").append(groupCopies)
            .append(", splitterInfo=").append(splitterInfo).append(
            ", volumes=").append(volumes).append("]");
        return builder.toString();
    }
}
