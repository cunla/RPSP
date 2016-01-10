package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("serial")
@XmlRootElement
@XmlType(name = "VCenterServersViewSettings")
public class VCenterServersViewSettings implements Validateable {

    private boolean vcenterServersFiltersEnabled;

    public VCenterServersViewSettings() {
    }

    public VCenterServersViewSettings(boolean vCenterServersFiltersEnabled) {
        this.vcenterServersFiltersEnabled = vCenterServersFiltersEnabled;
    }

    public boolean isVcenterServersFiltersEnabled() {
        return vcenterServersFiltersEnabled;
    }

    public void setVcenterServersFiltersEnabled(boolean vcenterServersFiltersEnabled) {
        this.vcenterServersFiltersEnabled = vcenterServersFiltersEnabled;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (vcenterServersFiltersEnabled ? 1231 : 1237);
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
        VCenterServersViewSettings other = (VCenterServersViewSettings) obj;
        if (vcenterServersFiltersEnabled != other.vcenterServersFiltersEnabled)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(
            "VCenterServersViewSettings [vcenterServersFiltersEnabled=")
            .append(vcenterServersFiltersEnabled).append("]");
        return builder.toString();
    }
}
