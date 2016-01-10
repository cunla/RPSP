package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.HashSet;


@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LongTermStatisticsTimeFrames")
public class LongTermStatisticsTimeFrames implements Validateable {

    @XmlElement(required = true)
    private HashSet<LongTermStatisticsTimeFrame> timeFrames;

    public LongTermStatisticsTimeFrames() {
    }

    public LongTermStatisticsTimeFrames(
        HashSet<LongTermStatisticsTimeFrame> timeFrames) {
        this.timeFrames = timeFrames;
    }

    public HashSet<LongTermStatisticsTimeFrame> getTimeFrames() {
        return timeFrames;
    }

    public void setTimeFrames(HashSet<LongTermStatisticsTimeFrame> timeFrames) {
        this.timeFrames = timeFrames;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((timeFrames == null) ? 0 : timeFrames.hashCode());
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
        LongTermStatisticsTimeFrames other = (LongTermStatisticsTimeFrames) obj;
        if (timeFrames == null) {
            if (other.timeFrames != null)
                return false;
        } else if (!timeFrames.equals(other.timeFrames))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LongTermStatisticsTimeFrames [timeFrames=").append(
            timeFrames).append("]");
        return builder.toString();
    }
}
