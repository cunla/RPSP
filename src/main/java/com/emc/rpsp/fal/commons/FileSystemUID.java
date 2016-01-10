package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FileSystemUID")
public class FileSystemUID implements Validateable {

    private long id;
    @XmlElement(nillable = true, required = true)
    private VnxUID vnxUID;

    public FileSystemUID() {

    }

    public FileSystemUID(long id, VnxUID vnxUID) {
        super();
        this.id = id;
        this.vnxUID = vnxUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public VnxUID getVnxUID() {
        return vnxUID;
    }

    public void setVnxUID(VnxUID vnxUID) {
        this.vnxUID = vnxUID;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((vnxUID == null) ? 0 : vnxUID.hashCode());
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
        FileSystemUID other = (FileSystemUID) obj;
        if (id != other.id)
            return false;
        if (vnxUID == null) {
            if (other.vnxUID != null)
                return false;
        } else if (!vnxUID.equals(other.vnxUID))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("FileSystemUID [id=").append(id).append(", vnxUID=")
            .append(vnxUID).append("]");
        return builder.toString();
    }

}
