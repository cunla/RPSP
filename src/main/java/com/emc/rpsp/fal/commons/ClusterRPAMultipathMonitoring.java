package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterRPAMultipathMonitoring")
public class ClusterRPAMultipathMonitoring implements Validateable {

    @XmlElement(nillable = true, required = true)
    private ClusterUID clusterUID;
    private boolean monitoringStorage;
    private boolean monitoringSplitters;

    public ClusterRPAMultipathMonitoring() {
    }

    public ClusterRPAMultipathMonitoring(ClusterUID clusterUID, boolean monitoringStorage, boolean monitoringSplitters) {
        this.clusterUID = clusterUID;
        this.monitoringStorage = monitoringStorage;
        this.monitoringSplitters = monitoringSplitters;
    }

    public ClusterUID getClusterUID() {
        return clusterUID;
    }

    public void setClusterUID(ClusterUID clusterUID) {
        this.clusterUID = clusterUID;
    }

    public boolean getMonitoringStorage() {
        return monitoringStorage;
    }

    public void setMonitoringStorage(boolean monitoringStorage) {
        this.monitoringStorage = monitoringStorage;
    }

    public boolean getMonitoringSplitters() {
        return monitoringSplitters;
    }

    public void setMonitoringSplitters(boolean monitoringSplitters) {
        this.monitoringSplitters = monitoringSplitters;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (monitoringSplitters ? 1231 : 1237);
        result = prime * result + (monitoringStorage ? 1231 : 1237);
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
        ClusterRPAMultipathMonitoring other = (ClusterRPAMultipathMonitoring) obj;
        if (monitoringSplitters != other.monitoringSplitters)
            return false;
        if (monitoringStorage != other.monitoringStorage)
            return false;
        if (clusterUID == null) {
            if (other.clusterUID != null)
                return false;
        } else if (!clusterUID.equals(other.clusterUID))
            return false;
        return true;
    }

}
