package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@XmlRootElement
@XmlType(name = "LDAPServerInfo")
public class LDAPServerInfo {

    private HashSet<String> usersNames;
    private HashSet<String> groupsNames;

    public LDAPServerInfo() {
    }

    public LDAPServerInfo(HashSet<String> usersNames, HashSet<String> groupsNames) {
        this.usersNames = usersNames;
        this.groupsNames = groupsNames;
    }

    public HashSet<String> getUsersNames() {
        return usersNames;
    }

    public void setUsersNames(HashSet<String> usersNames) {
        this.usersNames = usersNames;
    }

    public HashSet<String> getGroupsNames() {
        return groupsNames;
    }

    public void setGroupsNames(HashSet<String> groupsNames) {
        this.groupsNames = groupsNames;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((groupsNames == null) ? 0 : groupsNames.hashCode());
        result = prime * result
            + ((usersNames == null) ? 0 : usersNames.hashCode());
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
        LDAPServerInfo other = (LDAPServerInfo) obj;
        if (groupsNames == null) {
            if (other.groupsNames != null)
                return false;
        } else if (!groupsNames.equals(other.groupsNames))
            return false;
        if (usersNames == null) {
            if (other.usersNames != null)
                return false;
        } else if (!usersNames.equals(other.usersNames))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LDAPServerInfo [groupsNames=").append(groupsNames)
            .append(", usersNames=").append(usersNames).append("]");
        return builder.toString();
    }
}
