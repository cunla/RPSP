package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SplitterInfo")
public class SplitterInfo implements Validateable {

    @XmlElement(nillable = true, required = true)
    private SplitterUID splitterUID;
    @XmlElement(required = true)
    private String splitterName;

    public SplitterInfo() {
    }

    public SplitterInfo(SplitterUID splitterUID, String splitterName) {
        this.splitterUID = splitterUID;
        this.splitterName = splitterName;
    }

    public SplitterUID getSplitterUID() {
        return splitterUID;
    }

    public void setSplitterUID(SplitterUID splitterUID) {
        this.splitterUID = splitterUID;
    }

    public String getSplitterName() {
        return splitterName;
    }

    public void setSplitterName(String splitterName) {
        this.splitterName = splitterName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((splitterUID == null) ? 0 : splitterUID.hashCode());
        result = prime * result
            + ((splitterName == null) ? 0 : splitterName.hashCode());
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
        SplitterInfo other = (SplitterInfo) obj;
        if (splitterUID == null) {
            if (other.splitterUID != null)
                return false;
        } else if (!splitterUID.equals(other.splitterUID))
            return false;
        if (splitterName == null) {
            if (other.splitterName != null)
                return false;
        } else if (!splitterName.equals(other.splitterName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SplitterInfo [splitterUID=").append(splitterUID)
            .append(", splitterName=").append(splitterName).append("]");
        return builder.toString();
    }
}
