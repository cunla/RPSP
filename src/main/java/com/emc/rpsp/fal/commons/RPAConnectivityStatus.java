package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

@JsonTypeName("RPAConnectivityStatus")
@XmlType(name = "RPAConnectivityStatus")
public class RPAConnectivityStatus extends ClusterEntityConnectivityStatus {

    @XmlElement(nillable = true)
    private RpaUID rpaUID;

    public RPAConnectivityStatus() {
    }

    public RPAConnectivityStatus(RpaUID rpaUID, GeneralStatus connectivityStatus) {
        super(rpaUID.getClusterUID(), ClusterEntityType.RPA, connectivityStatus);
        this.rpaUID = rpaUID;
    }

    public RPAConnectivityStatus(ClusterUID clusterUID, ClusterEntityType entityType, GeneralStatus connectivityStatus, RpaUID rpaUID) {
        this(rpaUID, connectivityStatus);
    }

    public RpaUID getRpaUID() {
        return rpaUID;
    }

    public void setRpaUID(RpaUID rpaUID) {
        this.rpaUID = rpaUID;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((rpaUID == null) ? 0 : rpaUID.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        RPAConnectivityStatus other = (RPAConnectivityStatus) obj;
        if (rpaUID == null) {
            if (other.rpaUID != null)
                return false;
        } else if (!rpaUID.equals(other.rpaUID))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RPAConnectivityStatus [rpaUID=").append(rpaUID).append(", super=").append(super.toString()).append(
            "]");
        return builder.toString();
    }
}
