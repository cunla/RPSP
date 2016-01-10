package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "RecoverPointVersionInformation")
public class RecoverPointVersionInformation {

    private int major;
    private int minor;
    private Integer servicePack;
    private Integer patch;
    private String hotFix;
    private String buildDescription;

    public RecoverPointVersionInformation() {
    }

    public RecoverPointVersionInformation(int major, int minor, Integer servicePack, Integer patch, String hotFix, String buildDescription) {
        this.major = major;
        this.minor = minor;
        this.servicePack = servicePack;
        this.patch = patch;
        this.hotFix = hotFix;
        this.buildDescription = buildDescription;
    }

    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public int getMinor() {
        return minor;
    }

    public void setMinor(int minor) {
        this.minor = minor;
    }

    public Integer getServicePack() {
        return servicePack;
    }

    public void setServicePack(Integer servicePack) {
        this.servicePack = servicePack;
    }

    public Integer getPatch() {
        return patch;
    }

    public void setPatch(Integer patch) {
        this.patch = patch;
    }

    public String getHotFix() {
        return hotFix;
    }

    public void setHotFix(String hotFix) {
        this.hotFix = hotFix;
    }

    public String getBuildDescription() {
        return buildDescription;
    }

    public void setBuildDescription(String buildDescription) {
        this.buildDescription = buildDescription;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((buildDescription == null) ? 0 : buildDescription.hashCode());
        result = prime * result + ((hotFix == null) ? 0 : hotFix.hashCode());
        result = prime * result + major;
        result = prime * result + minor;
        result = prime * result + ((patch == null) ? 0 : patch.hashCode());
        result = prime * result
            + ((servicePack == null) ? 0 : servicePack.hashCode());
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
        RecoverPointVersionInformation other = (RecoverPointVersionInformation) obj;
        if (buildDescription == null) {
            if (other.buildDescription != null)
                return false;
        } else if (!buildDescription.equals(other.buildDescription))
            return false;
        if (hotFix == null) {
            if (other.hotFix != null)
                return false;
        } else if (!hotFix.equals(other.hotFix))
            return false;
        if (major != other.major)
            return false;
        if (minor != other.minor)
            return false;
        if (patch == null) {
            if (other.patch != null)
                return false;
        } else if (!patch.equals(other.patch))
            return false;
        if (servicePack == null) {
            if (other.servicePack != null)
                return false;
        } else if (!servicePack.equals(other.servicePack))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RecoverPointVersionInformation [buildDescription=")
            .append(buildDescription).append(", hotFix=").append(hotFix)
            .append(", major=").append(major).append(", minor=").append(
            minor).append(", patch=").append(patch).append(
            ", servicePack=").append(servicePack).append("]");
        return builder.toString();
    }
}
