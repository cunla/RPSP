package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;

//import com.emc.fapi.utils.cache.ObjectsGenerator;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatastoreClusterUID")
public class DatastoreClusterUID implements Validateable {

    //This member handles all DatastoreClusterUID objects retrieval\creation
//	private static ObjectsGenerator<DatastoreClusterUID> datastoreClusterUIDgenerator = new ObjectsGenerator<DatastoreClusterUID>();

    public static DatastoreClusterUID generateDatastoreClusterUID(String uuid) {
        return (new DatastoreClusterUID(uuid));
    }

    @XmlElement(required = true)
    private String uuid;

    public DatastoreClusterUID() {
    }

    private DatastoreClusterUID(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
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
        DatastoreClusterUID other = (DatastoreClusterUID) obj;
        if (uuid == null) {
            if (other.uuid != null)
                return false;
        } else if (!uuid.equals(other.uuid))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("DatastoreClusterUID [uuid=").append(uuid).append("]");
        return builder.toString();
    }
}
