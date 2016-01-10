package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;


@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterSoftwareSerialID")
public class ClusterSoftwareSerialID implements Validateable {

    @XmlElement(nillable = true, required = true)
    private ClusterUID clusterUID;
    @XmlElement(required = true)
    private String softwareSerialID;

    public ClusterSoftwareSerialID() {
    }

    public ClusterSoftwareSerialID(ClusterUID clusterUID, String softwareSerialID) {
        this.clusterUID = clusterUID;
        this.softwareSerialID = softwareSerialID;
    }

    public ClusterUID getClusterUID() {
        return clusterUID;
    }

    public void setClusterUID(ClusterUID clusterUID) {
        this.clusterUID = clusterUID;
    }

    public String getSoftwareSerialID() {
        return softwareSerialID;
    }

    public void setSoftwareSerialID(String softwareSerialID) {
        this.softwareSerialID = softwareSerialID;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((clusterUID == null) ? 0 : clusterUID.hashCode());
        result = prime
            * result
            + ((softwareSerialID == null) ? 0 : softwareSerialID.hashCode());
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
        ClusterSoftwareSerialID other = (ClusterSoftwareSerialID) obj;
        if (clusterUID == null) {
            if (other.clusterUID != null)
                return false;
        } else if (!clusterUID.equals(other.clusterUID))
            return false;
        if (softwareSerialID == null) {
            if (other.softwareSerialID != null)
                return false;
        } else if (!softwareSerialID.equals(other.softwareSerialID))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ClusterSoftwareSerialID [clusterUID=").append(clusterUID)
            .append(", softwareSerialID=").append(softwareSerialID).append(
            "]");
        return builder.toString();
    }
}
