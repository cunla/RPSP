package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.LinkedList;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FileSystemExtendedInformation")
public class FileSystemExtendedInformation {

    @XmlElement(nillable = true)
    private FileSystemInformation fileSystemInformation;
    private long storageUsed;
    private boolean hasProtectedFiles;
    private LinkedList<MountInformation> mountInformationList;
    private LinkedList<ShareInformation> unmountedShareInformationList;

    public FileSystemExtendedInformation() {
    }

    public FileSystemExtendedInformation(
        FileSystemInformation fileSystemInformation, long storageUsed,
        boolean hasProtectedFiles,
        LinkedList<MountInformation> mountInformationList,
        LinkedList<ShareInformation> unmountedShareInformationList) {
        this.fileSystemInformation = fileSystemInformation;
        this.storageUsed = storageUsed;
        this.hasProtectedFiles = hasProtectedFiles;
        this.mountInformationList = mountInformationList;
        this.unmountedShareInformationList = unmountedShareInformationList;
    }

    public FileSystemInformation getFileSystemInformation() {
        return fileSystemInformation;
    }

    public void setFileSystemInformation(FileSystemInformation fileSystemInformation) {
        this.fileSystemInformation = fileSystemInformation;
    }

    public long getStorageUsed() {
        return storageUsed;
    }

    public void setStorageUsed(long storageUsed) {
        this.storageUsed = storageUsed;
    }

    public boolean isHasProtectedFiles() {
        return hasProtectedFiles;
    }

    public void setHasProtectedFiles(boolean hasProtectedFiles) {
        this.hasProtectedFiles = hasProtectedFiles;
    }

    public LinkedList<MountInformation> getMountInformationList() {
        return mountInformationList;
    }

    public void setMountInformationList(
        LinkedList<MountInformation> mountInformationList) {
        this.mountInformationList = mountInformationList;
    }

    public LinkedList<ShareInformation> getUnmountedShareInformationList() {
        return unmountedShareInformationList;
    }

    public void setUnmountedShareInformationList(
        LinkedList<ShareInformation> unmountedShareInformationList) {
        this.unmountedShareInformationList = unmountedShareInformationList;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((fileSystemInformation == null) ? 0 : fileSystemInformation
            .hashCode());
        result = prime * result + (hasProtectedFiles ? 1231 : 1237);
        result = prime
            * result
            + ((mountInformationList == null) ? 0 : mountInformationList
            .hashCode());
        result = prime * result + (int) (storageUsed ^ (storageUsed >>> 32));
        result = prime
            * result
            + ((unmountedShareInformationList == null) ? 0
            : unmountedShareInformationList.hashCode());
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
        FileSystemExtendedInformation other = (FileSystemExtendedInformation) obj;
        if (fileSystemInformation == null) {
            if (other.fileSystemInformation != null)
                return false;
        } else if (!fileSystemInformation.equals(other.fileSystemInformation))
            return false;
        if (hasProtectedFiles != other.hasProtectedFiles)
            return false;
        if (mountInformationList == null) {
            if (other.mountInformationList != null)
                return false;
        } else if (!mountInformationList.equals(other.mountInformationList))
            return false;
        if (storageUsed != other.storageUsed)
            return false;
        if (unmountedShareInformationList == null) {
            if (other.unmountedShareInformationList != null)
                return false;
        } else if (!unmountedShareInformationList
            .equals(other.unmountedShareInformationList))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("FileSystemExtendedInformation [fileSystemInformation=")
            .append(fileSystemInformation).append(", storageUsed=")
            .append(storageUsed).append(", hasProtectedFiles=")
            .append(hasProtectedFiles).append(", mountInformationList=")
            .append(mountInformationList)
            .append(", unmountedShareInformationList=")
            .append(unmountedShareInformationList).append("]");
        return builder.toString();
    }
}
