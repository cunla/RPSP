package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")

@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({VCenterServerESXFilter.class, VCenterServerLunFilter.class, VCenterServerVMFilter.class})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "JsonSubType")
@JsonSubTypes({
    @Type(value = VCenterServerESXFilter.class, name = "VCenterServerESXFilter"),
    @Type(value = VCenterServerLunFilter.class, name = "VCenterServerLunFilter"),
    @Type(value = VCenterServerVMFilter.class, name = "VCenterServerVMFilter")})
@XmlType(name = "VCenterServerFilter")
public abstract
@XmlRootElement
class VCenterServerFilter implements Validateable {

    @XmlElement(required = true)
    private VCenterServerFilterType filterType;
    @XmlElement(required = true)
    private String filteredEntityName;

    public VCenterServerFilter() {
    }

    protected VCenterServerFilter(VCenterServerFilterType filterType, String filteredEntityName) {
        this.filterType = filterType;
        this.filteredEntityName = filteredEntityName;
    }

    public VCenterServerFilterType getFilterType() {
        return filterType;
    }

    public void setFilterType(VCenterServerFilterType filterType) {
        this.filterType = filterType;
    }

    public String getFilteredEntityName() {
        return filteredEntityName;
    }

    public void setFilteredEntityName(String filteredEntityName) {
        this.filteredEntityName = filteredEntityName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((filterType == null) ? 0 : filterType.hashCode());
        result = prime
            * result
            + ((filteredEntityName == null) ? 0 : filteredEntityName
            .hashCode());
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
        VCenterServerFilter other = (VCenterServerFilter) obj;
        if (filterType == null) {
            if (other.filterType != null)
                return false;
        } else if (!filterType.equals(other.filterType))
            return false;
        if (filteredEntityName == null) {
            if (other.filteredEntityName != null)
                return false;
        } else if (!filteredEntityName.equals(other.filteredEntityName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("VCenterServerFilter [filterType=").append(filterType).append(
            ", filteredEntityName=").append(filteredEntityName).append("]");
        return builder.toString();
    }
}
