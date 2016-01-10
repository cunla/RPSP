package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "ConsistencyGroupInfo")
public class ConsistencyGroupInfo {

    private ConsistencyGroupUID groupUID;
    private String groupName;

    public ConsistencyGroupInfo() {
    }

    public ConsistencyGroupInfo(ConsistencyGroupUID groupUID, String groupName) {
        this.groupUID = groupUID;
        this.groupName = groupName;
    }

    /**
     * @return the groupUID
     */
    public ConsistencyGroupUID getGroupUID() {
        return groupUID;
    }

    /**
     * @param groupUID the groupUID to set
     */
    public void setGroupUID(ConsistencyGroupUID groupUID) {
        this.groupUID = groupUID;
    }

    /**
     * @return the groupName
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * @param groupName the groupName to set
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((groupName == null) ? 0 : groupName.hashCode());
        result = prime * result
            + ((groupUID == null) ? 0 : groupUID.hashCode());
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
        ConsistencyGroupInfo other = (ConsistencyGroupInfo) obj;
        if (groupName == null) {
            if (other.groupName != null)
                return false;
        } else if (!groupName.equals(other.groupName))
            return false;
        if (groupUID == null) {
            if (other.groupUID != null)
                return false;
        } else if (!groupUID.equals(other.groupUID))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ConsistencyGroupInfo [groupName=").append(groupName).append(
            ", groupUID=").append(groupUID).append("]");
        return builder.toString();
    }
}
