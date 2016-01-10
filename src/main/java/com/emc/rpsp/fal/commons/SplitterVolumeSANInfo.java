package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement

@JsonTypeName("SplitterVolumeSANInfo")
@XmlType(name = "SplitterVolumeSANInfo")
public class SplitterVolumeSANInfo extends SplitterVolume {

    private VolumeSANInfo sanInfo;

    public SplitterVolumeSANInfo() {
    }

    public SplitterVolumeSANInfo(SplitterUID splitterUID, DeviceUID deviceUID, VolumeSANInfo sanInfo) {
        super(splitterUID, deviceUID);
        this.sanInfo = sanInfo;
    }

    public VolumeSANInfo getSanInfo() {
        return sanInfo;
    }

    public void setSanInfo(VolumeSANInfo sanInfo) {
        this.sanInfo = sanInfo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((sanInfo == null) ? 0 : sanInfo.hashCode());
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
        SplitterVolumeSANInfo other = (SplitterVolumeSANInfo) obj;
        if (sanInfo == null) {
            if (other.sanInfo != null)
                return false;
        } else if (!sanInfo.equals(other.sanInfo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SplitterVolumeSANInfo [sanInfo=").append(sanInfo)
            .append(", super=").append(super.toString()).append("]");
        return builder.toString();
    }
}
