package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FullConsistencyGroupLinkPolicy")
public class FullConsistencyGroupLinkPolicy implements Validateable {

    @XmlElement(required = true)
    private ConsistencyGroupLinkUID linkUID;
    @XmlElement(required = true)
    private ConsistencyGroupLinkPolicy linkPolicy;

    public FullConsistencyGroupLinkPolicy() {
    }

    public FullConsistencyGroupLinkPolicy(ConsistencyGroupLinkUID linkUID, ConsistencyGroupLinkPolicy linkPolicy) {
        this.linkUID = linkUID;
        this.linkPolicy = linkPolicy;
    }

    public ConsistencyGroupLinkUID getLinkUID() {
        return linkUID;
    }

    public void setLinkUID(ConsistencyGroupLinkUID linkUID) {
        this.linkUID = linkUID;
    }

    public ConsistencyGroupLinkPolicy getLinkPolicy() {
        return linkPolicy;
    }

    public void setLinkPolicy(ConsistencyGroupLinkPolicy linkPolicy) {
        this.linkPolicy = linkPolicy;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((linkPolicy == null) ? 0 : linkPolicy.hashCode());
        result = prime * result + ((linkUID == null) ? 0 : linkUID.hashCode());
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
        FullConsistencyGroupLinkPolicy other = (FullConsistencyGroupLinkPolicy) obj;
        if (linkPolicy == null) {
            if (other.linkPolicy != null)
                return false;
        } else if (!linkPolicy.equals(other.linkPolicy))
            return false;
        if (linkUID == null) {
            if (other.linkUID != null)
                return false;
        } else if (!linkUID.equals(other.linkUID))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("FullConsistencyGroupLinkPolicy [linkPolicy=").append(
            linkPolicy).append(", linkUID=").append(linkUID).append("]");
        return builder.toString();
    }
}
