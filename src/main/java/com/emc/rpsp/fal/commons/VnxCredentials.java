package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VnxCredentials")
public class VnxCredentials implements Validateable {

    @XmlElement(required = true)
    private String username;
    @XmlElement(required = true)
    private byte[] password;
    @XmlElement(required = true)
    private String certificate;
    @XmlElement(nillable = true, required = true)
    private AuthenticationType authenticationType;

    public VnxCredentials() {

    }

    public VnxCredentials(String username, byte[] password, String certificate, AuthenticationType authenticationType) {
        this.username = username;
        this.password = password;
        this.certificate = certificate;
        this.authenticationType = authenticationType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public AuthenticationType getAuthenticationType() {
        return authenticationType;
    }

    public void setAuthenticationType(AuthenticationType authenticationType) {
        this.authenticationType = authenticationType;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((authenticationType == null) ? 0 : authenticationType
            .hashCode());
        result = prime * result
            + ((certificate == null) ? 0 : certificate.hashCode());
        result = prime * result + Arrays.hashCode(password);
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
        VnxCredentials other = (VnxCredentials) obj;
        if (authenticationType != other.authenticationType)
            return false;
        if (certificate == null) {
            if (other.certificate != null)
                return false;
        } else if (!certificate.equals(other.certificate))
            return false;
        if (!Arrays.equals(password, other.password))
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
        builder.append("VnxCredentials [username=").append(username)
            .append(", password=").append(Arrays.toString(password))
            .append(", certificate=").append(certificate)
            .append(", authenticationType=").append(authenticationType)
            .append("]");
        return builder.toString();
    }

}
