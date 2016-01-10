package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterStatistics")
//@LargeObject
public class ClusterStatistics {

    @XmlElement(nillable = true)
    private ClusterUID clusterUID;
    private TrafficStatistics traffic;

    public ClusterStatistics() {
        super();
    }

    public ClusterStatistics(ClusterUID clusterUID, TrafficStatistics traffic) {
        super();
        this.clusterUID = clusterUID;
        this.traffic = traffic;
    }


    public ClusterUID getClusterUID() {
        return clusterUID;
    }

    public void setClusterUID(ClusterUID clusterUID) {
        this.clusterUID = clusterUID;
    }

    public TrafficStatistics getTraffic() {
        return traffic;
    }

    public void setTraffic(TrafficStatistics traffic) {
        this.traffic = traffic;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((clusterUID == null) ? 0 : clusterUID.hashCode());
        result = prime * result + ((traffic == null) ? 0 : traffic.hashCode());
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
        ClusterStatistics other = (ClusterStatistics) obj;
        if (clusterUID == null) {
            if (other.clusterUID != null)
                return false;
        } else if (!clusterUID.equals(other.clusterUID))
            return false;
        if (traffic == null) {
            if (other.traffic != null)
                return false;
        } else if (!traffic.equals(other.traffic))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ClusterStatistics [clusterUID=").append(clusterUID).append(
            ", traffic=").append(traffic).append("]");
        return builder.toString();
    }

}
