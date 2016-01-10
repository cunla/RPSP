package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement

@JsonTypeName("CollectLogsRPAResultValue")
@XmlType(name = "CollectLogsRPAResultValue")
public class CollectLogsRPAResultValue extends CollectLogsResultValue {

    private RpaUID rpa;

    public CollectLogsRPAResultValue() {
    }

    public CollectLogsRPAResultValue(RpaUID rpa, boolean isSuccess, String message) {
        super(isSuccess, message);
        this.rpa = rpa;
    }

    public RpaUID getRpa() {
        return rpa;
    }

    public void setRpa(RpaUID rpa) {
        this.rpa = rpa;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((rpa == null) ? 0 : rpa.hashCode());
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
        CollectLogsRPAResultValue other = (CollectLogsRPAResultValue) obj;
        if (rpa == null) {
            if (other.rpa != null)
                return false;
        } else if (!rpa.equals(other.rpa))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append("CollectLogsRPAResultValue [rpa=").append(rpa).append(", super=").append(super.toString()).append(
            "]");
        return builder.toString();
    }
}
