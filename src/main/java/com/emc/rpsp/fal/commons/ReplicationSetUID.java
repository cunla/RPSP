package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReplicationSetUID")
public class ReplicationSetUID implements Validateable {

    //This member handles all ReplicationSetUID objects retrieval\creation
//	private static ObjectsGenerator<ReplicationSetUID>  replicationSetUIDgenerator = new ObjectsGenerator<ReplicationSetUID>();

    @XmlElement(required = true)
    private ConsistencyGroupUID groupUID;
    private long id;

    //TODO annotate - this CTOR should NOT be used! (due to UIDs cache)
    public ReplicationSetUID() {
    }

    private ReplicationSetUID(ConsistencyGroupUID groupUID, long id) {
        this.groupUID = groupUID;
        this.id = id;
    }

    public static ReplicationSetUID generateReplicationSetUID(ConsistencyGroupUID groupUID, long id) {
        return (new ReplicationSetUID(groupUID, id));
    }

    public ConsistencyGroupUID getGroupUID() {
        return groupUID;
    }

    public void setGroupUID(ConsistencyGroupUID groupUID) {
        this.groupUID = groupUID;
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
        result = prime * result
            + ((groupUID == null) ? 0 : groupUID.hashCode());
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
        ReplicationSetUID other = (ReplicationSetUID) obj;
        if (groupUID == null) {
            if (other.groupUID != null)
                return false;
        } else if (!groupUID.equals(other.groupUID))
            return false;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ReplicationSetUID [groupUID=").append(groupUID).append(
            ", id=").append(id).append("]");
        return builder.toString();
    }
}
