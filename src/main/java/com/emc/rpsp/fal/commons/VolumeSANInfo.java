package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "VolumeSANInfo")
public class VolumeSANInfo {

    private String path;
    private Integer channel;
    private Long target;
    private Integer lun;

    public VolumeSANInfo() {
    }

    public VolumeSANInfo(String path, Integer channel, Long target, Integer lun) {
        this.path = path;
        this.channel = channel;
        this.target = target;
        this.lun = lun;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public Long getTarget() {
        return target;
    }

    public void setTarget(Long target) {
        this.target = target;
    }

    public Integer getLun() {
        return lun;
    }

    public void setLun(Integer lun) {
        this.lun = lun;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((channel == null) ? 0 : channel.hashCode());
        result = prime * result + ((lun == null) ? 0 : lun.hashCode());
        result = prime * result + ((path == null) ? 0 : path.hashCode());
        result = prime * result + ((target == null) ? 0 : target.hashCode());
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
        VolumeSANInfo other = (VolumeSANInfo) obj;
        if (channel == null) {
            if (other.channel != null)
                return false;
        } else if (!channel.equals(other.channel))
            return false;
        if (lun == null) {
            if (other.lun != null)
                return false;
        } else if (!lun.equals(other.lun))
            return false;
        if (path == null) {
            if (other.path != null)
                return false;
        } else if (!path.equals(other.path))
            return false;
        if (target == null) {
            if (other.target != null)
                return false;
        } else if (!target.equals(other.target))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("VolumeSANInfo [channel=").append(channel)
            .append(", lun=").append(lun).append(", path=").append(path)
            .append(", target=").append(target).append("]");
        return builder.toString();
    }
}
