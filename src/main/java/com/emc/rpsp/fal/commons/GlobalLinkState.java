package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "GlobalLinkState")
public class GlobalLinkState {

    private GlobalLinkUID globalLink;
    private boolean deduplicationSupported;

    public GlobalLinkState() {
    }

    public GlobalLinkState(GlobalLinkUID globalLink,
                           boolean deduplicationSupported) {
        this.globalLink = globalLink;
        this.deduplicationSupported = deduplicationSupported;
    }

    public GlobalLinkUID getGlobalLink() {
        return globalLink;
    }

    public void setGlobalLink(GlobalLinkUID globalLink) {
        this.globalLink = globalLink;
    }

    public boolean isDeduplicationSupported() {
        return deduplicationSupported;
    }

    public void setDeduplicationSupported(boolean deduplicationSupported) {
        this.deduplicationSupported = deduplicationSupported;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (deduplicationSupported ? 1231 : 1237);
        result = prime * result
            + ((globalLink == null) ? 0 : globalLink.hashCode());
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
        GlobalLinkState other = (GlobalLinkState) obj;
        if (deduplicationSupported != other.deduplicationSupported)
            return false;
        if (globalLink == null) {
            if (other.globalLink != null)
                return false;
        } else if (!globalLink.equals(other.globalLink))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("GlobalLinkState [globalLink=").append(globalLink)
            .append(", deduplicationSupported=")
            .append(deduplicationSupported).append("]");
        return builder.toString();
    }


}
