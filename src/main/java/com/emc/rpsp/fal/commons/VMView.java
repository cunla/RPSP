package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@XmlRootElement
@XmlType(name = "VMView")
public class VMView {

    private String name;
    private String ip;
    private HashSet<DataStore> dataStores;
    private HashSet<VMVolume> rdmDevices;
    private VMProtectionStatus protectionStatus;
    private ConsistencyGroupUID protectingGroupUID;
    private boolean filtered;
    private boolean template;

    public VMView() {
    }

    public VMView(String name, String ip, HashSet<DataStore> dataStores, HashSet<VMVolume> rdmDevices,
                  VMProtectionStatus protectionStatus, ConsistencyGroupUID protectingGroupUID, boolean filtered, boolean template) {
        this.name = name;
        this.ip = ip;
        this.dataStores = dataStores;
        this.rdmDevices = rdmDevices;
        this.protectionStatus = protectionStatus;
        this.protectingGroupUID = protectingGroupUID;
        this.filtered = filtered;
        this.template = template;
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

    public HashSet<DataStore> getDataStores() {
        return dataStores;
    }

    public void setDataStores(HashSet<DataStore> dataStores) {
        this.dataStores = dataStores;
    }

    public HashSet<VMVolume> getRdmDevices() {
        return rdmDevices;
    }

    public void setRdmDevices(HashSet<VMVolume> rdmDevices) {
        this.rdmDevices = rdmDevices;
    }

    public VMProtectionStatus getProtectionStatus() {
        return protectionStatus;
    }

    public void setProtectionStatus(VMProtectionStatus protectionStatus) {
        this.protectionStatus = protectionStatus;
    }

    public ConsistencyGroupUID getProtectingGroupUID() {
        return protectingGroupUID;
    }

    public void setProtectingGroupUID(ConsistencyGroupUID protectingGroupUID) {
        this.protectingGroupUID = protectingGroupUID;
    }

    public boolean getFiltered() {
        return filtered;
    }

    public void setFiltered(boolean filtered) {
        this.filtered = filtered;
    }

    public boolean getTemplate() {
        return template;
    }

    public void setTemplate(boolean template) {
        this.template = template;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((dataStores == null) ? 0 : dataStores.hashCode());
        result = prime * result + (filtered ? 1231 : 1237);
        result = prime * result + ((ip == null) ? 0 : ip.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime
            * result
            + ((protectingGroupUID == null) ? 0 : protectingGroupUID
            .hashCode());
        result = prime
            * result
            + ((protectionStatus == null) ? 0 : protectionStatus.hashCode());
        result = prime * result
            + ((rdmDevices == null) ? 0 : rdmDevices.hashCode());
        result = prime * result + (template ? 1231 : 1237);
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
        VMView other = (VMView) obj;
        if (dataStores == null) {
            if (other.dataStores != null)
                return false;
        } else if (!dataStores.equals(other.dataStores))
            return false;
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
        if (protectingGroupUID == null) {
            if (other.protectingGroupUID != null)
                return false;
        } else if (!protectingGroupUID.equals(other.protectingGroupUID))
            return false;
        if (protectionStatus == null) {
            if (other.protectionStatus != null)
                return false;
        } else if (!protectionStatus.equals(other.protectionStatus))
            return false;
        if (rdmDevices == null) {
            if (other.rdmDevices != null)
                return false;
        } else if (!rdmDevices.equals(other.rdmDevices))
            return false;
        if (template != other.template)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("VMView [dataStores=").append(dataStores).append(
            ", filtered=").append(filtered).append(", ip=").append(ip)
            .append(", name=").append(name).append(", protectingGroupUID=")
            .append(protectingGroupUID).append(", protectionStatus=")
            .append(protectionStatus).append(", rdmDevices=").append(
            rdmDevices).append(", template=").append(template)
            .append("]");
        return builder.toString();
    }
}
