package com.emc.rpsp.fal.commons;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@SuppressWarnings("serial")
@XmlRootElement
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

@XmlAccessorType(XmlAccessType.FIELD)
@JsonTypeName("SystemEventLogsFilter")
@XmlType(name = "SystemEventLogsFilter")
public class SystemEventLogsFilter extends EventLogsFilter {

    private SystemEventLogsFilterUID filterUID;
    @XmlElement(required = true)
    private String name;
    @XmlElement(required = true)
    private EventLogTopic topic;
    private HashSet<ConsistencyGroupUID> groupsToInclude;

    public SystemEventLogsFilter(SystemEventLogsFilterUID filterUID, String name, EventLogLevel level, EventLogScope scope,
                                 HashSet<Integer> eventsIDs, EventLogTopic topic, HashSet<ConsistencyGroupUID> groupsToInclude) {
        super(level, scope, eventsIDs);
        this.filterUID = filterUID;
        this.name = name;
        this.topic = topic;
        this.groupsToInclude = groupsToInclude;
    }

}
