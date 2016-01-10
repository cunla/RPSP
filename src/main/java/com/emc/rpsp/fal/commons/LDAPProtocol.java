package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LDAPProtocol")
public class LDAPProtocol implements Validateable {

    @XmlElement(required = true)
    private LDAPProtocolType protocolType;
    @XmlElement(required = true)
    private String certificate;
    private boolean useCertificate;

    public LDAPProtocol() {
    }

    public LDAPProtocol(LDAPProtocolType protocolType, String certificate, boolean useCertificate) {
        this.protocolType = protocolType;
        this.certificate = certificate;
        this.useCertificate = useCertificate;
    }

    public LDAPProtocolType getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(LDAPProtocolType protocolType) {
        this.protocolType = protocolType;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public boolean getUseCertificate() {
        return useCertificate;
    }

    public void setUseCertificate(boolean useCertificate) {
        this.useCertificate = useCertificate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((certificate == null) ? 0 : certificate.hashCode());
        result = prime * result
            + ((protocolType == null) ? 0 : protocolType.hashCode());
        result = prime * result + (useCertificate ? 1231 : 1237);
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
        LDAPProtocol other = (LDAPProtocol) obj;
        if (certificate == null) {
            if (other.certificate != null)
                return false;
        } else if (!certificate.equals(other.certificate))
            return false;
        if (protocolType == null) {
            if (other.protocolType != null)
                return false;
        } else if (!protocolType.equals(other.protocolType))
            return false;
        if (useCertificate != other.useCertificate)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LDAPProtocol [certificate=").append(certificate)
            .append(", protocolType=").append(protocolType).append(
            ", useCertificate=").append(useCertificate).append("]");
        return builder.toString();
    }
}
