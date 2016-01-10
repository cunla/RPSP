package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SNMPUser")
public class SNMPUser implements Validateable {

    @XmlElement(required = true)
    private String username;
    private byte[] password;
    private String certificates;

    public SNMPUser() {
    }

    public SNMPUser(String username, byte[] password, String certificates) {
        this.username = username;
        this.password = password;
        this.certificates = certificates;
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

    public String getCertificates() {
        return certificates;
    }

    public void setCertificates(String certificates) {
        this.certificates = certificates;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((certificates == null) ? 0 : certificates.hashCode());
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
        SNMPUser other = (SNMPUser) obj;
        if (certificates == null) {
            if (other.certificates != null)
                return false;
        } else if (!certificates.equals(other.certificates))
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
        builder.append("SNMPUser [username=").append(username)
            .append(", password=").append(Arrays.toString(password))
            .append(", certificates=").append(certificates).append("]");
        return builder.toString();
    }

}
