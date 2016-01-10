package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OutgoingThroughputStatistics")
public class OutgoingThroughputStatistics {

    @XmlElement(nillable = true)
    private RpaUID rpaUID;
    protected int numberOfGrids;
    protected long outgoingThroughput;

    public OutgoingThroughputStatistics() {

    }

    public OutgoingThroughputStatistics(RpaUID rpaUID, int numberOfGrids,
                                        long outgoingThroughput) {
        super();
        this.rpaUID = rpaUID;
        this.numberOfGrids = numberOfGrids;
        this.outgoingThroughput = outgoingThroughput;
    }

    public RpaUID getRpaUID() {
        return rpaUID;
    }

    public void setRpaUID(RpaUID rpaUID) {
        this.rpaUID = rpaUID;
    }

    public int getNumberOfGrids() {
        return numberOfGrids;
    }

    public void setNumberOfGrids(int numberOfGrids) {
        this.numberOfGrids = numberOfGrids;
    }

    public long getOutgoingThroughput() {
        return outgoingThroughput;
    }

    public void setOutgoingThroughput(long outgoingThroughput) {
        this.outgoingThroughput = outgoingThroughput;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + numberOfGrids;
        result = prime * result
            + (int) (outgoingThroughput ^ (outgoingThroughput >>> 32));
        result = prime * result + ((rpaUID == null) ? 0 : rpaUID.hashCode());
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
        OutgoingThroughputStatistics other = (OutgoingThroughputStatistics) obj;
        if (numberOfGrids != other.numberOfGrids)
            return false;
        if (outgoingThroughput != other.outgoingThroughput)
            return false;
        if (rpaUID == null) {
            if (other.rpaUID != null)
                return false;
        } else if (!rpaUID.equals(other.rpaUID))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("OutgoingThroughputStatistics [numberOfGrids=")
            .append(numberOfGrids).append(", outgoingThroughput=").append(
            outgoingThroughput).append(", rpaUID=").append(rpaUID)
            .append("]");
        return builder.toString();
    }

}
