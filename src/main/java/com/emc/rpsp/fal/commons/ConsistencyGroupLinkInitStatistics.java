package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "ConsistencyGroupLinkInitStatistics")
public class ConsistencyGroupLinkInitStatistics {

    private double initCompletionPortion;
    private long initIncomingThroughput;
    private long initOutgoingThroughput;
    private int numberOfGrids;

    public ConsistencyGroupLinkInitStatistics() {

    }

    public ConsistencyGroupLinkInitStatistics(double initCompletionPortion,
                                              long initIncomingThroughput, long initOutgoingThroughput,
                                              int numberOfGrids) {
        super();
        this.initCompletionPortion = initCompletionPortion;
        this.initIncomingThroughput = initIncomingThroughput;
        this.initOutgoingThroughput = initOutgoingThroughput;
        this.numberOfGrids = numberOfGrids;
    }


    public double getInitCompletionPortion() {
        return initCompletionPortion;
    }

    public void setInitCompletionPortion(double initCompletionPortion) {
        this.initCompletionPortion = initCompletionPortion;
    }

    public long getInitIncomingThroughput() {
        return initIncomingThroughput;
    }

    public void setInitIncomingThroughput(long initIncomingThroughput) {
        this.initIncomingThroughput = initIncomingThroughput;
    }

    public long getInitOutgoingThroughput() {
        return initOutgoingThroughput;
    }

    public void setInitOutgoingThroughput(long initOutgoingThroughput) {
        this.initOutgoingThroughput = initOutgoingThroughput;
    }

    public int getNumberOfGrids() {
        return numberOfGrids;
    }

    public void setNumberOfGrids(int numberOfGrids) {
        this.numberOfGrids = numberOfGrids;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(initCompletionPortion);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime
            * result
            + (int) (initIncomingThroughput ^ (initIncomingThroughput >>> 32));
        result = prime
            * result
            + (int) (initOutgoingThroughput ^ (initOutgoingThroughput >>> 32));
        result = prime * result + numberOfGrids;
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
        ConsistencyGroupLinkInitStatistics other = (ConsistencyGroupLinkInitStatistics) obj;
        if (Double.doubleToLongBits(initCompletionPortion) != Double
            .doubleToLongBits(other.initCompletionPortion))
            return false;
        if (initIncomingThroughput != other.initIncomingThroughput)
            return false;
        if (initOutgoingThroughput != other.initOutgoingThroughput)
            return false;
        if (numberOfGrids != other.numberOfGrids)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(
            "ConsistencyGroupLinkInitStatistics [initCompletionPortion=")
            .append(initCompletionPortion).append(
            ", initIncomingThroughput=").append(
            initIncomingThroughput).append(
            ", initOutgoingThroughput=").append(
            initOutgoingThroughput).append(", numberOfGrids=")
            .append(numberOfGrids).append("]");
        return builder.toString();
    }

}
