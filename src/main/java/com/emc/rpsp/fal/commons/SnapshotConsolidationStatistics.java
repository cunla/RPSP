package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "SnapshotConsolidationStatistics")
public class SnapshotConsolidationStatistics {

    private long savedSpace;
    private double percentageOfSavedSpace;

    public SnapshotConsolidationStatistics() {
    }

    public SnapshotConsolidationStatistics(long savedSpace, double percentageOfSavedSpace) {
        this.savedSpace = savedSpace;
        this.percentageOfSavedSpace = percentageOfSavedSpace;
    }

    public long getSavedSpace() {
        return savedSpace;
    }

    public void setSavedSpace(long savedSpace) {
        this.savedSpace = savedSpace;
    }

    public double getPercentageOfSavedSpace() {
        return percentageOfSavedSpace;
    }

    public void setPercentageOfSavedSpace(double percentageOfSavedSpace) {
        this.percentageOfSavedSpace = percentageOfSavedSpace;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(percentageOfSavedSpace);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + (int) (savedSpace ^ (savedSpace >>> 32));
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
        SnapshotConsolidationStatistics other = (SnapshotConsolidationStatistics) obj;
        if (Double.doubleToLongBits(percentageOfSavedSpace) != Double
            .doubleToLongBits(other.percentageOfSavedSpace))
            return false;
        if (savedSpace != other.savedSpace)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(
            "SnapshotConsolidationStatistics [percentageOfSavedSpace=")
            .append(percentageOfSavedSpace).append(", savedSpace=").append(
            savedSpace).append("]");
        return builder.toString();
    }
}
