package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LinkAdvancedPolicy")
public class LinkAdvancedPolicy implements Validateable {

    private boolean performLongInitialization;
    @XmlElement(nillable = true, required = true)
    private SnapshotGranularity snapshotGranularity;

    public LinkAdvancedPolicy() {
    }

    public LinkAdvancedPolicy(boolean performLongInitialization, SnapshotGranularity snapshotGranularity) {
        this.performLongInitialization = performLongInitialization;
        this.snapshotGranularity = snapshotGranularity;
    }

    public boolean getPerformLongInitialization() {
        return performLongInitialization;
    }

    public void setPerformLongInitialization(boolean performLongInitialization) {
        this.performLongInitialization = performLongInitialization;
    }

    public SnapshotGranularity getSnapshotGranularity() {
        return snapshotGranularity;
    }

    public void setSnapshotGranularity(SnapshotGranularity snapshotGranularity) {
        this.snapshotGranularity = snapshotGranularity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((snapshotGranularity == null) ? 0 : snapshotGranularity.hashCode());
        result = prime * result + (performLongInitialization ? 1231 : 1237);
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
        LinkAdvancedPolicy other = (LinkAdvancedPolicy) obj;
        if (snapshotGranularity == null) {
            if (other.snapshotGranularity != null)
                return false;
        } else if (!snapshotGranularity.equals(other.snapshotGranularity))
            return false;
        if (performLongInitialization != other.performLongInitialization)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LinkAdvancedPolicy [snapshotGranularity=").append(
            snapshotGranularity).append(", performLongInitialization=").append(
            performLongInitialization).append("]");
        return builder.toString();
    }
}
