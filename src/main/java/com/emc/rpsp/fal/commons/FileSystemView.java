package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FileSystemView")
public class FileSystemView {

    @XmlElement(nillable = true)
    private VnxUID vnxUID;
    private HashSet<FileSystemExtendedInformation> fileSystemsExtendedInformation;
    @XmlElement(nillable = true)
    private ConnectivityStatus connectivityStatus;
    private HashSet<DataMoverView> vdms;
    private HashSet<DataMoverView> dateMovers;
    private HashSet<String> storagePools;

    public FileSystemView() {

    }

    public FileSystemView(VnxUID vnxUID, HashSet<FileSystemExtendedInformation> fileSystemsExtendedInformation,
                          ConnectivityStatus connectivityStatus, HashSet<DataMoverView> vdms, HashSet<DataMoverView> dateMovers, HashSet<String> storagePools) {
        this.vnxUID = vnxUID;
        this.fileSystemsExtendedInformation = fileSystemsExtendedInformation;
        this.connectivityStatus = connectivityStatus;
        this.vdms = vdms;
        this.dateMovers = dateMovers;
        this.storagePools = storagePools;
    }

    public VnxUID getVnxUID() {
        return vnxUID;
    }

    public void setVnxUID(VnxUID vnxUID) {
        this.vnxUID = vnxUID;
    }

    public HashSet<FileSystemExtendedInformation> getFileSystemsExtendedInformation() {
        return fileSystemsExtendedInformation;
    }

    public void setFileSystemsExtendedInformation(
        HashSet<FileSystemExtendedInformation> fileSystemsExtendedInformation) {
        this.fileSystemsExtendedInformation = fileSystemsExtendedInformation;
    }

    public ConnectivityStatus getConnectivityStatus() {
        return connectivityStatus;
    }

    public void setConnectivityStatus(ConnectivityStatus connectivityStatus) {
        this.connectivityStatus = connectivityStatus;
    }

    public HashSet<DataMoverView> getVdms() {
        return vdms;
    }

    public void setVdms(HashSet<DataMoverView> vdms) {
        this.vdms = vdms;
    }

    public HashSet<DataMoverView> getDateMovers() {
        return dateMovers;
    }

    public void setDateMovers(HashSet<DataMoverView> dateMovers) {
        this.dateMovers = dateMovers;
    }

    public HashSet<String> getStoragePools() {
        return storagePools;
    }

    public void setStoragePools(HashSet<String> storagePools) {
        this.storagePools = storagePools;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((connectivityStatus == null) ? 0 : connectivityStatus
            .hashCode());
        result = prime * result
            + ((dateMovers == null) ? 0 : dateMovers.hashCode());
        result = prime
            * result
            + ((fileSystemsExtendedInformation == null) ? 0
            : fileSystemsExtendedInformation.hashCode());
        result = prime * result
            + ((storagePools == null) ? 0 : storagePools.hashCode());
        result = prime * result + ((vdms == null) ? 0 : vdms.hashCode());
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
        FileSystemView other = (FileSystemView) obj;
        if (connectivityStatus != other.connectivityStatus)
            return false;
        if (dateMovers == null) {
            if (other.dateMovers != null)
                return false;
        } else if (!dateMovers.equals(other.dateMovers))
            return false;
        if (fileSystemsExtendedInformation == null) {
            if (other.fileSystemsExtendedInformation != null)
                return false;
        } else if (!fileSystemsExtendedInformation.equals(other.fileSystemsExtendedInformation))
            return false;
        if (storagePools == null) {
            if (other.storagePools != null)
                return false;
        } else if (!storagePools.equals(other.storagePools))
            return false;
        if (vdms == null) {
            if (other.vdms != null)
                return false;
        } else if (!vdms.equals(other.vdms))
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
        builder.append("FileSystemView [vnxUID=").append(vnxUID)
            .append(", fileSystemsExtendedInformation=")
            .append(fileSystemsExtendedInformation)
            .append(", connectivityStatus=").append(connectivityStatus)
            .append(", vdms=").append(vdms).append(", dateMovers=")
            .append(dateMovers).append(", storagePools=")
            .append(storagePools).append("]");
        return builder.toString();
    }
}
