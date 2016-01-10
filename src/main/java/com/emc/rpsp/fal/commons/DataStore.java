package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@XmlRootElement
@XmlType(name = "DataStore")
public class DataStore {

    private String name;
    private HashSet<VMVolume> volumes;

    public DataStore() {
    }

    public DataStore(String name, HashSet<VMVolume> volumes) {
        this.name = name;
        this.volumes = volumes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashSet<VMVolume> getVolumes() {
        return volumes;
    }

    public void setVolumes(HashSet<VMVolume> volumes) {
        this.volumes = volumes;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((volumes == null) ? 0 : volumes.hashCode());
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
        DataStore other = (DataStore) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (volumes == null) {
            if (other.volumes != null)
                return false;
        } else if (!volumes.equals(other.volumes))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("DataStore [name=").append(name).append(", volumes=")
            .append(volumes).append("]");
        return builder.toString();
    }
}
