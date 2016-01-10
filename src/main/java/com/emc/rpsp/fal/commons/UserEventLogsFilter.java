package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

@JsonTypeName("UserEventLogsFilter")
@XmlType(name = "UserEventLogsFilter")
public class UserEventLogsFilter extends EventLogsFilter {

    @XmlElement(nillable = true)
    private TimeFrame timeFrame;
    @XmlElement(required = true)
    private HashSet<EventLogTopic> topics;
    @XmlElement(nillable = true)
    private TextFilter textFilter;

    public UserEventLogsFilter() {
    }

    public UserEventLogsFilter(TimeFrame timeFrame, HashSet<EventLogTopic> topics, TextFilter textFilter, EventLogLevel level,
                               EventLogScope scope, HashSet<Integer> eventsIDs) {
        super(level, scope, eventsIDs);
        this.timeFrame = timeFrame;
        this.topics = topics;
        this.textFilter = textFilter;
    }

    public TimeFrame getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(TimeFrame timeFrame) {
        this.timeFrame = timeFrame;
    }

    public HashSet<EventLogTopic> getTopics() {
        return topics;
    }

    public void setTopics(HashSet<EventLogTopic> topics) {
        this.topics = topics;
    }

    public TextFilter getTextFilter() {
        return textFilter;
    }

    public void setTextFilter(TextFilter textFilter) {
        this.textFilter = textFilter;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
            + ((textFilter == null) ? 0 : textFilter.hashCode());
        result = prime * result
            + ((timeFrame == null) ? 0 : timeFrame.hashCode());
        result = prime * result + ((topics == null) ? 0 : topics.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserEventLogsFilter other = (UserEventLogsFilter) obj;
        if (textFilter == null) {
            if (other.textFilter != null)
                return false;
        } else if (!textFilter.equals(other.textFilter))
            return false;
        if (timeFrame == null) {
            if (other.timeFrame != null)
                return false;
        } else if (!timeFrame.equals(other.timeFrame))
            return false;
        if (topics == null) {
            if (other.topics != null)
                return false;
        } else if (!topics.equals(other.topics))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append("UserEventLogsFilter [textFilter=").append(textFilter)
            .append(", timeFrame=").append(timeFrame).append(", topics=")
            .append(topics).append("]");
        return builder.toString();
    }

}
