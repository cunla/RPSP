package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VplexSplitter")
public class VplexSplitter implements Validateable {

    @XmlElement(required = true)
    private SplitterUID splitter;
    private VplexSplitterCredentials creds;
    private byte[] password;

    public VplexSplitter() {
    }

    public VplexSplitter(SplitterUID splitter, VplexSplitterCredentials creds, byte[] password) {
        this.splitter = splitter;
        this.creds = creds;
        this.password = password;
    }

    public SplitterUID getSplitter() {
        return splitter;
    }

    public void setSplitter(SplitterUID splitter) {
        this.splitter = splitter;
    }

    public VplexSplitterCredentials getCreds() {
        return creds;
    }

    public void setCreds(VplexSplitterCredentials creds) {
        this.creds = creds;
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
        result = prime * result + ((creds == null) ? 0 : creds.hashCode());
        result = prime * result + Arrays.hashCode(password);
        result = prime * result
            + ((splitter == null) ? 0 : splitter.hashCode());
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
        VplexSplitter other = (VplexSplitter) obj;
        if (creds == null) {
            if (other.creds != null)
                return false;
        } else if (!creds.equals(other.creds))
            return false;
        if (!Arrays.equals(password, other.password))
            return false;
        if (splitter == null) {
            if (other.splitter != null)
                return false;
        } else if (!splitter.equals(other.splitter))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("VplexSplitter [splitter=").append(splitter)
            .append(", creds=").append(creds).append(", password=")
            .append("****").append("]");
        return builder.toString();
    }

}
