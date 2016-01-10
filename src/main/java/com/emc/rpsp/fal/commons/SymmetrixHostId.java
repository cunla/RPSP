package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SymmetrixHostId")
public class SymmetrixHostId {

    @XmlElement(nillable = true)
    private RpaUID rpaUID;
    private String hostId;

    public SymmetrixHostId() {

    }

    public SymmetrixHostId(RpaUID rpaUID, String hostId) {
        this.rpaUID = rpaUID;
        this.hostId = hostId;
    }

    /**
     * @return the rpaUID
     */
    public RpaUID getRpaUID() {
        return rpaUID;
    }

    /**
     * @param rpaUID the rpaUID to set
     */
    public void setRpaUID(RpaUID rpaUID) {
        this.rpaUID = rpaUID;
    }

    /**
     * @return the hostId
     */
    public String getHostId() {
        return hostId;
    }

    /**
     * @param hostId the hostId to set
     */
    public void setHostId(String hostId) {
        this.hostId = hostId;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((rpaUID == null) ? 0 : rpaUID.hashCode());
        result = prime * result
            + ((hostId == null) ? 0 : hostId.hashCode());
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
        SymmetrixHostId other = (SymmetrixHostId) obj;
        if (rpaUID == null) {
            if (other.rpaUID != null)
                return false;
        } else if (!rpaUID.equals(other.rpaUID))
            return false;
        if (hostId == null) {
            if (other.hostId != null)
                return false;
        } else if (!hostId.equals(other.hostId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SymmertixHostId [rpaUID=").append(rpaUID)
            .append(", hostId=").append(hostId).append("]");
        return builder.toString();
    }


}
