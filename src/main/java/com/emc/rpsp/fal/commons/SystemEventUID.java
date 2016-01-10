package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("serial")
@XmlRootElement
@XmlType(name = "SystemEventUID")
public class SystemEventUID implements Validateable {

    private long uniqueId;

    public SystemEventUID() {
    }

    public SystemEventUID(long uniqueId) {
        this.uniqueId = uniqueId;
    }

    public long getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(long uniqueId) {
        this.uniqueId = uniqueId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (uniqueId ^ (uniqueId >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof SystemEventUID))
            return false;
        SystemEventUID other = (SystemEventUID) obj;
        if (uniqueId != other.uniqueId)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SystemEventUID [uniqueId=").append(uniqueId)
            .append("]");
        return builder.toString();
    }
}
