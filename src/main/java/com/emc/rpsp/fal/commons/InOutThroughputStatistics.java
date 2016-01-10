package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@XmlRootElement
@XmlType(name = "InOutThroughputStatistics")
public class InOutThroughputStatistics {

    private long inThroughput;
    private HashSet<ConnectionOutThroughput> connectionsOutThroughput;


    public InOutThroughputStatistics() {
        super();
    }

    public InOutThroughputStatistics(long inThroughput, HashSet<ConnectionOutThroughput> connectionsOutThroughput) {
        this.inThroughput = inThroughput;
        this.connectionsOutThroughput = connectionsOutThroughput;
    }

    public long getInThroughput() {
        return inThroughput;
    }

    public void setInThroughput(long inThroughput) {
        this.inThroughput = inThroughput;
    }

    public HashSet<ConnectionOutThroughput> getConnectionsOutThroughput() {
        return connectionsOutThroughput;
    }

    public void setConnectionsOutThroughput(
        HashSet<ConnectionOutThroughput> connectionsOutThroughput) {
        this.connectionsOutThroughput = connectionsOutThroughput;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((connectionsOutThroughput == null) ? 0
            : connectionsOutThroughput.hashCode());
        result = prime * result + (int) (inThroughput ^ (inThroughput >>> 32));
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
        InOutThroughputStatistics other = (InOutThroughputStatistics) obj;
        if (connectionsOutThroughput == null) {
            if (other.connectionsOutThroughput != null)
                return false;
        } else if (!connectionsOutThroughput
            .equals(other.connectionsOutThroughput))
            return false;
        if (inThroughput != other.inThroughput)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("InOutThroughputStatistics [inThroughput=")
            .append(inThroughput).append(", connectionsOutThroughput=")
            .append(connectionsOutThroughput).append("]");
        return builder.toString();
    }

}
