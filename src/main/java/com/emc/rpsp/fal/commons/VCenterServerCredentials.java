package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VCenterServerCredentials")
public class VCenterServerCredentials implements Validateable {

    @XmlElement(required = true)
    private ClusterUID cluster;
    @XmlElement(required = true)
    private String ip;
    @XmlElement(required = true)
    private String username;
    @XmlElement(required = true)
    private byte[] password;
    private int port;
    private String certificate;

    public VCenterServerCredentials() {
    }

    public VCenterServerCredentials(ClusterUID cluster, String ip, String username, byte[] password, int port, String certificate) {
        this.cluster = cluster;
        this.ip = ip;
        this.username = username;
        this.password = password;
        this.port = port;
        this.certificate = certificate;
    }

    public ClusterUID getCluster() {
        return cluster;
    }

    public void setCluster(ClusterUID cluster) {
        this.cluster = cluster;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((certificate == null) ? 0 : certificate.hashCode());
        result = prime * result + ((ip == null) ? 0 : ip.hashCode());
        result = prime * result + Arrays.hashCode(password);
        result = prime * result + port;
        result = prime * result + ((cluster == null) ? 0 : cluster.hashCode());
        result = prime * result
            + ((username == null) ? 0 : username.hashCode());
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
        VCenterServerCredentials other = (VCenterServerCredentials) obj;
        if (certificate == null) {
            if (other.certificate != null)
                return false;
        } else if (!certificate.equals(other.certificate))
            return false;
        if (ip == null) {
            if (other.ip != null)
                return false;
        } else if (!ip.equals(other.ip))
            return false;
        if (!Arrays.equals(password, other.password))
            return false;
        if (port != other.port)
            return false;
        if (cluster == null) {
            if (other.cluster != null)
                return false;
        } else if (!cluster.equals(other.cluster))
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("VCenterServerCredentials [certificate=").append(
            certificate).append(", ip=").append(ip).append(", password=").append("....")
            .append(", port=").append(port).append(", cluster=").append(cluster).append(
            ", username=").append(username).append("]");
        return builder.toString();
    }
}
