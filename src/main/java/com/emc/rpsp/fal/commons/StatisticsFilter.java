package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StatisticsFilter")
public class StatisticsFilter implements Validateable {

    @XmlElement(nillable = true)
    private TimeFrame timeFrame;
    private boolean includeGlobalStatistics;
    private HashSet<ConsistencyGroupUID> groups;
    private HashSet<Integer> rpasNumbers;
    private HashSet<ClusterUID> clusters;
    private HashSet<String> categories;
    @XmlElement(required = true)
    private Quantity granularity;

    public StatisticsFilter() {
    }

    public StatisticsFilter(TimeFrame timeFrame, boolean includeGlobalStatistics, HashSet<ConsistencyGroupUID> groups,
                            HashSet<Integer> rpasNumbers, HashSet<ClusterUID> clusters, HashSet<String> categories, Quantity granularity) {
        this.timeFrame = timeFrame;
        this.includeGlobalStatistics = includeGlobalStatistics;
        this.groups = groups;
        this.rpasNumbers = rpasNumbers;
        this.clusters = clusters;
        this.categories = categories;
        this.granularity = granularity;
    }

    public TimeFrame getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(TimeFrame timeFrame) {
        this.timeFrame = timeFrame;
    }

    public boolean getIncludeGlobalStatistics() {
        return includeGlobalStatistics;
    }

    public void setIncludeGlobalStatistics(boolean includeGlobalStatistics) {
        this.includeGlobalStatistics = includeGlobalStatistics;
    }

    public HashSet<ConsistencyGroupUID> getGroups() {
        return groups;
    }

    public void setGroups(HashSet<ConsistencyGroupUID> groups) {
        this.groups = groups;
    }

    public HashSet<Integer> getRpasNumbers() {
        return rpasNumbers;
    }

    public void setRpasNumbers(HashSet<Integer> rpasNumbers) {
        this.rpasNumbers = rpasNumbers;
    }

    public HashSet<ClusterUID> getClusters() {
        return clusters;
    }

    public void setClusters(HashSet<ClusterUID> clusters) {
        this.clusters = clusters;
    }

    public HashSet<String> getCategories() {
        return categories;
    }

    public void setCategories(HashSet<String> categories) {
        this.categories = categories;
    }

    public Quantity getGranularity() {
        return granularity;
    }

    public void setGranularity(Quantity granularity) {
        this.granularity = granularity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((categories == null) ? 0 : categories.hashCode());
        result = prime * result
            + ((granularity == null) ? 0 : granularity.hashCode());
        result = prime * result + ((groups == null) ? 0 : groups.hashCode());
        result = prime * result + (includeGlobalStatistics ? 1231 : 1237);
        result = prime * result
            + ((rpasNumbers == null) ? 0 : rpasNumbers.hashCode());
        result = prime * result + ((clusters == null) ? 0 : clusters.hashCode());
        result = prime * result
            + ((timeFrame == null) ? 0 : timeFrame.hashCode());
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
        StatisticsFilter other = (StatisticsFilter) obj;
        if (categories == null) {
            if (other.categories != null)
                return false;
        } else if (!categories.equals(other.categories))
            return false;
        if (granularity == null) {
            if (other.granularity != null)
                return false;
        } else if (!granularity.equals(other.granularity))
            return false;
        if (groups == null) {
            if (other.groups != null)
                return false;
        } else if (!groups.equals(other.groups))
            return false;
        if (includeGlobalStatistics != other.includeGlobalStatistics)
            return false;
        if (rpasNumbers == null) {
            if (other.rpasNumbers != null)
                return false;
        } else if (!rpasNumbers.equals(other.rpasNumbers))
            return false;
        if (clusters == null) {
            if (other.clusters != null)
                return false;
        } else if (!clusters.equals(other.clusters))
            return false;
        if (timeFrame == null) {
            if (other.timeFrame != null)
                return false;
        } else if (!timeFrame.equals(other.timeFrame))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("StatisticsFilter [categories=").append(categories)
            .append(", granularity=").append(granularity).append(
            ", groups=").append(groups).append(
            ", includeGlobalStatistics=").append(
            includeGlobalStatistics).append(", rpasNumbers=")
            .append(rpasNumbers).append(", clusters=").append(clusters).append(
            ", timeFrame=").append(timeFrame).append("]");
        return builder.toString();
    }
}
