package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "ConsistencyGroupLinkInfo")
public class ConsistencyGroupLinkInfo {

    private ConsistencyGroupLinkUID linkUID;
    private String groupName;
    private String sourceCopyName;
    private String targetCopyName;

    public ConsistencyGroupLinkInfo() {
    }

    public ConsistencyGroupLinkInfo(ConsistencyGroupLinkUID linkUID, String groupName, String sourceCopyName, String targetCopyName) {
        this.linkUID = linkUID;
        this.groupName = groupName;
        this.sourceCopyName = sourceCopyName;
        this.targetCopyName = targetCopyName;
    }

    public ConsistencyGroupLinkUID getLinkUID() {
        return linkUID;
    }

    public void setLinkUID(ConsistencyGroupLinkUID linkUID) {
        this.linkUID = linkUID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getSourceCopyName() {
        return sourceCopyName;
    }

    public void setSourceCopyName(String sourceCopyName) {
        this.sourceCopyName = sourceCopyName;
    }

    public String getTargetCopyName() {
        return targetCopyName;
    }

    public void setTargetCopyName(String targetCopyName) {
        this.targetCopyName = targetCopyName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((sourceCopyName == null) ? 0 : sourceCopyName.hashCode());
        result = prime * result
            + ((groupName == null) ? 0 : groupName.hashCode());
        result = prime * result + ((linkUID == null) ? 0 : linkUID.hashCode());
        result = prime * result
            + ((targetCopyName == null) ? 0 : targetCopyName.hashCode());
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
        ConsistencyGroupLinkInfo other = (ConsistencyGroupLinkInfo) obj;
        if (sourceCopyName == null) {
            if (other.sourceCopyName != null)
                return false;
        } else if (!sourceCopyName.equals(other.sourceCopyName))
            return false;
        if (groupName == null) {
            if (other.groupName != null)
                return false;
        } else if (!groupName.equals(other.groupName))
            return false;
        if (linkUID == null) {
            if (other.linkUID != null)
                return false;
        } else if (!linkUID.equals(other.linkUID))
            return false;
        if (targetCopyName == null) {
            if (other.targetCopyName != null)
                return false;
        } else if (!targetCopyName.equals(other.targetCopyName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ConsistencyGroupLinkInfo [sourceCopyName=").append(
            sourceCopyName).append(", groupName=").append(groupName).append(
            ", linkUID=").append(linkUID).append(", targetCopyName=")
            .append(targetCopyName).append("]");
        return builder.toString();
    }
}
