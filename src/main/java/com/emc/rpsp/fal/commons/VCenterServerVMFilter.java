package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
@JsonTypeName("VCenterServerVMFilter")
@XmlType(name = "VCenterServerVMFilter")
public class VCenterServerVMFilter extends VCenterServerFilter {

    @XmlElement(required = true)
    private String ip;

    public VCenterServerVMFilter() {
    }

    public VCenterServerVMFilter(VCenterServerFilterType filterType, String filteredEntityName, String ip) {
        super(filterType, filteredEntityName);
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((ip == null) ? 0 : ip.hashCode());
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
        VCenterServerVMFilter other = (VCenterServerVMFilter) obj;
        if (ip == null) {
            if (other.ip != null)
                return false;
        } else if (!ip.equals(other.ip))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append("VCenterServerVMFilter [ip=").append(ip).append(", super=").append(super.toString()).append("]");
        return builder.toString();
    }
}
