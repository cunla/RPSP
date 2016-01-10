package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;


@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RPOPolicy")
public class RPOPolicy implements Validateable {

    private Quantity maximumAllowedLag;
    private boolean allowRegulation;
    @XmlElement(required = true)
    private RPOMinimizationType minimizationType; // relevant only for remote link

    public RPOPolicy() {
    }

    public RPOPolicy(Quantity maximumAllowedLag, boolean allowRegulation, RPOMinimizationType minimizationType) {
        this.maximumAllowedLag = maximumAllowedLag;
        this.allowRegulation = allowRegulation;
        this.minimizationType = minimizationType;
    }

    public Quantity getMaximumAllowedLag() {
        return maximumAllowedLag;
    }

    public void setMaximumAllowedLag(Quantity maximumAllowedLag) {
        this.maximumAllowedLag = maximumAllowedLag;
    }

    public boolean getAllowRegulation() {
        return allowRegulation;
    }

    public void setAllowRegulation(boolean allowRegulation) {
        this.allowRegulation = allowRegulation;
    }

    public RPOMinimizationType getMinimizationType() {
        return minimizationType;
    }

    public void setMinimizationType(RPOMinimizationType minimizationType) {
        this.minimizationType = minimizationType;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (allowRegulation ? 1231 : 1237);
        result = prime
            * result
            + ((maximumAllowedLag == null) ? 0 : maximumAllowedLag
            .hashCode());
        result = prime
            * result
            + ((minimizationType == null) ? 0 : minimizationType.hashCode());
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
        RPOPolicy other = (RPOPolicy) obj;
        if (allowRegulation != other.allowRegulation)
            return false;
        if (maximumAllowedLag == null) {
            if (other.maximumAllowedLag != null)
                return false;
        } else if (!maximumAllowedLag.equals(other.maximumAllowedLag))
            return false;
        if (minimizationType == null) {
            if (other.minimizationType != null)
                return false;
        } else if (!minimizationType.equals(other.minimizationType))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RPOPolicy [allowRegulation=").append(allowRegulation)
            .append(", maximumAllowedLag=").append(maximumAllowedLag)
            .append(", minimizationType=").append(minimizationType).append(
            "]");
        return builder.toString();
    }
}
