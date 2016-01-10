package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
@JsonTypeName("ImageAccessTargetVirtualNetworkManualSelectionParam")
@XmlType(name = "ImageAccessTargetVirtualNetworkManualSelectionParam")
public class ImageAccessTargetVirtualNetworkManualSelectionParam extends ImageAccessTargetVirtualNetworkParam {

    @XmlElement(required = true)
    private VirtualNetworkUID networkUID;

    public ImageAccessTargetVirtualNetworkManualSelectionParam() {
    }

    public ImageAccessTargetVirtualNetworkManualSelectionParam(VirtualNetworkUID networkUID) {
        this.networkUID = networkUID;
    }

    public VirtualNetworkUID getNetworkUID() {
        return networkUID;
    }

    public void setNetworkUID(VirtualNetworkUID networkUID) {
        this.networkUID = networkUID;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((networkUID == null) ? 0 : networkUID.hashCode());
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
        ImageAccessTargetVirtualNetworkManualSelectionParam other = (ImageAccessTargetVirtualNetworkManualSelectionParam) obj;
        if (networkUID == null) {
            if (other.networkUID != null)
                return false;
        } else if (!networkUID.equals(other.networkUID))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(
            "ImageAccessTargetVirtualNetworkManualSelectionParam [networkUID=")
            .append(networkUID).append("]");
        return builder.toString();
    }
}
