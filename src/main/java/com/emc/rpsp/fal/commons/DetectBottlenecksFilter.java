package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DetectBottlenecksFilter")
public class DetectBottlenecksFilter implements Validateable {

    @XmlElement(required = true)
    private BottlenecksDetectionMode workingMode;
    @XmlElement(nillable = true)
    private TimeFrame timeFrame;
    private Quantity peakDuration; // must hold a time quantity
    private Boolean advancedOverview;
    private Boolean detailedOverview;
    private HashSet<ConsistencyGroupUID> groups;

    public DetectBottlenecksFilter() {
    }

    public DetectBottlenecksFilter(BottlenecksDetectionMode workingMode, TimeFrame timeFrame, Quantity peakDuration,
                                   Boolean advancedOverview, Boolean detailedOverview, HashSet<ConsistencyGroupUID> groups) {
        this.workingMode = workingMode;
        this.timeFrame = timeFrame;
        this.peakDuration = peakDuration;
        this.advancedOverview = advancedOverview;
        this.detailedOverview = detailedOverview;
        this.groups = groups;
    }

    public BottlenecksDetectionMode getWorkingMode() {
        return workingMode;
    }

    public void setWorkingMode(BottlenecksDetectionMode workingMode) {
        this.workingMode = workingMode;
    }

    public TimeFrame getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(TimeFrame timeFrame) {
        this.timeFrame = timeFrame;
    }

    public Quantity getPeakDuration() {
        return peakDuration;
    }

    public void setPeakDuration(Quantity peakDuration) {
        this.peakDuration = peakDuration;
    }

    public Boolean getAdvancedOverview() {
        return advancedOverview;
    }

    public void setAdvancedOverview(Boolean advancedOverview) {
        this.advancedOverview = advancedOverview;
    }

    public Boolean getDetailedOverview() {
        return detailedOverview;
    }

    public void setDetailedOverview(Boolean detailedOverview) {
        this.detailedOverview = detailedOverview;
    }

    public HashSet<ConsistencyGroupUID> getGroups() {
        return groups;
    }

    public void setGroups(HashSet<ConsistencyGroupUID> groups) {
        this.groups = groups;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (advancedOverview ? 1231 : 1237);
        result = prime * result + (detailedOverview ? 1231 : 1237);
        result = prime * result + ((groups == null) ? 0 : groups.hashCode());
        result = prime * result
            + ((peakDuration == null) ? 0 : peakDuration.hashCode());
        result = prime * result
            + ((timeFrame == null) ? 0 : timeFrame.hashCode());
        result = prime * result
            + ((workingMode == null) ? 0 : workingMode.hashCode());
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
        DetectBottlenecksFilter other = (DetectBottlenecksFilter) obj;
        if (advancedOverview != other.advancedOverview)
            return false;
        if (detailedOverview != other.detailedOverview)
            return false;
        if (groups == null) {
            if (other.groups != null)
                return false;
        } else if (!groups.equals(other.groups))
            return false;
        if (peakDuration == null) {
            if (other.peakDuration != null)
                return false;
        } else if (!peakDuration.equals(other.peakDuration))
            return false;
        if (timeFrame == null) {
            if (other.timeFrame != null)
                return false;
        } else if (!timeFrame.equals(other.timeFrame))
            return false;
        if (workingMode == null) {
            if (other.workingMode != null)
                return false;
        } else if (!workingMode.equals(other.workingMode))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "DetectBottlenecksFilter [advancedOverview=" + advancedOverview
            + ", detailedOverview=" + detailedOverview + ", groups="
            + groups + ", peakDuration=" + peakDuration + ", timeFrame="
            + timeFrame + ", workingMode=" + workingMode + "]";
    }
}
