package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShareInformation")
public class ShareInformation {

    private String sharePath;
    private String dataMover;
    @XmlElement(nillable = true)
    private ShareType shareType;

    public ShareInformation() {
    }

    public ShareInformation(String sharePath, String dataMover, ShareType shareType) {
        this.sharePath = sharePath;
        this.dataMover = dataMover;
        this.shareType = shareType;
    }

    public String getSharePath() {
        return sharePath;
    }

    public void setSharePath(String sharePath) {
        this.sharePath = sharePath;
    }

    public String getDataMover() {
        return dataMover;
    }

    public void setDataMover(String dataMover) {
        this.dataMover = dataMover;
    }

    public ShareType getShareType() {
        return shareType;
    }

    public void setShareType(ShareType shareType) {
        this.shareType = shareType;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((dataMover == null) ? 0 : dataMover.hashCode());
        result = prime * result
            + ((sharePath == null) ? 0 : sharePath.hashCode());
        result = prime * result
            + ((shareType == null) ? 0 : shareType.hashCode());
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
        ShareInformation other = (ShareInformation) obj;
        if (dataMover == null) {
            if (other.dataMover != null)
                return false;
        } else if (!dataMover.equals(other.dataMover))
            return false;
        if (sharePath == null) {
            if (other.sharePath != null)
                return false;
        } else if (!sharePath.equals(other.sharePath))
            return false;
        if (shareType == null) {
            if (other.shareType != null)
                return false;
        } else if (!shareType.equals(other.shareType))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ShareInformation [sharePath=").append(sharePath)
            .append(", dataMover=").append(dataMover)
            .append(", shareType=").append(shareType).append("]");
        return builder.toString();
    }
}
