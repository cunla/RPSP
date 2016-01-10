package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
@JsonTypeName("VCenterServerLunFilter")
@XmlType(name = "VCenterServerLunFilter")
public class VCenterServerLunFilter extends VCenterServerFilter {

    @XmlElement(required = true)
    private DeviceUID lunID;

    public VCenterServerLunFilter() {
    }

    public VCenterServerLunFilter(VCenterServerFilterType filterType,
                                  String filteredEntityName, DeviceUID lunID) {
        super(filterType, filteredEntityName);
        this.lunID = lunID;
    }

    public DeviceUID getLunID() {
        return lunID;
    }

    public void setLunID(DeviceUID lunID) {
        this.lunID = lunID;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((lunID == null) ? 0 : lunID.hashCode());
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
        VCenterServerLunFilter other = (VCenterServerLunFilter) obj;
        if (lunID == null) {
            if (other.lunID != null)
                return false;
        } else if (!lunID.equals(other.lunID))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append("VCenterServerLunFilter [lunID=").append(lunID).append(", super=").append(super.toString()).append("]");
        return builder.toString();
    }
}
