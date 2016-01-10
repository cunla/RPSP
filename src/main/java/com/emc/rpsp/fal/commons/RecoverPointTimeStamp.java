package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("serial")
@XmlRootElement
@XmlType(name = "RecoverPointTimeStamp")
public class RecoverPointTimeStamp implements Validateable {

    private long timeInMicroSeconds;

    public RecoverPointTimeStamp() {
    }

    public RecoverPointTimeStamp(long timeInMicroSeconds) {
        this.timeInMicroSeconds = timeInMicroSeconds;
    }

    public long getTimeInMicroSeconds() {
        return timeInMicroSeconds;
    }

    public void setTimeInMicroSeconds(long timeInMicroSeconds) {
        this.timeInMicroSeconds = timeInMicroSeconds;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (timeInMicroSeconds ^ (timeInMicroSeconds >>> 32));
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
        RecoverPointTimeStamp other = (RecoverPointTimeStamp) obj;
        if (timeInMicroSeconds != other.timeInMicroSeconds)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RecoverPointTimeStamp [timeInMicroSeconds=").append(timeInMicroSeconds)
            .append("]");
        return builder.toString();
    }
}
