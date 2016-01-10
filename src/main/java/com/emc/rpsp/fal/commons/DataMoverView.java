package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@XmlRootElement
@XmlType(name = "DataMoverView")
public class DataMoverView {

    private String name;
    private HashSet<String> ipAddresses;

    public DataMoverView() {

    }

    public DataMoverView(String name, HashSet<String> ipAddresses) {
        this.name = name;
        this.ipAddresses = ipAddresses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashSet<String> getIpAddresses() {
        return ipAddresses;
    }

    public void setIpAddresses(HashSet<String> ipAddresses) {
        this.ipAddresses = ipAddresses;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((ipAddresses == null) ? 0 : ipAddresses.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        DataMoverView other = (DataMoverView) obj;
        if (ipAddresses == null) {
            if (other.ipAddresses != null)
                return false;
        } else if (!ipAddresses.equals(other.ipAddresses))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("DataMoverView [name=").append(name)
            .append(", ipAddresses=").append(ipAddresses).append("]");
        return builder.toString();
    }
}
