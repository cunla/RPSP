package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;

//import com.emc.fapi.utils.cache.ObjectsGenerator;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EsxClusterUID")
public class EsxClusterUID implements Validateable {

    //This member handles all EsxClusterUID objects retrieval\creation
//	private static ObjectsGenerator<EsxClusterUID> esxClusterUIDgenerator = new ObjectsGenerator<EsxClusterUID>();

    public static EsxClusterUID generateEsxClusterUID(String uuid) {
        return (new EsxClusterUID(uuid));
    }

    @XmlElement(required = true)
    private String uuid;

    public EsxClusterUID() {
    }

    private EsxClusterUID(String uuid) {
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
        EsxClusterUID other = (EsxClusterUID) obj;
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
        builder.append("EsxClusterUID [uuid=").append(uuid).append("]");
        return builder.toString();
    }
}
