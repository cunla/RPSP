package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@SuppressWarnings("serial")

@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({SystemEventLogsFilter.class, UserEventLogsFilter.class})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "JsonSubType")
@JsonSubTypes({
    @Type(value = SystemEventLogsFilter.class, name = "SystemEventLogsFilter"),
    @Type(value = UserEventLogsFilter.class, name = "UserEventLogsFilter")})
@XmlType(name = "EventLogsFilter")
public abstract
@XmlRootElement
class EventLogsFilter implements Validateable {

    @XmlElement(required = true)
    private EventLogLevel level;
    @XmlElement(required = true)
    private EventLogScope scope;
    private HashSet<Integer> eventsIDs;

    protected EventLogsFilter() {
    }

    protected EventLogsFilter(EventLogLevel level, EventLogScope scope, HashSet<Integer> eventsIDs) {
        this.level = level;
        this.scope = scope;
        this.eventsIDs = eventsIDs;
    }

    public EventLogLevel getLevel() {
        return level;
    }

    public void setLevel(EventLogLevel level) {
        this.level = level;
    }

    public EventLogScope getScope() {
        return scope;
    }

    public void setScope(EventLogScope scope) {
        this.scope = scope;
    }

    public HashSet<Integer> getEventsIDs() {
        return eventsIDs;
    }

    public void setEventsIDs(HashSet<Integer> eventsIDs) {
        this.eventsIDs = eventsIDs;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((eventsIDs == null) ? 0 : eventsIDs.hashCode());
        result = prime * result + ((level == null) ? 0 : level.hashCode());
        result = prime * result + ((scope == null) ? 0 : scope.hashCode());
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
        EventLogsFilter other = (EventLogsFilter) obj;
        if (eventsIDs == null) {
            if (other.eventsIDs != null)
                return false;
        } else if (!eventsIDs.equals(other.eventsIDs))
            return false;
        if (level == null) {
            if (other.level != null)
                return false;
        } else if (!level.equals(other.level))
            return false;
        if (scope == null) {
            if (other.scope != null)
                return false;
        } else if (!scope.equals(other.scope))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("EventLogsFilter [eventsIDs=").append(eventsIDs).append(
            ", level=").append(level).append(", scope=").append(scope)
            .append("]");
        return builder.toString();
    }
}
