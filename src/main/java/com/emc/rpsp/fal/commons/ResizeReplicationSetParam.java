package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("serial")
@XmlRootElement
@XmlType(name = "ResizeReplicationSetParam")
public class ResizeReplicationSetParam implements Validateable {

    private long newSizeInBytes;
    private boolean additionalSpaceClean;

    public ResizeReplicationSetParam() {
    }

    public ResizeReplicationSetParam(long newSizeInBytes, boolean isAdditionalSpaceClean) {
        this.newSizeInBytes = newSizeInBytes;
        this.additionalSpaceClean = isAdditionalSpaceClean;
    }

    public long getNewSizeInBytes() {
        return newSizeInBytes;
    }

    public void setNewSizeInBytes(long newSizeInBytes) {
        this.newSizeInBytes = newSizeInBytes;
    }

    public boolean isAdditionalSpaceClean() {
        return additionalSpaceClean;
    }

    public void setAdditionalSpaceClean(boolean isAdditionalSpaceClean) {
        this.additionalSpaceClean = isAdditionalSpaceClean;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (additionalSpaceClean ? 1231 : 1237);
        result = prime * result
            + (int) (newSizeInBytes ^ (newSizeInBytes >>> 32));
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
        ResizeReplicationSetParam other = (ResizeReplicationSetParam) obj;
        if (additionalSpaceClean != other.additionalSpaceClean)
            return false;
        if (newSizeInBytes != other.newSizeInBytes)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ResizeReplicationSetParam [newSizeInBytes=")
            .append(newSizeInBytes).append(", additionalSpaceClean=")
            .append(additionalSpaceClean).append("]");
        return builder.toString();
    }

}
