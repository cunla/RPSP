package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RpaUID")
public class RpaUID implements Validateable {

    //This member handles all RpaUID objects retrieval\creation
//	private static ObjectsGenerator<RpaUID>  rpaUIDgenerator = new ObjectsGenerator<RpaUID>();

    @XmlElement(nillable = true, required = true)
    private ClusterUID clusterUID;
    private int rpaNumber;

    //TODO annotate - this CTOR should NOT be used! (due to UIDs cache)
    public RpaUID() {
    }

    private RpaUID(ClusterUID clusterUID, int rpaNumber) {
        this.clusterUID = clusterUID;
        this.rpaNumber = rpaNumber;
    }

    public static RpaUID generateRpaUID(ClusterUID clusterUID, int rpaNumber) {
        return (new RpaUID(clusterUID, rpaNumber));
    }

    public ClusterUID getClusterUID() {
        return clusterUID;
    }

    public void setClusterUID(ClusterUID clusterUID) {
        this.clusterUID = clusterUID;
    }

    public int getRpaNumber() {
        return rpaNumber;
    }

    public void setRpaNumber(int rpaNumber) {
        this.rpaNumber = rpaNumber;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + rpaNumber;
        result = prime * result + ((clusterUID == null) ? 0 : clusterUID.hashCode());
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
        RpaUID other = (RpaUID) obj;
        if (rpaNumber != other.rpaNumber)
            return false;
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
        builder.append("RpaUID [rpaNumber=").append(rpaNumber).append(
            ", clusterUID=").append(clusterUID).append("]");
        return builder.toString();
    }
}
