package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

@JsonTypeName("ClusterLicenseSettings")
@XmlType(name = "ClusterLicenseSettings")
public class ClusterLicenseSettings extends LicenseSettings {

    @XmlElement(nillable = true)
    private ClusterUID clusterUID;

    public ClusterLicenseSettings() {
    }

    public ClusterLicenseSettings(ClusterUID clusterUID, LicenseUID licenseUID, int capacity, LicenseCapacityUnit capacityUnit,
                                  RecoverPointTimeStamp expirationDate,
                                  RecoverPointLicenseType licenseType, Boolean localReplicationOnly) {
        super(licenseUID, capacity, capacityUnit, expirationDate, licenseType, localReplicationOnly);
        this.clusterUID = clusterUID;
    }

    public ClusterUID getClusterUID() {
        return clusterUID;
    }

    public void setClusterUID(ClusterUID clusterUID) {
        this.clusterUID = clusterUID;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((clusterUID == null) ? 0 : clusterUID.hashCode());
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
        ClusterLicenseSettings other = (ClusterLicenseSettings) obj;
        if (clusterUID == null) {
            if (other.clusterUID != null)
                return false;
        } else if (!clusterUID.equals(other.clusterUID))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ClusterLicenseSettings [clusterUID=").append(clusterUID)
            .append(", super=").append(super.toString()).append("]");
        return builder.toString();
    }

}
