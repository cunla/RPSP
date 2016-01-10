package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement

@JsonTypeName("CollectLogsSplitterResultValue")
@XmlType(name = "CollectLogsSplitterResultValue")
public class CollectLogsSplitterResultValue extends CollectLogsResultValue {

    private SplitterUID splitter;

    public CollectLogsSplitterResultValue() {
    }

    public CollectLogsSplitterResultValue(SplitterUID splitter, boolean isSuccess, String message) {
        super(isSuccess, message);
        this.splitter = splitter;
    }

    public SplitterUID getSplitter() {
        return splitter;
    }

    public void setSplitter(SplitterUID splitter) {
        this.splitter = splitter;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
            + ((splitter == null) ? 0 : splitter.hashCode());
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
        CollectLogsSplitterResultValue other = (CollectLogsSplitterResultValue) obj;
        if (splitter == null) {
            if (other.splitter != null)
                return false;
        } else if (!splitter.equals(other.splitter))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append("CollectLogsSplitterResultValue [splitter=").append(
            splitter).append(", super=").append(super.toString()).append("]");
        return builder.toString();
    }
}
