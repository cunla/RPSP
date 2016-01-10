package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.HashSet;


@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SyslogSettings")
public class SyslogSettings implements Validateable {

    private boolean enabled;
    @XmlElement(required = true)
    private SyslogFacility facility;
    private HashSet<SystemEventLogsFilterUID> sendEventFilters;
    private HashSet<ClusterSyslogHost> clustersHosts;

    public SyslogSettings() {
    }

    public SyslogSettings(boolean enabled, SyslogFacility facility, HashSet<SystemEventLogsFilterUID> sendEventFilters,
                          HashSet<ClusterSyslogHost> clustersHosts) {
        this.enabled = enabled;
        this.facility = facility;
        this.sendEventFilters = sendEventFilters;
        this.clustersHosts = clustersHosts;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public SyslogFacility getFacility() {
        return facility;
    }

    public void setFacility(SyslogFacility facility) {
        this.facility = facility;
    }

    public HashSet<SystemEventLogsFilterUID> getSendEventFilters() {
        return sendEventFilters;
    }

    public void setSendEventFilters(
        HashSet<SystemEventLogsFilterUID> sendEventFilters) {
        this.sendEventFilters = sendEventFilters;
    }

    public HashSet<ClusterSyslogHost> getClustersHosts() {
        return clustersHosts;
    }

    public void setClustersHosts(HashSet<ClusterSyslogHost> clustersHosts) {
        this.clustersHosts = clustersHosts;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (enabled ? 1231 : 1237);
        result = prime * result
            + ((facility == null) ? 0 : facility.hashCode());
        result = prime * result + ((sendEventFilters == null) ? 0 : sendEventFilters.hashCode());
        result = prime * result
            + ((clustersHosts == null) ? 0 : clustersHosts.hashCode());
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
        SyslogSettings other = (SyslogSettings) obj;
        if (enabled != other.enabled)
            return false;
        if (facility == null) {
            if (other.facility != null)
                return false;
        } else if (!facility.equals(other.facility))
            return false;
        if (sendEventFilters == null) {
            if (other.sendEventFilters != null)
                return false;
        } else if (!sendEventFilters.equals(other.sendEventFilters))
            return false;
        if (clustersHosts == null) {
            if (other.clustersHosts != null)
                return false;
        } else if (!clustersHosts.equals(other.clustersHosts))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SyslogSettings [enabled=").append(enabled).append(
            ", facility=").append(facility).append(", level=")
            .append(sendEventFilters).append(", clustersHosts=").append(clustersHosts)
            .append("]");
        return builder.toString();
    }
}
