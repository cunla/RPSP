package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SyncReplicationThreshold")
public class SyncReplicationThreshold implements Validateable {

    private boolean thresholdEnabled;
    @XmlElement(required = true)
    private Quantity startAsyncReplicationAbove;
    @XmlElement(required = true)
    private Quantity resumeSyncReplicationBelow;

    public SyncReplicationThreshold() {
    }

    public SyncReplicationThreshold(boolean thresholdEnabled, Quantity startAsyncReplicationAbove, Quantity resumeSyncReplicationBelow) {
        this.thresholdEnabled = thresholdEnabled;
        this.startAsyncReplicationAbove = startAsyncReplicationAbove;
        this.resumeSyncReplicationBelow = resumeSyncReplicationBelow;
    }

    public boolean getThresholdEnabled() {
        return thresholdEnabled;
    }

    public void setThresholdEnabled(boolean thresholdEnabled) {
        this.thresholdEnabled = thresholdEnabled;
    }

    public Quantity getStartAsyncReplicationAbove() {
        return startAsyncReplicationAbove;
    }

    public void setStartAsyncReplicationAbove(Quantity startAsyncReplicationAbove) {
        this.startAsyncReplicationAbove = startAsyncReplicationAbove;
    }

    public Quantity getResumeSyncReplicationBelow() {
        return resumeSyncReplicationBelow;
    }

    public void setResumeSyncReplicationBelow(Quantity resumeSyncReplicationBelow) {
        this.resumeSyncReplicationBelow = resumeSyncReplicationBelow;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((resumeSyncReplicationBelow == null) ? 0
            : resumeSyncReplicationBelow.hashCode());
        result = prime
            * result
            + ((startAsyncReplicationAbove == null) ? 0
            : startAsyncReplicationAbove.hashCode());
        result = prime * result + (thresholdEnabled ? 1231 : 1237);
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
        SyncReplicationThreshold other = (SyncReplicationThreshold) obj;
        if (resumeSyncReplicationBelow == null) {
            if (other.resumeSyncReplicationBelow != null)
                return false;
        } else if (!resumeSyncReplicationBelow
            .equals(other.resumeSyncReplicationBelow))
            return false;
        if (startAsyncReplicationAbove == null) {
            if (other.startAsyncReplicationAbove != null)
                return false;
        } else if (!startAsyncReplicationAbove
            .equals(other.startAsyncReplicationAbove))
            return false;
        if (thresholdEnabled != other.thresholdEnabled)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SyncReplicationThreshold [resumeSyncReplicationBelow=")
            .append(resumeSyncReplicationBelow).append(
            ", startAsyncReplicationAbove=").append(
            startAsyncReplicationAbove).append(
            ", thresholdEnabled=").append(thresholdEnabled).append(
            "]");
        return builder.toString();
    }
}
