package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

@JsonTypeName("RemoteISCSIPortInformation")
@XmlType(name = "RemoteISCSIPortInformation")
public class RemoteISCSIPortInformation extends ISCSIPortInformation {

    @XmlElement(nillable = true)
    private IPInformation ipInformation;

    public RemoteISCSIPortInformation() {
        super();
    }

    public RemoteISCSIPortInformation(IPInformation ipInformation, int port,
                                      Chap chap) {
        super(port, chap);
        this.ipInformation = ipInformation;
    }

    public IPInformation getIpInformation() {
        return ipInformation;
    }

    public void setIpInformation(IPInformation ipInformation) {
        this.ipInformation = ipInformation;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
            + ((ipInformation == null) ? 0 : ipInformation.hashCode());
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
        RemoteISCSIPortInformation other = (RemoteISCSIPortInformation) obj;
        if (ipInformation == null) {
            if (other.ipInformation != null)
                return false;
        } else if (!ipInformation.equals(other.ipInformation))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RemoteISCSIPortInformation [ipInformation=")
            .append(ipInformation).append(", super=").append(super.toString()).append("]");
        return builder.toString();
    }

}
