package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("serial")
@XmlRootElement
@XmlType(name = "ConsistencyGroupSetUID")
public class ConsistencyGroupSetUID implements Validateable {

    //This member handles all ClusterUID objects retrieval\creation
//	private static ObjectsGenerator<ConsistencyGroupSetUID>  consistencyGroupSetUIDgenerator = new ObjectsGenerator<ConsistencyGroupSetUID>();

    private long id;

    public ConsistencyGroupSetUID() {
    }

    public ConsistencyGroupSetUID(long id) {
        this.id = id;
    }

    public static ConsistencyGroupSetUID generateConsistencyGroupSetUID(long id) {
        return (new ConsistencyGroupSetUID(id));
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
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
        ConsistencyGroupSetUID other = (ConsistencyGroupSetUID) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ConsistencyGroupSetUID [id=").append(id).append("]");
        return builder.toString();
    }
}
