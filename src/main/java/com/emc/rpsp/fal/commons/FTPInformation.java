package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FTPInformation")
public class FTPInformation implements Validateable {

    @XmlElement(required = true)
    private String server;
    private int port;
    @XmlElement(required = true)
    private String username;
    @XmlElement(required = true)
    private byte[] password;
    private String location;
    private String filename;

    public FTPInformation() {
    }

    public FTPInformation(String server, int port, String username, byte[] password, String location, String filename) {
        this.server = server;
        this.port = port;
        this.username = username;
        this.password = password;
        this.location = location;
        this.filename = filename;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((filename == null) ? 0 : filename.hashCode());
        result = prime * result
            + ((location == null) ? 0 : location.hashCode());
        result = prime * result + Arrays.hashCode(password);
        result = prime * result + port;
        result = prime * result + ((server == null) ? 0 : server.hashCode());
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
        FTPInformation other = (FTPInformation) obj;
        if (filename == null) {
            if (other.filename != null)
                return false;
        } else if (!filename.equals(other.filename))
            return false;
        if (location == null) {
            if (other.location != null)
                return false;
        } else if (!location.equals(other.location))
            return false;
        if (!Arrays.equals(password, other.password))
            return false;
        if (port != other.port)
            return false;
        if (server == null) {
            if (other.server != null)
                return false;
        } else if (!server.equals(other.server))
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
        builder.append("FTPInformation [filename=").append(filename).append(
            ", location=").append(location).append(", password=").append("....").append(", port=").append(port)
            .append(", server=").append(server).append(", username=")
            .append(username).append("]");
        return builder.toString();
    }
}
