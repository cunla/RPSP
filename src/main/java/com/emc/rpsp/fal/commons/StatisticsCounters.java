package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "StatisticsCounters")
public class StatisticsCounters {

    private long transactionCounter;
    private long timeCounter;
    private long dataCounter;

    public StatisticsCounters() {

    }

    public StatisticsCounters(long transactionCounter, long timeCounter,
                              long dataCounter) {
        super();
        this.transactionCounter = transactionCounter;
        this.timeCounter = timeCounter;
        this.dataCounter = dataCounter;
    }

    public long getTransactionCounter() {
        return transactionCounter;
    }

    public void setTransactionCounter(long transactionCounter) {
        this.transactionCounter = transactionCounter;
    }

    public long getTimeCounter() {
        return timeCounter;
    }

    public void setTimeCounter(long timeCounter) {
        this.timeCounter = timeCounter;
    }

    public long getDataCounter() {
        return dataCounter;
    }

    public void setDataCounter(long dataCounter) {
        this.dataCounter = dataCounter;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (dataCounter ^ (dataCounter >>> 32));
        result = prime * result + (int) (timeCounter ^ (timeCounter >>> 32));
        result = prime * result
            + (int) (transactionCounter ^ (transactionCounter >>> 32));
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
        StatisticsCounters other = (StatisticsCounters) obj;
        if (dataCounter != other.dataCounter)
            return false;
        if (timeCounter != other.timeCounter)
            return false;
        if (transactionCounter != other.transactionCounter)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("StatisticsCounters [dataCounter=").append(dataCounter)
            .append(", timeCounter=").append(timeCounter).append(
            ", transactionCounter=").append(transactionCounter)
            .append("]");
        return builder.toString();
    }

}
