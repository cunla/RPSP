package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "ConsistencyGroupCopyInfo")
public class ConsistencyGroupCopyInfo {

    private ConsistencyGroupCopyUID copyUID;
    private String copyName;
    private String groupName;

    public ConsistencyGroupCopyInfo() {
    }

    public ConsistencyGroupCopyInfo(ConsistencyGroupCopyUID copyUID, String copyName, String groupName) {
        this.copyUID = copyUID;
        this.copyName = copyName;
        this.groupName = groupName;
    }

    public ConsistencyGroupCopyUID getCopyUID() {
        return copyUID;
    }

    public void setCopyUID(ConsistencyGroupCopyUID copyUID) {
        this.copyUID = copyUID;
    }

    public String getCopyName() {
        return copyName;
    }

    public void setCopyName(String copyName) {
        this.copyName = copyName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((copyName == null) ? 0 : copyName.hashCode());
        result = prime * result + ((copyUID == null) ? 0 : copyUID.hashCode());
        result = prime * result
            + ((groupName == null) ? 0 : groupName.hashCode());
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
        ConsistencyGroupCopyInfo other = (ConsistencyGroupCopyInfo) obj;
        if (copyName == null) {
            if (other.copyName != null)
                return false;
        } else if (!copyName.equals(other.copyName))
            return false;
        if (copyUID == null) {
            if (other.copyUID != null)
                return false;
        } else if (!copyUID.equals(other.copyUID))
            return false;
        if (groupName == null) {
            if (other.groupName != null)
                return false;
        } else if (!groupName.equals(other.groupName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ConsistencyGroupCopyInfo [copyName=").append(copyName)
            .append(", copyUID=").append(copyUID).append(", groupName=")
            .append(groupName).append("]");
        return builder.toString();
    }
}
