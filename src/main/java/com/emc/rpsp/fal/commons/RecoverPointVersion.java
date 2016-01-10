package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "RecoverPointVersion")
public class RecoverPointVersion {

    private String version;
    private RecoverPointVersionInformation versionInformation;

    public RecoverPointVersion() {
    }

    public RecoverPointVersion(String version, RecoverPointVersionInformation versionInformation) {
        this.version = version;
        this.versionInformation = versionInformation;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public RecoverPointVersionInformation getVersionInformation() {
        return versionInformation;
    }

    public void setVersionInformation(RecoverPointVersionInformation versionInformation) {
        this.versionInformation = versionInformation;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((version == null) ? 0 : version.hashCode());
        result = prime
            * result
            + ((versionInformation == null) ? 0 : versionInformation
            .hashCode());
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
        RecoverPointVersion other = (RecoverPointVersion) obj;
        if (version == null) {
            if (other.version != null)
                return false;
        } else if (!version.equals(other.version))
            return false;
        if (versionInformation == null) {
            if (other.versionInformation != null)
                return false;
        } else if (!versionInformation.equals(other.versionInformation))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RecoverPointVersion [version=").append(version).append(
            ", versionInformation=").append(versionInformation).append("]");
        return builder.toString();
    }
}
