package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@XmlRootElement
@XmlType(name = "SystemSettingsConflicts")
public class SystemSettingsConflicts {

    private String conflictsDescription;
    private HashSet<ClusterInfo> clustersInfo;

    public SystemSettingsConflicts() {
    }

    public SystemSettingsConflicts(String conflictsDescription, HashSet<ClusterInfo> clustersInfo) {
        this.conflictsDescription = conflictsDescription;
        this.clustersInfo = clustersInfo;
    }

    public String getConflictsDescription() {
        return conflictsDescription;
    }

    public void setConflictsDescription(String conflictsDescription) {
        this.conflictsDescription = conflictsDescription;
    }

    public HashSet<ClusterInfo> getClustersInfo() {
        return clustersInfo;
    }

    public void setClustersInfo(HashSet<ClusterInfo> clustersInfo) {
        this.clustersInfo = clustersInfo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((conflictsDescription == null) ? 0 : conflictsDescription
            .hashCode());
        result = prime * result
            + ((clustersInfo == null) ? 0 : clustersInfo.hashCode());
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
        SystemSettingsConflicts other = (SystemSettingsConflicts) obj;
        if (conflictsDescription == null) {
            if (other.conflictsDescription != null)
                return false;
        } else if (!conflictsDescription.equals(other.conflictsDescription))
            return false;
        if (clustersInfo == null) {
            if (other.clustersInfo != null)
                return false;
        } else if (!clustersInfo.equals(other.clustersInfo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SystemSettingsConflicts [conflictsDescription=")
            .append(conflictsDescription).append(", clustersInfo=").append(
            clustersInfo).append("]");
        return builder.toString();
    }
}
