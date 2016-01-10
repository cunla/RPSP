package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "ConsistencyGroupCopyRoleInfo")
public class ConsistencyGroupCopyRoleInfo {

    private ConsistencyGroupCopyRole role;
    private ConsistencyGroupCopyUID sourceCopyUID;

    public ConsistencyGroupCopyRoleInfo() {
    }

    public ConsistencyGroupCopyRoleInfo(ConsistencyGroupCopyRole role, ConsistencyGroupCopyUID sourceCopyUID) {
        this.role = role;
        this.sourceCopyUID = sourceCopyUID;
    }

    public ConsistencyGroupCopyRole getRole() {
        return role;
    }

    public void setRole(ConsistencyGroupCopyRole role) {
        this.role = role;
    }

    public ConsistencyGroupCopyUID getSourceCopyUID() {
        return sourceCopyUID;
    }

    public void setSourceCopyUID(ConsistencyGroupCopyUID sourceCopyUID) {
        this.sourceCopyUID = sourceCopyUID;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((role == null) ? 0 : role.hashCode());
        result = prime * result
            + ((sourceCopyUID == null) ? 0 : sourceCopyUID.hashCode());
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
        ConsistencyGroupCopyRoleInfo other = (ConsistencyGroupCopyRoleInfo) obj;
        if (role == null) {
            if (other.role != null)
                return false;
        } else if (!role.equals(other.role))
            return false;
        if (sourceCopyUID == null) {
            if (other.sourceCopyUID != null)
                return false;
        } else if (!sourceCopyUID.equals(other.sourceCopyUID))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ConsistencyGroupCopyRoleInfo [role=").append(role)
            .append(", sourceCopyUID=").append(sourceCopyUID).append("]");
        return builder.toString();
    }
}
