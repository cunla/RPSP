package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VCenterServerFilters")
public class VCenterServerFilters implements Validateable {

    @XmlElement(required = true)
    private VCenterServerUID vcenterServer;
    @XmlElement(required = true)
    private HashSet<VCenterServerFilter> filters;
    private boolean filterUnknownLuns;

    public VCenterServerFilters() {
    }

    public VCenterServerFilters(VCenterServerUID vCenterServer, HashSet<VCenterServerFilter> filters, boolean filterUnknownLuns) {
        this.vcenterServer = vCenterServer;
        this.filters = filters;
        this.filterUnknownLuns = filterUnknownLuns;
    }

    public VCenterServerUID getVcenterServer() {
        return vcenterServer;
    }

    public void setVcenterServer(VCenterServerUID vcenterServer) {
        this.vcenterServer = vcenterServer;
    }

    public HashSet<VCenterServerFilter> getFilters() {
        return filters;
    }

    public void setFilters(HashSet<VCenterServerFilter> filters) {
        this.filters = filters;
    }

    public boolean getFilterUnknownLuns() {
        return filterUnknownLuns;
    }

    public void setFilterUnknownLuns(boolean filterUnknownLuns) {
        this.filterUnknownLuns = filterUnknownLuns;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (filterUnknownLuns ? 1231 : 1237);
        result = prime * result + ((filters == null) ? 0 : filters.hashCode());
        result = prime * result
            + ((vcenterServer == null) ? 0 : vcenterServer.hashCode());
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
        VCenterServerFilters other = (VCenterServerFilters) obj;
        if (filterUnknownLuns != other.filterUnknownLuns)
            return false;
        if (filters == null) {
            if (other.filters != null)
                return false;
        } else if (!filters.equals(other.filters))
            return false;
        if (vcenterServer == null) {
            if (other.vcenterServer != null)
                return false;
        } else if (!vcenterServer.equals(other.vcenterServer))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("VCenterServerFilters [filterUnknownLuns=").append(
            filterUnknownLuns).append(", filters=").append(filters).append(
            ", vcenterServer=").append(vcenterServer).append("]");
        return builder.toString();
    }
}
