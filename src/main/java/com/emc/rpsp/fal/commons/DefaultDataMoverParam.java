package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DefaultDataMoverParam")
public class DefaultDataMoverParam implements Validateable {

    @XmlElement(nillable = true, required = true)
    private FileSystemUID fileSystemUID;
    @XmlElement(required = true)
    private String dataMover;

    public DefaultDataMoverParam() {
    }

    public DefaultDataMoverParam(FileSystemUID fileSystemUID, String dataMover) {
        this.fileSystemUID = fileSystemUID;
        this.dataMover = dataMover;
    }

    public FileSystemUID getFileSystemUID() {
        return fileSystemUID;
    }

    public void setFileSystemUID(FileSystemUID fileSystemUID) {
        this.fileSystemUID = fileSystemUID;
    }

    public String getDataMover() {
        return dataMover;
    }

    public void setDataMover(String dataMover) {
        this.dataMover = dataMover;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((dataMover == null) ? 0 : dataMover.hashCode());
        result = prime * result
            + ((fileSystemUID == null) ? 0 : fileSystemUID.hashCode());
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
        DefaultDataMoverParam other = (DefaultDataMoverParam) obj;
        if (dataMover == null) {
            if (other.dataMover != null)
                return false;
        } else if (!dataMover.equals(other.dataMover))
            return false;
        if (fileSystemUID == null) {
            if (other.fileSystemUID != null)
                return false;
        } else if (!fileSystemUID.equals(other.fileSystemUID))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("DefaultDataMoverParam [fileSystemUID=")
            .append(fileSystemUID).append(", dataMover=").append(dataMover)
            .append("]");
        return builder.toString();
    }

}
