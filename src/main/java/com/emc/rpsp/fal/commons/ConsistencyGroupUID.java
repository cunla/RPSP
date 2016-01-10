package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@SuppressWarnings("serial")
@XmlRootElement
@XmlType(name = "ConsistencyGroupUID")
public class ConsistencyGroupUID implements Validateable {

    //This member handles all ClusterUID objects retrieval\creation
//	private static ObjectsGenerator<ConsistencyGroupUID>  consistencyGroupUIDgenerator = new ObjectsGenerator<ConsistencyGroupUID>();

    private long id;

    //TODO annotate - this CTOR should NOT be used! (due to UIDs cache)
    public ConsistencyGroupUID() {
    }

    public ConsistencyGroupUID(long id) {
        this.id = id;
    }

    public static ConsistencyGroupUID generateConsistencyGroupUID(long id) {
        return (new ConsistencyGroupUID(id));
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
        ConsistencyGroupUID other = (ConsistencyGroupUID) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ConsistencyGroupUID [id=").append(id).append("]");
        return builder.toString();
    }
}
