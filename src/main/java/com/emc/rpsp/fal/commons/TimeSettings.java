package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("serial")
@XmlRootElement
@XmlType(name = "TimeSettings")
public class TimeSettings implements Validateable {

    private boolean useClustersTimeZones;

    public TimeSettings() {
    }

    public TimeSettings(boolean useClustersTimeZones) {
        this.useClustersTimeZones = useClustersTimeZones;
    }

    public boolean getUseClustersTimeZones() {
        return useClustersTimeZones;
    }

    public void setUseClustersTimeZones(boolean useClustersTimeZones) {
        this.useClustersTimeZones = useClustersTimeZones;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (useClustersTimeZones ? 1231 : 1237);
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
        TimeSettings other = (TimeSettings) obj;
        if (useClustersTimeZones != other.useClustersTimeZones)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TimeSettings [useClustersTimeZones=").append(
            useClustersTimeZones).append("]");
        return builder.toString();
    }
}
