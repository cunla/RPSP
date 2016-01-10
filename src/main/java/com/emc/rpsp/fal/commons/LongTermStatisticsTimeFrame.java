package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;


@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LongTermStatisticsTimeFrame")
public class LongTermStatisticsTimeFrame implements Validateable {

    @XmlElement(required = true)
    private StatisticsGranularity granularity;
    @XmlElement(nillable = true)
    private TimeFrame timeFrame;

    public LongTermStatisticsTimeFrame() {
    }

    public LongTermStatisticsTimeFrame(StatisticsGranularity granularity,
                                       TimeFrame timeFrame) {
        this.granularity = granularity;
        this.timeFrame = timeFrame;
    }

    public StatisticsGranularity getGranularity() {
        return granularity;
    }

    public void setGranularity(StatisticsGranularity granularity) {
        this.granularity = granularity;
    }

    public TimeFrame getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(TimeFrame timeFrame) {
        this.timeFrame = timeFrame;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((granularity == null) ? 0 : granularity.hashCode());
        result = prime * result
            + ((timeFrame == null) ? 0 : timeFrame.hashCode());
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
        LongTermStatisticsTimeFrame other = (LongTermStatisticsTimeFrame) obj;
        if (granularity == null) {
            if (other.granularity != null)
                return false;
        } else if (!granularity.equals(other.granularity))
            return false;
        if (timeFrame == null) {
            if (other.timeFrame != null)
                return false;
        } else if (!timeFrame.equals(other.timeFrame))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LongTermStatisticsTimeFrame [granularity=").append(
            granularity).append(", timeFrame=").append(timeFrame).append(
            "]");
        return builder.toString();
    }
}
