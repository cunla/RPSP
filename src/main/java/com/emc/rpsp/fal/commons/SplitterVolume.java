package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

@XmlSeeAlso({SplitterVolumeSANInfo.class})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "JsonSubType")
@JsonSubTypes({
    @Type(value = SplitterVolumeSANInfo.class, name = "SplitterVolumeSANInfo")})
@XmlType(name = "SplitterVolume")
public class SplitterVolume {

    @XmlElement(nillable = true)
    private SplitterUID splitterUID;
    @XmlElement(nillable = true)
    private DeviceUID deviceUID;

    public SplitterVolume() {
    }

    public SplitterVolume(SplitterUID splitterUID, DeviceUID deviceUID) {
        this.splitterUID = splitterUID;
        this.deviceUID = deviceUID;
    }

    /**
     * @return the splitterUID
     */
    public SplitterUID getSplitterUID() {
        return splitterUID;
    }

    /**
     * @param splitterUID the splitterUID to set
     */
    public void setSplitterUID(SplitterUID splitterUID) {
        this.splitterUID = splitterUID;
    }

    /**
     * @return the deviceUID
     */
    public DeviceUID getDeviceUID() {
        return deviceUID;
    }

    /**
     * @param deviceUID the deviceUID to set
     */
    public void setDeviceUID(DeviceUID deviceUID) {
        this.deviceUID = deviceUID;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((deviceUID == null) ? 0 : deviceUID.hashCode());
        result = prime * result
            + ((splitterUID == null) ? 0 : splitterUID.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof SplitterVolume))
            return false;
        SplitterVolume other = (SplitterVolume) obj;
        if (deviceUID == null) {
            if (other.deviceUID != null)
                return false;
        } else if (!deviceUID.equals(other.deviceUID))
            return false;
        if (splitterUID == null) {
            if (other.splitterUID != null)
                return false;
        } else if (!splitterUID.equals(other.splitterUID))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SplitterVolume [deviceUID=").append(deviceUID).append(
            ", splitterUID=").append(splitterUID).append("]");
        return builder.toString();
    }
}
