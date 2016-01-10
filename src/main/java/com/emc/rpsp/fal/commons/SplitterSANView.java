package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SplitterSANView")
////@LargeObject
public class SplitterSANView {

    @XmlElement(nillable = true)
    private SplitterUID splitterUID;
    private HashSet<SplitterVolumeSANInfo> volumes;

    public SplitterSANView() {
    }

    public SplitterSANView(SplitterUID splitterUID, HashSet<SplitterVolumeSANInfo> volumes) {
        this.splitterUID = splitterUID;
        this.volumes = volumes;
    }

    public SplitterUID getSplitterUID() {
        return splitterUID;
    }

    public void setSplitterUID(SplitterUID splitterUID) {
        this.splitterUID = splitterUID;
    }

    public HashSet<SplitterVolumeSANInfo> getVolumes() {
        return volumes;
    }

    public void setVolumes(HashSet<SplitterVolumeSANInfo> volumes) {
        this.volumes = volumes;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((splitterUID == null) ? 0 : splitterUID.hashCode());
        result = prime * result + ((volumes == null) ? 0 : volumes.hashCode());
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
        SplitterSANView other = (SplitterSANView) obj;
        if (splitterUID == null) {
            if (other.splitterUID != null)
                return false;
        } else if (!splitterUID.equals(other.splitterUID))
            return false;
        if (volumes == null) {
            if (other.volumes != null)
                return false;
        } else if (!volumes.equals(other.volumes))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SplitterSANView [splitterUID=").append(splitterUID)
            .append(", volumes=").append(volumes).append("]");
        return builder.toString();
    }
}
