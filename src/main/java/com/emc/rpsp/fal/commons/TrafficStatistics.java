package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@XmlRootElement
@XmlType(name = "TrafficStatistics")
public class TrafficStatistics {

    private HashSet<ConnectionCompressionRatio> connectionsCompressionRatio;
    private InOutThroughputStatistics applicationThroughputStatistics;
    private long applicationIncomingWrites;
    private InOutThroughputStatistics initThroughputStatistics;

    public TrafficStatistics() {
    }

    public TrafficStatistics(HashSet<ConnectionCompressionRatio> connectionsCompressionRatio,
                             InOutThroughputStatistics applicationThroughputStatistics,
                             long applicationIncomingWrites,
                             InOutThroughputStatistics initThroughputStatistics) {
        this.connectionsCompressionRatio = connectionsCompressionRatio;
        this.applicationThroughputStatistics = applicationThroughputStatistics;
        this.applicationIncomingWrites = applicationIncomingWrites;
        this.initThroughputStatistics = initThroughputStatistics;
    }

    public HashSet<ConnectionCompressionRatio> getConnectionsCompressionRatio() {
        return connectionsCompressionRatio;
    }

    public void setConnectionsCompressionRatio(
        HashSet<ConnectionCompressionRatio> connectionsCompressionRatio) {
        this.connectionsCompressionRatio = connectionsCompressionRatio;
    }

    public InOutThroughputStatistics getApplicationThroughputStatistics() {
        return applicationThroughputStatistics;
    }

    public void setApplicationThroughputStatistics(
        InOutThroughputStatistics applicationThroughputStatistics) {
        this.applicationThroughputStatistics = applicationThroughputStatistics;
    }

    public long getApplicationIncomingWrites() {
        return applicationIncomingWrites;
    }

    public void setApplicationIncomingWrites(long applicationIncomingWrites) {
        this.applicationIncomingWrites = applicationIncomingWrites;
    }

    public InOutThroughputStatistics getInitThroughputStatistics() {
        return initThroughputStatistics;
    }

    public void setInitThroughputStatistics(
        InOutThroughputStatistics initThroughputStatistics) {
        this.initThroughputStatistics = initThroughputStatistics;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + (int) (applicationIncomingWrites ^ (applicationIncomingWrites >>> 32));
        result = prime
            * result
            + ((applicationThroughputStatistics == null) ? 0
            : applicationThroughputStatistics.hashCode());
        result = prime
            * result
            + ((connectionsCompressionRatio == null) ? 0
            : connectionsCompressionRatio.hashCode());
        result = prime
            * result
            + ((initThroughputStatistics == null) ? 0
            : initThroughputStatistics.hashCode());
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
        TrafficStatistics other = (TrafficStatistics) obj;
        if (applicationIncomingWrites != other.applicationIncomingWrites)
            return false;
        if (applicationThroughputStatistics == null) {
            if (other.applicationThroughputStatistics != null)
                return false;
        } else if (!applicationThroughputStatistics
            .equals(other.applicationThroughputStatistics))
            return false;
        if (connectionsCompressionRatio == null) {
            if (other.connectionsCompressionRatio != null)
                return false;
        } else if (!connectionsCompressionRatio
            .equals(other.connectionsCompressionRatio))
            return false;
        if (initThroughputStatistics == null) {
            if (other.initThroughputStatistics != null)
                return false;
        } else if (!initThroughputStatistics
            .equals(other.initThroughputStatistics))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TrafficStatistics [connectionsCompressionRatio=")
            .append(connectionsCompressionRatio)
            .append(", applicationThroughputStatistics=")
            .append(applicationThroughputStatistics)
            .append(", applicationIncomingWrites=")
            .append(applicationIncomingWrites)
            .append(", initThroughputStatistics=")
            .append(initThroughputStatistics).append("]");
        return builder.toString();
    }

}
