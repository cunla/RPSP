package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("serial")
@XmlRootElement
@XmlType(name = "TimeFrame")
public class TimeFrame implements Validateable {

    private RecoverPointTimeStamp startTime;
    private RecoverPointTimeStamp endTime;

    public TimeFrame() {
    }

    public TimeFrame(RecoverPointTimeStamp startTime, RecoverPointTimeStamp endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * @param date
     * @return true iff {@code date} is in between start and end time.
     */
    public boolean inRange(RecoverPointTimeStamp timeStamp) {
        if (timeStamp == null) {
            return false;
        }

        long timeValue = timeStamp.getTimeInMicroSeconds();
        return (timeValue >= startTime.getTimeInMicroSeconds()) && (timeValue <= endTime.getTimeInMicroSeconds());
    }

    public RecoverPointTimeStamp getStartTime() {
        return startTime;
    }

    public void setStartTime(RecoverPointTimeStamp startTime) {
        this.startTime = startTime;
    }

    public RecoverPointTimeStamp getEndTime() {
        return endTime;
    }

    public void setEndTime(RecoverPointTimeStamp endTime) {
        this.endTime = endTime;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
        result = prime * result
            + ((startTime == null) ? 0 : startTime.hashCode());
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
        TimeFrame other = (TimeFrame) obj;
        if (endTime == null) {
            if (other.endTime != null)
                return false;
        } else if (!endTime.equals(other.endTime))
            return false;
        if (startTime == null) {
            if (other.startTime != null)
                return false;
        } else if (!startTime.equals(other.startTime))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TimeFrame [endTime=").append(endTime).append(
            ", startTime=").append(startTime).append("]");
        return builder.toString();
    }
}
