package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "MonitoredParameterValue")
public class MonitoredParameterValue {

    private boolean reverseWaterMarksDirection;
    private MonitoredParameterWaterMarks parameterWaterMarks;
    private long value;

    public MonitoredParameterValue() {
    }

    public MonitoredParameterValue(boolean reverseWaterMarksDirection, MonitoredParameterWaterMarks parameterWaterMarks, long value) {
        this.reverseWaterMarksDirection = reverseWaterMarksDirection;
        this.parameterWaterMarks = parameterWaterMarks;
        this.value = value;
    }

    public boolean getReverseWaterMarksDirection() {
        return reverseWaterMarksDirection;
    }

    public void setReverseWaterMarksDirection(boolean reverseWaterMarksDirection) {
        this.reverseWaterMarksDirection = reverseWaterMarksDirection;
    }

    public MonitoredParameterWaterMarks getParameterWaterMarks() {
        return parameterWaterMarks;
    }

    public void setParameterWaterMarks(
        MonitoredParameterWaterMarks parameterWaterMarks) {
        this.parameterWaterMarks = parameterWaterMarks;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((parameterWaterMarks == null) ? 0 : parameterWaterMarks
            .hashCode());
        result = prime * result + (reverseWaterMarksDirection ? 1231 : 1237);
        result = prime * result + (int) (value ^ (value >>> 32));
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
        MonitoredParameterValue other = (MonitoredParameterValue) obj;
        if (parameterWaterMarks == null) {
            if (other.parameterWaterMarks != null)
                return false;
        } else if (!parameterWaterMarks.equals(other.parameterWaterMarks))
            return false;
        if (reverseWaterMarksDirection != other.reverseWaterMarksDirection)
            return false;
        if (value != other.value)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("MonitoredParameterValue [parameterWaterMarks=").append(
            parameterWaterMarks).append(", reverseWaterMarksDirection=")
            .append(reverseWaterMarksDirection).append(", value=").append(
            value).append("]");
        return builder.toString();
    }
}
