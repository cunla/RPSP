package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.LinkedList;

@XmlRootElement
@XmlType(name = "MountInformation")
public class MountInformation {

    private String mountPath;
    private String dataMover;
    private boolean readOnly;
    private LinkedList<ShareInformation> sharesInfo;

    public MountInformation() {
    }

    public MountInformation(String mountPath, String dataMover,
                            boolean readOnly, LinkedList<ShareInformation> sharesInfo) {
        this.mountPath = mountPath;
        this.dataMover = dataMover;
        this.readOnly = readOnly;
        this.sharesInfo = sharesInfo;
    }

    public String getMountPath() {
        return mountPath;
    }

    public void setMountPath(String mountPath) {
        this.mountPath = mountPath;
    }

    public String getDataMover() {
        return dataMover;
    }

    public void setDataMover(String dataMover) {
        this.dataMover = dataMover;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public LinkedList<ShareInformation> getSharesInfo() {
        return sharesInfo;
    }

    public void setSharesInfo(LinkedList<ShareInformation> sharesInfo) {
        this.sharesInfo = sharesInfo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((dataMover == null) ? 0 : dataMover.hashCode());
        result = prime * result
            + ((mountPath == null) ? 0 : mountPath.hashCode());
        result = prime * result + (readOnly ? 1231 : 1237);
        result = prime * result
            + ((sharesInfo == null) ? 0 : sharesInfo.hashCode());
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
        MountInformation other = (MountInformation) obj;
        if (dataMover == null) {
            if (other.dataMover != null)
                return false;
        } else if (!dataMover.equals(other.dataMover))
            return false;
        if (mountPath == null) {
            if (other.mountPath != null)
                return false;
        } else if (!mountPath.equals(other.mountPath))
            return false;
        if (readOnly != other.readOnly)
            return false;
        if (sharesInfo == null) {
            if (other.sharesInfo != null)
                return false;
        } else if (!sharesInfo.equals(other.sharesInfo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("MountInformation [mountPath=").append(mountPath)
            .append(", dataMover=").append(dataMover).append(", readOnly=")
            .append(readOnly).append(", sharesInfo=").append(sharesInfo)
            .append("]");
        return builder.toString();
    }
}
