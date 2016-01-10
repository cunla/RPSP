package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;

@XmlRootElement
@XmlType(name = "Chap")
public class Chap {

    private String username;
    private byte[] password;
    private boolean passwordEncrypted;

    public Chap() {
    }

    public Chap(String username, byte[] password, boolean isPasswordEncrypted) {
        super();
        this.username = username;
        this.password = password;
        this.passwordEncrypted = isPasswordEncrypted;
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

    public boolean isPasswordEncrypted() {
        return passwordEncrypted;
    }

    public void setPasswordEncrypted(boolean isPasswordEncrypted) {
        this.passwordEncrypted = isPasswordEncrypted;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (passwordEncrypted ? 1231 : 1237);
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
        Chap other = (Chap) obj;
        if (passwordEncrypted != other.passwordEncrypted)
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
        builder.append("Chap [username=").append(username)
            .append(", password=").append(Arrays.toString(password))
            .append(", pPasswordEncrypted=").append(passwordEncrypted)
            .append("]");
        return builder.toString();
    }

}
