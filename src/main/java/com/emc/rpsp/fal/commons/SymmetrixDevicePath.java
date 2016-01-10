package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "SymmetrixDevicePath")
public class SymmetrixDevicePath {

    private String device;
    private long WWN;
    private long lun;
    private int port;

    public SymmetrixDevicePath() {
    }

    public SymmetrixDevicePath(String device, long wWN, long lun, int port) {
        this.device = device;
        WWN = wWN;
        this.lun = lun;
        this.port = port;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public long getWWN() {
        return WWN;
    }

    public void setWWN(long wWN) {
        WWN = wWN;
    }

    public long getLun() {
        return lun;
    }

    public void setLun(long lun) {
        this.lun = lun;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (WWN ^ (WWN >>> 32));
        result = prime * result + ((device == null) ? 0 : device.hashCode());
        result = prime * result + (int) (lun ^ (lun >>> 32));
        result = prime * result + port;
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
        SymmetrixDevicePath other = (SymmetrixDevicePath) obj;
        if (WWN != other.WWN)
            return false;
        if (device == null) {
            if (other.device != null)
                return false;
        } else if (!device.equals(other.device))
            return false;
        if (lun != other.lun)
            return false;
        if (port != other.port)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SymmetrixDevicePath [WWN=").append(WWN).append(
            ", device=").append(device).append(", lun=").append(lun)
            .append(", port=").append(port).append("]");
        return builder.toString();
    }

}
