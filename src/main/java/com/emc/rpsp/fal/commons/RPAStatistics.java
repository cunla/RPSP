package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RPAStatistics")
////@LargeObject
public class RPAStatistics {

    @XmlElement(nillable = true)
    private RpaUID rpaUID;
    private double cpuUsage;
    private TrafficStatistics traffic;

    public RPAStatistics() {
        super();
    }

    public RPAStatistics(RpaUID rpaUID, double cpuUsage,
                         TrafficStatistics traffic) {
        super();
        this.rpaUID = rpaUID;
        this.cpuUsage = cpuUsage;
        this.traffic = traffic;
    }

    public RpaUID getRpaUID() {
        return rpaUID;
    }

    public void setRpaUID(RpaUID rpaUID) {
        this.rpaUID = rpaUID;
    }

    public double getCpuUsage() {
        return cpuUsage;
    }

    public void setCpuUsage(double cpuUsage) {
        this.cpuUsage = cpuUsage;
    }

    public TrafficStatistics getTraffic() {
        return traffic;
    }

    public void setTraffic(TrafficStatistics traffic) {
        this.traffic = traffic;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(cpuUsage);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((rpaUID == null) ? 0 : rpaUID.hashCode());
        result = prime * result + ((traffic == null) ? 0 : traffic.hashCode());
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
        RPAStatistics other = (RPAStatistics) obj;
        if (Double.doubleToLongBits(cpuUsage) != Double
            .doubleToLongBits(other.cpuUsage))
            return false;
        if (rpaUID == null) {
            if (other.rpaUID != null)
                return false;
        } else if (!rpaUID.equals(other.rpaUID))
            return false;
        if (traffic == null) {
            if (other.traffic != null)
                return false;
        } else if (!traffic.equals(other.traffic))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RPAStatistics [cpuUsage=").append(cpuUsage).append(
            ", rpaUID=").append(rpaUID).append(", traffic=")
            .append(traffic).append("]");
        return builder.toString();
    }

}
