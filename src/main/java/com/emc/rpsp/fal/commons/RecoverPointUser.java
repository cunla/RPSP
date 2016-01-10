package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.Arrays;
import java.util.HashSet;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecoverPointUser")
public class RecoverPointUser implements Validateable {

    @XmlElement(required = true)
    private RecoverPointUserType userType;
    @XmlElement(required = true)
    private String name;
    private byte[] password;
    @XmlElement(required = true)
    private String roleName;
    private HashSet<ConsistencyGroupUID> groups;
    private UserEventLogsFilter logsFilter;

    public RecoverPointUser() {
    }

    public RecoverPointUser(RecoverPointUserType userType, String name,
                            byte[] password, String roleName,
                            HashSet<ConsistencyGroupUID> groups, UserEventLogsFilter logsFilter) {
        this.userType = userType;
        this.name = name;
        this.password = password;
        this.roleName = roleName;
        this.groups = groups;
        this.logsFilter = logsFilter;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    public RecoverPointUserType getUserType() {
        return userType;
    }

    public void setUserType(RecoverPointUserType userType) {
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public HashSet<ConsistencyGroupUID> getGroups() {
        return groups;
    }

    public void setGroups(HashSet<ConsistencyGroupUID> groups) {
        this.groups = groups;
    }

    public UserEventLogsFilter getLogsFilter() {
        return logsFilter;
    }

    public void setLogsFilter(UserEventLogsFilter logsFilter) {
        this.logsFilter = logsFilter;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((groups == null) ? 0 : groups.hashCode());
        result = prime * result
            + ((logsFilter == null) ? 0 : logsFilter.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + Arrays.hashCode(password);
        result = prime * result
            + ((roleName == null) ? 0 : roleName.hashCode());
        result = prime * result
            + ((userType == null) ? 0 : userType.hashCode());
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
        RecoverPointUser other = (RecoverPointUser) obj;
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
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (!Arrays.equals(password, other.password))
            return false;
        if (roleName == null) {
            if (other.roleName != null)
                return false;
        } else if (!roleName.equals(other.roleName))
            return false;
        if (userType == null) {
            if (other.userType != null)
                return false;
        } else if (!userType.equals(other.userType))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RecoverPointUser [groups=").append(groups).append(
            ", logsFilter=").append(logsFilter).append(", name=").append(
            name).append(", password=").append(".....")
            .append(", roleName=").append(roleName).append(", userType=")
            .append(userType).append("]");
        return builder.toString();
    }
}
