package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

@JsonTypeName("SplitterConnectivityStatus")
@XmlType(name = "SplitterConnectivityStatus")
public class SplitterConnectivityStatus extends ClusterEntityConnectivityStatus {

    @XmlElement(nillable = true)
    private SplitterUID splitterUID;

    public SplitterConnectivityStatus() {
    }

    public SplitterConnectivityStatus(SplitterUID splitterUID, GeneralStatus connectivityStatus) {
        super(splitterUID.getClusterUID(), ClusterEntityType.SPLITTER, connectivityStatus);
        this.splitterUID = splitterUID;
    }

    public SplitterConnectivityStatus(ClusterUID clusterUID, ClusterEntityType entityType, GeneralStatus connectivityStatus, SplitterUID splitterUID) {
        this(splitterUID, connectivityStatus);
    }

    public SplitterUID getSplitterUID() {
        return splitterUID;
    }

    public void setSplitterUID(SplitterUID splitterUID) {
        this.splitterUID = splitterUID;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
            + ((splitterUID == null) ? 0 : splitterUID.hashCode());
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
        SplitterConnectivityStatus other = (SplitterConnectivityStatus) obj;
        if (splitterUID == null) {
            if (other.splitterUID != null)
                return false;
        } else if (!splitterUID.equals(other.splitterUID))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append("SplitterConnectivityStatus [splitterUID=").append(
            splitterUID).append(", super=").append(super.toString()).append("]");
        return builder.toString();
    }
}
