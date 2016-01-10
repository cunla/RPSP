package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VolumeStatus")
public class VolumeStatus implements Validateable {

    @XmlElement(required = true)
    private VolumeAccessStatus accessStatus;
    private boolean multipathingProblems;

    public VolumeStatus() {
    }

    public VolumeStatus(VolumeAccessStatus accessStatus, boolean multipathingProblems) {
        this.accessStatus = accessStatus;
        this.multipathingProblems = multipathingProblems;
    }

    public VolumeAccessStatus getAccessStatus() {
        return accessStatus;
    }

    public void setAccessStatus(VolumeAccessStatus accessStatus) {
        this.accessStatus = accessStatus;
    }

    public boolean getMultipathingProblems() {
        return multipathingProblems;
    }

    public void setMultipathingProblems(boolean multipathingProblems) {
        this.multipathingProblems = multipathingProblems;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((accessStatus == null) ? 0 : accessStatus.hashCode());
        result = prime * result + (multipathingProblems ? 1231 : 1237);
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
        VolumeStatus other = (VolumeStatus) obj;
        if (accessStatus == null) {
            if (other.accessStatus != null)
                return false;
        } else if (!accessStatus.equals(other.accessStatus))
            return false;
        if (multipathingProblems != other.multipathingProblems)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("VolumeStatus [accessStatus=").append(accessStatus)
            .append(", multipathingProblems=").append(multipathingProblems)
            .append("]");
        return builder.toString();
    }
}
