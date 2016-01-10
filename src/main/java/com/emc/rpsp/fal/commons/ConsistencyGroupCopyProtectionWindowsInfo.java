package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "ConsistencyGroupCopyProtectionWindowsInfo")
//@LargeObject
public class ConsistencyGroupCopyProtectionWindowsInfo {

    private ConsistencyGroupCopyUID groupCopyUID;
    private ProtectionWindowsInfo protectionWindows;

    public ConsistencyGroupCopyProtectionWindowsInfo() {
    }

    public ConsistencyGroupCopyProtectionWindowsInfo(ConsistencyGroupCopyUID groupCopyUID, ProtectionWindowsInfo protectionWindows) {
        this.groupCopyUID = groupCopyUID;
        this.protectionWindows = protectionWindows;
    }

    public ConsistencyGroupCopyUID getGroupCopyUID() {
        return groupCopyUID;
    }

    public void setGroupCopyUID(ConsistencyGroupCopyUID groupCopyUID) {
        this.groupCopyUID = groupCopyUID;
    }

    public ProtectionWindowsInfo getProtectionWindows() {
        return protectionWindows;
    }

    public void setProtectionWindows(ProtectionWindowsInfo protectionWindows) {
        this.protectionWindows = protectionWindows;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((groupCopyUID == null) ? 0 : groupCopyUID.hashCode());
        result = prime
            * result
            + ((protectionWindows == null) ? 0 : protectionWindows
            .hashCode());
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
        ConsistencyGroupCopyProtectionWindowsInfo other = (ConsistencyGroupCopyProtectionWindowsInfo) obj;
        if (groupCopyUID == null) {
            if (other.groupCopyUID != null)
                return false;
        } else if (!groupCopyUID.equals(other.groupCopyUID))
            return false;
        if (protectionWindows == null) {
            if (other.protectionWindows != null)
                return false;
        } else if (!protectionWindows.equals(other.protectionWindows))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(
            "ConsistencyGroupCopyProtectionWindowsInfo [groupCopyUID=")
            .append(groupCopyUID).append(", protectionWindows=").append(
            protectionWindows).append("]");
        return builder.toString();
    }
}
