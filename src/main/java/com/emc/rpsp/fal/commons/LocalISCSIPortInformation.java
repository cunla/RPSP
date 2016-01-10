package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

@JsonTypeName("LocalISCSIPortInformation")
@XmlType(name = "LocalISCSIPortInformation")
public class LocalISCSIPortInformation extends ISCSIPortInformation {

    @XmlElement(nillable = true)
    private NICInformation nicInformation;

    public LocalISCSIPortInformation() {
        super();
    }

    public LocalISCSIPortInformation(NICInformation nicInformation, int port,
                                     Chap chap) {
        super(port, chap);
        this.nicInformation = nicInformation;
    }

    public NICInformation getNicInformation() {
        return nicInformation;
    }

    public void setNicInformation(NICInformation nicInformation) {
        this.nicInformation = nicInformation;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
            + ((nicInformation == null) ? 0 : nicInformation.hashCode());
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
        LocalISCSIPortInformation other = (LocalISCSIPortInformation) obj;
        if (nicInformation == null) {
            if (other.nicInformation != null)
                return false;
        } else if (!nicInformation.equals(other.nicInformation))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LocalISCSIPortInformation [nicInformation=")
            .append(nicInformation).append(", super=").append(super.toString()).append("]");
        return builder.toString();
    }

}
