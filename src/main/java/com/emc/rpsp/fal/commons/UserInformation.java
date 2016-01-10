package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@XmlRootElement
@XmlType(name = "UserInformation")
public class UserInformation {

    private HashSet<ConsistencyGroupUID> groups;
    private HashSet<Permission> permissions;
    private UserEventLogsFilter logsFilter;
    private String roleName;

    public UserInformation() {

    }

    public UserInformation(HashSet<ConsistencyGroupUID> groups, HashSet<Permission> permissions, UserEventLogsFilter logsFilter, String roleName) {
        this.groups = groups;
        this.permissions = permissions;
        this.logsFilter = logsFilter;
        this.roleName = roleName;
    }

    public HashSet<ConsistencyGroupUID> getGroups() {
        return groups;
    }

    public void setGroups(HashSet<ConsistencyGroupUID> groups) {
        this.groups = groups;
    }

    public HashSet<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(HashSet<Permission> permissions) {
        this.permissions = permissions;
    }

    public UserEventLogsFilter getLogsFilter() {
        return logsFilter;
    }

    public void setLogsFilter(UserEventLogsFilter logsFilter) {
        this.logsFilter = logsFilter;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((groups == null) ? 0 : groups.hashCode());
        result = prime * result + ((logsFilter == null) ? 0 : logsFilter.hashCode());
        result = prime * result + ((permissions == null) ? 0 : permissions.hashCode());
        result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
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
        UserInformation other = (UserInformation) obj;
        if (groups == null) {
            if (other.groups != null)
                return false;
        } else if (!groups.equals(other.groups))
            return false;
        if (logsFilter == null) {
            if (other.logsFilter != null)
                return false;
        } else if (!logsFilter.equals(other.logsFilter))
            return false;
        if (permissions == null) {
            if (other.permissions != null)
                return false;
        } else if (!permissions.equals(other.permissions))
            return false;
        if (roleName == null) {
            if (other.roleName != null)
                return false;
        } else if (!roleName.equals(other.roleName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserInformation [groups=").append(groups).append(", permissions=").append(permissions).append(", logsFilter=").append(logsFilter).append(", roleName=")
            .append(roleName).append("]");
        return builder.toString();
    }

}
