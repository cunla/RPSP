package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)

@XmlSeeAlso({ISCSIPath.class, FiberChannelPath.class, DataCommPath.class})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "JsonSubType")
@JsonSubTypes({
    @Type(value = ISCSIPath.class, name = "ISCSIPath"),
    @Type(value = FiberChannelPath.class, name = "FiberChannelPath"),
    @Type(value = DataCommPath.class, name = "DataCommPath")})
@XmlType(name = "Path")
public abstract
@XmlRootElement
class Path {

    @XmlElement(nillable = true)
    private RpaUID rpaUID;

    public Path() {
    }

    public Path(RpaUID rpaUID) {
        this.rpaUID = rpaUID;
    }

    public RpaUID getRpaUID() {
        return rpaUID;
    }

    public void setRpaUID(RpaUID rpaUID) {
        this.rpaUID = rpaUID;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((rpaUID == null) ? 0 : rpaUID.hashCode());
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
        Path other = (Path) obj;
        if (rpaUID == null) {
            if (other.rpaUID != null)
                return false;
        } else if (!rpaUID.equals(other.rpaUID))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Path [rpaUID=").append(rpaUID).append("]");
        return builder.toString();
    }
}
