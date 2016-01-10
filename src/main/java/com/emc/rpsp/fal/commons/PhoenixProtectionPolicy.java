package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PhoenixProtectionPolicy")
public class PhoenixProtectionPolicy implements Validateable {

    @XmlElement(nillable = true, required = true)
    private PhoenixClusterProtectionPolicy phoenixClusterProtectionPolicy;
    @XmlElement(required = true)
    private ConsistencyGroupCopyUID phoenixProctectedCopyUID;

    public PhoenixProtectionPolicy() {
    }

    public PhoenixProtectionPolicy(PhoenixClusterProtectionPolicy phoenixClusterProtectionPolicy, ConsistencyGroupCopyUID phoenixProctectedCopyUID) {
        this.phoenixClusterProtectionPolicy = phoenixClusterProtectionPolicy;
        this.phoenixProctectedCopyUID = phoenixProctectedCopyUID;
    }

    public PhoenixClusterProtectionPolicy getPhoenixClusterProtectionPolicy() {
        return phoenixClusterProtectionPolicy;
    }

    public void setPhoenixClusterProtectionPolicy(PhoenixClusterProtectionPolicy phoenixClusterProtectionPolicy) {
        this.phoenixClusterProtectionPolicy = phoenixClusterProtectionPolicy;
    }

    public ConsistencyGroupCopyUID getPhoenixProctectedCopyUID() {
        return phoenixProctectedCopyUID;
    }

    public void setPhoenixProctectedCopyUID(ConsistencyGroupCopyUID phoenixProctectedCopyUID) {
        this.phoenixProctectedCopyUID = phoenixProctectedCopyUID;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((phoenixClusterProtectionPolicy == null) ? 0 : phoenixClusterProtectionPolicy.hashCode());
        result = prime * result + ((phoenixProctectedCopyUID == null) ? 0 : phoenixProctectedCopyUID.hashCode());
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
        PhoenixProtectionPolicy other = (PhoenixProtectionPolicy) obj;
        if (phoenixClusterProtectionPolicy != other.phoenixClusterProtectionPolicy)
            return false;
        if (phoenixProctectedCopyUID == null) {
            if (other.phoenixProctectedCopyUID != null)
                return false;
        } else if (!phoenixProctectedCopyUID.equals(other.phoenixProctectedCopyUID))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PhoenixProtectionPolicy [phoenixClusterProtectionPolicy=").append(phoenixClusterProtectionPolicy).append(", phoenixProctectedCopyUID=")
            .append(phoenixProctectedCopyUID).append("]");
        return builder.toString();
    }

}
