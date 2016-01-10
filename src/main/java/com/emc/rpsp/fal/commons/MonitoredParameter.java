package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "MonitoredParameter")
public class MonitoredParameter {

    private MonitoredParameterKey key;
    private MonitoredParameterValue value;

    public MonitoredParameter() {
    }

    public MonitoredParameter(MonitoredParameterKey key, MonitoredParameterValue value) {
        this.key = key;
        this.value = value;
    }

    public MonitoredParameterKey getKey() {
        return key;
    }

    public void setKey(MonitoredParameterKey key) {
        this.key = key;
    }

    public MonitoredParameterValue getValue() {
        return value;
    }

    public void setValue(MonitoredParameterValue value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
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
        MonitoredParameter other = (MonitoredParameter) obj;
        if (key == null) {
            if (other.key != null)
                return false;
        } else if (!key.equals(other.key))
            return false;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("MonitoredParameter [key=").append(key).append(
            ", value=").append(value).append("]");
        return builder.toString();
    }
}
