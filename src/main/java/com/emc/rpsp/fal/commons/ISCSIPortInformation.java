package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)

@XmlSeeAlso({LocalISCSIPortInformation.class, RemoteISCSIPortInformation.class})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "JsonSubType")
@JsonSubTypes({
    @Type(value = LocalISCSIPortInformation.class, name = "LocalISCSIPortInformation"),
    @Type(value = RemoteISCSIPortInformation.class, name = "RemoteISCSIPortInformation")})
@XmlType(name = "ISCSIPortInformation")
public abstract
@XmlRootElement
class ISCSIPortInformation {

    private int port;
    @XmlElement(nillable = true)
    private Chap chap;

    public ISCSIPortInformation() {
    }

    public ISCSIPortInformation(int port, Chap chap) {
        this.port = port;
        this.chap = chap;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Chap getChap() {
        return chap;
    }

    public void setChap(Chap chap) {
        this.chap = chap;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((chap == null) ? 0 : chap.hashCode());
        result = prime * result + port;
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
        ISCSIPortInformation other = (ISCSIPortInformation) obj;
        if (chap == null) {
            if (other.chap != null)
                return false;
        } else if (!chap.equals(other.chap))
            return false;
        if (port != other.port)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ISCSIPortInformation [port=").append(port)
            .append(", chap=").append(chap).append("]");
        return builder.toString();
    }

}
