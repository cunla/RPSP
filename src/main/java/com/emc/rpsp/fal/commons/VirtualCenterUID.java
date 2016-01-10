package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualCenterUID")
public class VirtualCenterUID implements Validateable {

    //This member handles all VirtualCenterUID objects retrieval\creation
//	private static ObjectsGenerator<VirtualCenterUID> virtualCenterUIDgenerator = new ObjectsGenerator<VirtualCenterUID>();

    @XmlElement(required = true)
    private String uuid;

    public VirtualCenterUID() {
    }

    public VirtualCenterUID(String uuid) {
        this.uuid = uuid;
    }

    public static VirtualCenterUID generateVirtualCenterUID(String uuid) {
        return (new VirtualCenterUID(uuid));
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
        VirtualCenterUID other = (VirtualCenterUID) obj;
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
        builder.append("VirtualCenterUID [uuid=").append(uuid).append("]");
        return builder.toString();
    }
}
