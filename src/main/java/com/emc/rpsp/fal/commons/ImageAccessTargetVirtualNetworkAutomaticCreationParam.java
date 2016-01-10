package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("serial")
@XmlRootElement

@JsonTypeName("ImageAccessTargetVirtualNetworkAutomaticCreationParam")
@XmlType(name = "ImageAccessTargetVirtualNetworkAutomaticCreationParam")
public class ImageAccessTargetVirtualNetworkAutomaticCreationParam extends ImageAccessTargetVirtualNetworkParam {

    private boolean sharedNetwork;

    public ImageAccessTargetVirtualNetworkAutomaticCreationParam() {
    }

    public ImageAccessTargetVirtualNetworkAutomaticCreationParam(boolean sharedNetwork) {
        this.sharedNetwork = sharedNetwork;
    }

    public boolean isSharedNetwork() {
        return sharedNetwork;
    }

    public void setSharedNetwork(boolean sharedNetwork) {
        this.sharedNetwork = sharedNetwork;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (sharedNetwork ? 1231 : 1237);
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
        ImageAccessTargetVirtualNetworkAutomaticCreationParam other = (ImageAccessTargetVirtualNetworkAutomaticCreationParam) obj;
        if (sharedNetwork != other.sharedNetwork)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(
            "ImageAccessTargetVirtualNetworkAutomaticCreationParam [sharedNetwork=")
            .append(sharedNetwork).append("]");
        return builder.toString();
    }
}
