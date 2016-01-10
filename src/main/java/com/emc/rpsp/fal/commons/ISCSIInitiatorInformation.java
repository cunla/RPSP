package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement

@JsonTypeName("ISCSIInitiatorInformation")
@XmlType(name = "ISCSIInitiatorInformation")
public class ISCSIInitiatorInformation extends InitiatorInformation {

    private String iqn;

    public ISCSIInitiatorInformation() {
    }

    public ISCSIInitiatorInformation(String iqn) {
        this.iqn = iqn;
    }

    public String getIqn() {
        return iqn;
    }

    public void setIqn(String iqn) {
        this.iqn = iqn;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((iqn == null) ? 0 : iqn.hashCode());
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
        ISCSIInitiatorInformation other = (ISCSIInitiatorInformation) obj;
        if (iqn == null) {
            if (other.iqn != null)
                return false;
        } else if (!iqn.equals(other.iqn))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ISCSIInitiatorInformation [iqn=").append(iqn).append("]");
        return builder.toString();
    }

}
