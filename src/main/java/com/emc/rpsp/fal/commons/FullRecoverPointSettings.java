package com.emc.rpsp.fal.commons;

//import com.emc.fapi.utils.logging.LargeObject;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FullRecoverPointSettings")
////@LargeObject
public class FullRecoverPointSettings {

    @XmlElement(nillable = true)
    private SystemSettings systemSettings;
    private HashSet<ClusterSplittersSettings> splittersSettings;
    private HashSet<ConsistencyGroupSettings> groupsSettings;
    private HashSet<ConsistencyGroupSetSettings> groupsSetsSettings;
    @XmlElement(nillable = true)
    private AccountSettings accountSettings;
    @XmlElement(nillable = true)
    private ManagementSettings managementSettings;
    private SystemGlobalPolicy globalPolicy;
    private boolean settingsConflict;

    public FullRecoverPointSettings() {
    }

    public FullRecoverPointSettings(SystemSettings systemSettings, HashSet<ClusterSplittersSettings> splittersSettings,
                                    HashSet<ConsistencyGroupSettings> groupsSettings, HashSet<ConsistencyGroupSetSettings> groupsSetsSettings,
                                    AccountSettings accountSettings, ManagementSettings managementSettings, SystemGlobalPolicy globalPolicy,
                                    boolean settingsConflict) {
        this.systemSettings = systemSettings;
        this.splittersSettings = splittersSettings;
        this.groupsSettings = groupsSettings;
        this.groupsSetsSettings = groupsSetsSettings;
        this.accountSettings = accountSettings;
        this.managementSettings = managementSettings;
        this.globalPolicy = globalPolicy;
        this.settingsConflict = settingsConflict;
    }

    public SystemSettings getSystemSettings() {
        return systemSettings;
    }

    public void setSystemSettings(SystemSettings systemSettings) {
        this.systemSettings = systemSettings;
    }

    public HashSet<ClusterSplittersSettings> getSplittersSettings() {
        return splittersSettings;
    }

    public void setSplittersSettings(
        HashSet<ClusterSplittersSettings> splittersSettings) {
        this.splittersSettings = splittersSettings;
    }

    public HashSet<ConsistencyGroupSettings> getGroupsSettings() {
        return groupsSettings;
    }

    public void setGroupsSettings(HashSet<ConsistencyGroupSettings> groupsSettings) {
        this.groupsSettings = groupsSettings;
    }

    public HashSet<ConsistencyGroupSetSettings> getGroupsSetsSettings() {
        return groupsSetsSettings;
    }

    public void setGroupsSetsSettings(HashSet<ConsistencyGroupSetSettings> groupsSetsSettings) {
        this.groupsSetsSettings = groupsSetsSettings;
    }

    public AccountSettings getAccountSettings() {
        return accountSettings;
    }

    public void setAccountSettings(AccountSettings accountSettings) {
        this.accountSettings = accountSettings;
    }

    public ManagementSettings getManagementSettings() {
        return managementSettings;
    }

    public void setManagementSettings(ManagementSettings managementSettings) {
        this.managementSettings = managementSettings;
    }

    public SystemGlobalPolicy getGlobalPolicy() {
        return globalPolicy;
    }

    public void setGlobalPolicy(SystemGlobalPolicy globalPolicy) {
        this.globalPolicy = globalPolicy;
    }

    public boolean getSettingsConflict() {
        return settingsConflict;
    }

    public void setSettingsConflict(boolean settingsConflict) {
        this.settingsConflict = settingsConflict;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((accountSettings == null) ? 0 : accountSettings.hashCode());
        result = prime * result
            + ((globalPolicy == null) ? 0 : globalPolicy.hashCode());
        result = prime
            * result
            + ((groupsSetsSettings == null) ? 0 : groupsSetsSettings
            .hashCode());
        result = prime * result
            + ((groupsSettings == null) ? 0 : groupsSettings.hashCode());
        result = prime
            * result
            + ((managementSettings == null) ? 0 : managementSettings
            .hashCode());
        result = prime * result + (settingsConflict ? 1231 : 1237);
        result = prime
            * result
            + ((splittersSettings == null) ? 0 : splittersSettings
            .hashCode());
        result = prime * result
            + ((systemSettings == null) ? 0 : systemSettings.hashCode());
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
        FullRecoverPointSettings other = (FullRecoverPointSettings) obj;
        if (accountSettings == null) {
            if (other.accountSettings != null)
                return false;
        } else if (!accountSettings.equals(other.accountSettings))
            return false;
        if (globalPolicy == null) {
            if (other.globalPolicy != null)
                return false;
        } else if (!globalPolicy.equals(other.globalPolicy))
            return false;
        if (groupsSetsSettings == null) {
            if (other.groupsSetsSettings != null)
                return false;
        } else if (!groupsSetsSettings.equals(other.groupsSetsSettings))
            return false;
        if (groupsSettings == null) {
            if (other.groupsSettings != null)
                return false;
        } else if (!groupsSettings.equals(other.groupsSettings))
            return false;
        if (managementSettings == null) {
            if (other.managementSettings != null)
                return false;
        } else if (!managementSettings.equals(other.managementSettings))
            return false;
        if (settingsConflict != other.settingsConflict)
            return false;
        if (splittersSettings == null) {
            if (other.splittersSettings != null)
                return false;
        } else if (!splittersSettings.equals(other.splittersSettings))
            return false;
        if (systemSettings == null) {
            if (other.systemSettings != null)
                return false;
        } else if (!systemSettings.equals(other.systemSettings))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("FullRecoverPointSettings [accountSettings=").append(
            accountSettings).append(", globalPolicy=").append(globalPolicy)
            .append(", groupsSetsSettings=").append(groupsSetsSettings)
            .append(", groupsSettings=").append(groupsSettings).append(
            ", managementSettings=").append(managementSettings)
            .append(", settingsConflict=").append(settingsConflict).append(
            ", splittersSettings=").append(splittersSettings)
            .append(", systemSettings=").append(systemSettings).append("]");
        return builder.toString();
    }
}
