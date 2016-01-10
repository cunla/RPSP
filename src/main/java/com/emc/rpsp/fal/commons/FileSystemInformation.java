package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FileSystemInformation")
public class FileSystemInformation {

    @XmlElement(nillable = true)
    private FileSystemUID fileSystemUID;
    private HashSet<DeviceUID> volumes;
    private String name;
    private String defaultMountPath;
    private String defaultDataMover;
    private long size;
    private boolean vdm;

    public FileSystemInformation() {
    }

    public FileSystemInformation(FileSystemUID fileSystemUID,
                                 HashSet<DeviceUID> volumes, String name, String defaultMountPath,
                                 String defaultDataMover, long size, boolean isVDM) {
        this.fileSystemUID = fileSystemUID;
        this.volumes = volumes;
        this.name = name;
        this.defaultMountPath = defaultMountPath;
        this.defaultDataMover = defaultDataMover;
        this.size = size;
        this.vdm = isVDM;
    }

    public FileSystemUID getFileSystemUID() {
        return fileSystemUID;
    }

    public void setFileSystemUID(FileSystemUID fileSystemUID) {
        this.fileSystemUID = fileSystemUID;
    }

    public HashSet<DeviceUID> getVolumes() {
        return volumes;
    }

    public void setVolumes(HashSet<DeviceUID> volumes) {
        this.volumes = volumes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefaultMountPath() {
        return defaultMountPath;
    }

    public void setDefaultMountPath(String defaultMountPath) {
        this.defaultMountPath = defaultMountPath;
    }

    public String getDefaultDataMover() {
        return defaultDataMover;
    }

    public void setDefaultDataMover(String defaultDataMover) {
        this.defaultDataMover = defaultDataMover;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public boolean isVdm() {
        return vdm;
    }

    public void setVdm(boolean vdm) {
        this.vdm = vdm;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((defaultDataMover == null) ? 0 : defaultDataMover.hashCode());
        result = prime
            * result
            + ((defaultMountPath == null) ? 0 : defaultMountPath.hashCode());
        result = prime * result
            + ((fileSystemUID == null) ? 0 : fileSystemUID.hashCode());
        result = prime * result + (vdm ? 1231 : 1237);
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + (int) (size ^ (size >>> 32));
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
        FileSystemInformation other = (FileSystemInformation) obj;
        if (defaultDataMover == null) {
            if (other.defaultDataMover != null)
                return false;
        } else if (!defaultDataMover.equals(other.defaultDataMover))
            return false;
        if (defaultMountPath == null) {
            if (other.defaultMountPath != null)
                return false;
        } else if (!defaultMountPath.equals(other.defaultMountPath))
            return false;
        if (fileSystemUID == null) {
            if (other.fileSystemUID != null)
                return false;
        } else if (!fileSystemUID.equals(other.fileSystemUID))
            return false;
        if (vdm != other.vdm)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (size != other.size)
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
        builder.append("FileSystemInformation [fileSystemUID=")
            .append(fileSystemUID).append(", volumes=").append(volumes)
            .append(", name=").append(name).append(", defaultMountPath=")
            .append(defaultMountPath).append(", defaultDataMover=")
            .append(defaultDataMover).append(", size=").append(size)
            .append(", vdm=").append(vdm).append("]");
        return builder.toString();
    }
}
