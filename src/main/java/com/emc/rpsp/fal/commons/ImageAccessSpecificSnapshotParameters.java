package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

@JsonTypeName("ImageAccessSpecificSnapshotParameters")
@XmlType(name = "ImageAccessSpecificSnapshotParameters")
public class ImageAccessSpecificSnapshotParameters extends ImageAccessGeneralParameters {

    @XmlElement(nillable = true, required = true)
    private Snapshot snapshot;
    @XmlElement(required = true)
    private ImageAccessMode mode;

    public ImageAccessSpecificSnapshotParameters() {
    }

    public ImageAccessSpecificSnapshotParameters(ImageAccessScenario scenario, ImageAccessTargetVirtualNetworkParam targetNetwork,
                                                 Snapshot snapshot, ImageAccessMode mode) {
        super(scenario, targetNetwork);
        this.snapshot = snapshot;
        this.mode = mode;
    }

    public Snapshot getSnapshot() {
        return snapshot;
    }

    public void setSnapshot(Snapshot snapshot) {
        this.snapshot = snapshot;
    }

    public ImageAccessMode getMode() {
        return mode;
    }

    public void setMode(ImageAccessMode mode) {
        this.mode = mode;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((mode == null) ? 0 : mode.hashCode());
        result = prime * result
            + ((snapshot == null) ? 0 : snapshot.hashCode());
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
        ImageAccessSpecificSnapshotParameters other = (ImageAccessSpecificSnapshotParameters) obj;
        if (mode != other.mode)
            return false;
        if (snapshot == null) {
            if (other.snapshot != null)
                return false;
        } else if (!snapshot.equals(other.snapshot))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ImageAccessSpecificSnapshotParameters [snapshot=")
            .append(snapshot).append(", mode=").append(mode)
            .append(", super=").append(super.toString()).append("]");
        return builder.toString();
    }
}
