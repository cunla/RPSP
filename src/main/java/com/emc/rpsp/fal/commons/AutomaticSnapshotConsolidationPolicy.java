package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("serial")
@XmlRootElement
@XmlType(name = "AutomaticSnapshotConsolidationPolicy")
public class AutomaticSnapshotConsolidationPolicy implements Validateable {

    private boolean enabled;
    private long unconsolidatedDurationInSeconds;
    private long dailyConsolidations; // use -1 value for indefinitely
    private long weeklyConsolidations; // use -1 value for indefinitely

    public AutomaticSnapshotConsolidationPolicy() {
    }

    public AutomaticSnapshotConsolidationPolicy(boolean enabled, long unconsolidatedDurationInSeconds, long dailyConsolidations,
                                                long weeklyConsolidations) {
        this.enabled = enabled;
        this.unconsolidatedDurationInSeconds = unconsolidatedDurationInSeconds;
        this.dailyConsolidations = dailyConsolidations;
        this.weeklyConsolidations = weeklyConsolidations;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public long getUnconsolidatedDurationInSeconds() {
        return unconsolidatedDurationInSeconds;
    }

    public void setUnconsolidatedDurationInSeconds(
        long unconsolidatedDurationInSeconds) {
        this.unconsolidatedDurationInSeconds = unconsolidatedDurationInSeconds;
    }

    public long getDailyConsolidations() {
        return dailyConsolidations;
    }

    public void setDailyConsolidations(long dailyConsolidations) {
        this.dailyConsolidations = dailyConsolidations;
    }

    public long getWeeklyConsolidations() {
        return weeklyConsolidations;
    }

    public void setWeeklyConsolidations(long weeklyConsolidations) {
        this.weeklyConsolidations = weeklyConsolidations;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + (int) (dailyConsolidations ^ (dailyConsolidations >>> 32));
        result = prime * result + (enabled ? 1231 : 1237);
        result = prime
            * result
            + (int) (unconsolidatedDurationInSeconds ^ (unconsolidatedDurationInSeconds >>> 32));
        result = prime * result
            + (int) (weeklyConsolidations ^ (weeklyConsolidations >>> 32));
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
        AutomaticSnapshotConsolidationPolicy other = (AutomaticSnapshotConsolidationPolicy) obj;
        if (dailyConsolidations != other.dailyConsolidations)
            return false;
        if (enabled != other.enabled)
            return false;
        if (unconsolidatedDurationInSeconds != other.unconsolidatedDurationInSeconds)
            return false;
        if (weeklyConsolidations != other.weeklyConsolidations)
            return false;
        return true;
    }

}
