package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatacenterUID")
public class DatacenterUID implements Validateable {

    //This member handles all DatacenterUID objects retrieval\creation
//	private static ObjectsGenerator<DatacenterUID> datacenterUIDgenerator = new ObjectsGenerator<DatacenterUID>();

    public static DatacenterUID generateDatacenterUID(String uuid) {
        return (new DatacenterUID(uuid));
    }

    @XmlElement(required = true)
    private String uuid;

    public DatacenterUID() {
    }

    private DatacenterUID(String uuid) {
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
        DatacenterUID other = (DatacenterUID) obj;
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
        builder.append("DatacenterUID [uuid=").append(uuid).append("]");
        return builder.toString();
    }
}
