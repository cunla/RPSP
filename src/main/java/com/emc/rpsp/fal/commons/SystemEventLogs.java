package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlRootElement
@XmlType(name = "SystemEventLogs")
////@LargeObject
public class SystemEventLogs {

    private List<EventLog> eventLogs;

    public SystemEventLogs() {
    }

    public SystemEventLogs(List<EventLog> eventLogs) {
        this.eventLogs = eventLogs;
    }

    /**
     * @return the eventLogList
     */
    public List<EventLog> getEventLogs() {
        return eventLogs;
    }

    /**
     * @param eventLogs the eventLogs to set
     */
    public void setEventLogs(List<EventLog> eventLogs) {
        this.eventLogs = eventLogs;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((eventLogs == null) ? 0 : eventLogs.hashCode());
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
        SystemEventLogs other = (SystemEventLogs) obj;
        if (eventLogs == null) {
            if (other.eventLogs != null)
                return false;
        } else if (!eventLogs.equals(other.eventLogs))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SystemEventLogs [eventLogs=").append(eventLogs).append(
            "]");
        return builder.toString();
    }
}
