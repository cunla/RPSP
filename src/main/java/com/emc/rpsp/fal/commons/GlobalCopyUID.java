package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GlobalCopyUID")
public class GlobalCopyUID implements Validateable {

    //This member handles all ConsistencyGroupCopyUID objects retrieval\creation
//	private static ObjectsGenerator<GlobalCopyUID>  globalCopyUIDgenerator = new ObjectsGenerator<GlobalCopyUID>();

    @XmlElement(nillable = true, required = true)
    private ClusterUID clusterUID;
    private int copyUID;

    public GlobalCopyUID() {
    }

    public GlobalCopyUID(ClusterUID clusterUID, int copyUID) {
        this.clusterUID = clusterUID;
        this.copyUID = copyUID;
    }

    public static GlobalCopyUID generateGlobalCopyUID(ClusterUID clusterUID, int copyUID) {
        return (new GlobalCopyUID(clusterUID, copyUID));
    }

    public ClusterUID getClusterUID() {
        return clusterUID;
    }

    public void setClusterUID(ClusterUID clusterUID) {
        this.clusterUID = clusterUID;
    }

    public int getCopyUID() {
        return copyUID;
    }

    public void setCopyUID(int copyUID) {
        this.copyUID = copyUID;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + copyUID;
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
        GlobalCopyUID other = (GlobalCopyUID) obj;
        if (copyUID != other.copyUID)
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
        builder.append("GlobalCopyUID [clusterUID=").append(clusterUID)
            .append(", copyUID=").append(copyUID).append("]");
        return builder.toString();
    }


}
