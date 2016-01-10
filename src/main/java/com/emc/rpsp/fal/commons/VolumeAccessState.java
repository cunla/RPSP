package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("serial")
@XmlRootElement
@XmlType(name = "VolumeAccessState")
public class VolumeAccessState implements Validateable {

    private Boolean writable;
    private Boolean splittingToVolume;
    private Boolean markingDataOnSplitter;
    private Boolean delayed;
    private RpaUID targetRPA; // relevant only when splitting to volume
    private Boolean attachedToOtherCluster;
    private Boolean inErrorState;
    private Boolean busy;
    private Boolean readOnly;

    public VolumeAccessState() {
    }

    public VolumeAccessState(Boolean writable, Boolean splittingToVolume, Boolean markingDataOnSplitter, Boolean delayed,
                             RpaUID targetRPA, Boolean attachedToOtherCluster, Boolean inErrorState, Boolean busy, Boolean readOnly) {
        this.writable = writable;
        this.splittingToVolume = splittingToVolume;
        this.markingDataOnSplitter = markingDataOnSplitter;
        this.delayed = delayed;
        this.targetRPA = targetRPA;
        this.attachedToOtherCluster = attachedToOtherCluster;
        this.inErrorState = inErrorState;
        this.busy = busy;
        this.readOnly = readOnly;
    }

    public Boolean getReadOnly() {
        return readOnly;
    }

    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    public Boolean getWritable() {
        return writable;
    }

    public void setWritable(Boolean writable) {
        this.writable = writable;
    }

    public Boolean getSplittingToVolume() {
        return splittingToVolume;
    }

    public void setSplittingToVolume(Boolean splittingToVolume) {
        this.splittingToVolume = splittingToVolume;
    }

    public Boolean getMarkingDataOnSplitter() {
        return markingDataOnSplitter;
    }

    public void setMarkingDataOnSplitter(Boolean markingDataOnSplitter) {
        this.markingDataOnSplitter = markingDataOnSplitter;
    }

    public Boolean getDelayed() {
        return delayed;
    }

    public void setDelayed(Boolean delayed) {
        this.delayed = delayed;
    }

    public RpaUID getTargetRPA() {
        return targetRPA;
    }

    public void setTargetRPA(RpaUID targetRPA) {
        this.targetRPA = targetRPA;
    }

    public Boolean getAttachedToOtherCluster() {
        return attachedToOtherCluster;
    }

    public void setAttachedToOtherCluster(Boolean attachedToOtherCluster) {
        this.attachedToOtherCluster = attachedToOtherCluster;
    }

    public Boolean getInErrorState() {
        return inErrorState;
    }

    public void setInErrorState(Boolean inErrorState) {
        this.inErrorState = inErrorState;
    }

    public Boolean getBusy() {
        return busy;
    }

    public void setBusy(Boolean busy) {
        this.busy = busy;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((attachedToOtherCluster == null) ? 0
            : attachedToOtherCluster.hashCode());
        result = prime * result + ((busy == null) ? 0 : busy.hashCode());
        result = prime * result + ((delayed == null) ? 0 : delayed.hashCode());
        result = prime * result
            + ((inErrorState == null) ? 0 : inErrorState.hashCode());
        result = prime
            * result
            + ((markingDataOnSplitter == null) ? 0 : markingDataOnSplitter
            .hashCode());
        result = prime * result
            + ((readOnly == null) ? 0 : readOnly.hashCode());
        result = prime
            * result
            + ((splittingToVolume == null) ? 0 : splittingToVolume
            .hashCode());
        result = prime * result
            + ((targetRPA == null) ? 0 : targetRPA.hashCode());
        result = prime * result
            + ((writable == null) ? 0 : writable.hashCode());
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
        VolumeAccessState other = (VolumeAccessState) obj;
        if (attachedToOtherCluster == null) {
            if (other.attachedToOtherCluster != null)
                return false;
        } else if (!attachedToOtherCluster.equals(other.attachedToOtherCluster))
            return false;
        if (busy == null) {
            if (other.busy != null)
                return false;
        } else if (!busy.equals(other.busy))
            return false;
        if (delayed == null) {
            if (other.delayed != null)
                return false;
        } else if (!delayed.equals(other.delayed))
            return false;
        if (inErrorState == null) {
            if (other.inErrorState != null)
                return false;
        } else if (!inErrorState.equals(other.inErrorState))
            return false;
        if (markingDataOnSplitter == null) {
            if (other.markingDataOnSplitter != null)
                return false;
        } else if (!markingDataOnSplitter.equals(other.markingDataOnSplitter))
            return false;
        if (readOnly == null) {
            if (other.readOnly != null)
                return false;
        } else if (!readOnly.equals(other.readOnly))
            return false;
        if (splittingToVolume == null) {
            if (other.splittingToVolume != null)
                return false;
        } else if (!splittingToVolume.equals(other.splittingToVolume))
            return false;
        if (targetRPA == null) {
            if (other.targetRPA != null)
                return false;
        } else if (!targetRPA.equals(other.targetRPA))
            return false;
        if (writable == null) {
            if (other.writable != null)
                return false;
        } else if (!writable.equals(other.writable))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("VolumeAccessState [writable=").append(writable)
            .append(", splittingToVolume=").append(splittingToVolume)
            .append(", markingDataOnSplitter=")
            .append(markingDataOnSplitter).append(", delayed=")
            .append(delayed).append(", targetRPA=").append(targetRPA)
            .append(", attachedToOtherCluster=")
            .append(attachedToOtherCluster).append(", inErrorState=")
            .append(inErrorState).append(", busy=").append(busy)
            .append(", readOnly=").append(readOnly).append("]");
        return builder.toString();
    }
}
