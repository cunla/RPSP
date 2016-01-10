package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;
import java.util.LinkedList;

@XmlRootElement
@XmlType(name = "ESXView")
public class ESXView {

    private String name;
    private String ip;
    private HashSet<VMView> vmViews;
    private LinkedList<VMVolume> nonVMVolumes;
    private boolean filtered;

    public ESXView() {
    }

    public ESXView(String name, String ip, HashSet<VMView> vmViews, LinkedList<VMVolume> nonVMVolumes, boolean filtered) {
        this.name = name;
        this.ip = ip;
        this.vmViews = vmViews;
        this.nonVMVolumes = nonVMVolumes;
        this.filtered = filtered;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public HashSet<VMView> getVmViews() {
        return vmViews;
    }

    public void setVmViews(HashSet<VMView> vmViews) {
        this.vmViews = vmViews;
    }

    public LinkedList<VMVolume> getNonVMVolumes() {
        return nonVMVolumes;
    }

    public void setNonVMVolumes(LinkedList<VMVolume> nonVMVolumes) {
        this.nonVMVolumes = nonVMVolumes;
    }

    public boolean getFiltered() {
        return filtered;
    }

    public void setFiltered(boolean filtered) {
        this.filtered = filtered;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (filtered ? 1231 : 1237);
        result = prime * result + ((ip == null) ? 0 : ip.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result
            + ((nonVMVolumes == null) ? 0 : nonVMVolumes.hashCode());
        result = prime * result + ((vmViews == null) ? 0 : vmViews.hashCode());
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
        ESXView other = (ESXView) obj;
        if (filtered != other.filtered)
            return false;
        if (ip == null) {
            if (other.ip != null)
                return false;
        } else if (!ip.equals(other.ip))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (nonVMVolumes == null) {
            if (other.nonVMVolumes != null)
                return false;
        } else if (!nonVMVolumes.equals(other.nonVMVolumes))
            return false;
        if (vmViews == null) {
            if (other.vmViews != null)
                return false;
        } else if (!vmViews.equals(other.vmViews))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ESXView [filtered=").append(filtered).append(", ip=")
            .append(ip).append(", name=").append(name).append(
            ", nonVMVolumes=").append(nonVMVolumes).append(
            ", vmViews=").append(vmViews).append("]");
        return builder.toString();
    }
}
