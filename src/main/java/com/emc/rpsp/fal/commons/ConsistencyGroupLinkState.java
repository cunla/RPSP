package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsistencyGroupLinkState")
public class ConsistencyGroupLinkState {

    private ConsistencyGroupLinkUID groupLinkUID;
    @XmlElement(nillable = true)
    private PipeState pipeState;
    private String transferErrorReason;
    private boolean inSyncMode;
    private boolean stateUnknown;

    public ConsistencyGroupLinkState() {
    }

    public ConsistencyGroupLinkState(ConsistencyGroupLinkUID groupLinkUID, PipeState pipeState, String transferErrorReason,
                                     boolean inSyncMode, boolean stateUnknown) {
        this.groupLinkUID = groupLinkUID;
        this.pipeState = pipeState;
        this.transferErrorReason = transferErrorReason;
        this.inSyncMode = inSyncMode;
        this.stateUnknown = stateUnknown;
    }

    public ConsistencyGroupLinkUID getGroupLinkUID() {
        return groupLinkUID;
    }

    public void setGroupLinkUID(ConsistencyGroupLinkUID groupLinkUID) {
        this.groupLinkUID = groupLinkUID;
    }

    public PipeState getPipeState() {
        return pipeState;
    }

    public void setPipeState(PipeState pipeState) {
        this.pipeState = pipeState;
    }

    public String getTransferErrorReason() {
        return transferErrorReason;
    }

    public void setTransferErrorReason(String transferErrorReason) {
        this.transferErrorReason = transferErrorReason;
    }

    public boolean getInSyncMode() {
        return inSyncMode;
    }

    public void setInSyncMode(boolean inSyncMode) {
        this.inSyncMode = inSyncMode;
    }

    public boolean getStateUnknown() {
        return stateUnknown;
    }

    public void setStateUnknown(boolean stateUnknown) {
        this.stateUnknown = stateUnknown;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((groupLinkUID == null) ? 0 : groupLinkUID.hashCode());
        result = prime * result + (inSyncMode ? 1231 : 1237);
        result = prime * result
            + ((pipeState == null) ? 0 : pipeState.hashCode());
        result = prime * result + (stateUnknown ? 1231 : 1237);
        result = prime
            * result
            + ((transferErrorReason == null) ? 0 : transferErrorReason
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
        ConsistencyGroupLinkState other = (ConsistencyGroupLinkState) obj;
        if (groupLinkUID == null) {
            if (other.groupLinkUID != null)
                return false;
        } else if (!groupLinkUID.equals(other.groupLinkUID))
            return false;
        if (inSyncMode != other.inSyncMode)
            return false;
        if (pipeState == null) {
            if (other.pipeState != null)
                return false;
        } else if (!pipeState.equals(other.pipeState))
            return false;
        if (stateUnknown != other.stateUnknown)
            return false;
        if (transferErrorReason == null) {
            if (other.transferErrorReason != null)
                return false;
        } else if (!transferErrorReason.equals(other.transferErrorReason))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ConsistencyGroupLinkState [groupLinkUID=").append(
            groupLinkUID).append(", inSyncMode=").append(inSyncMode)
            .append(", pipeState=").append(pipeState).append(
            ", stateUnknown=").append(stateUnknown).append(
            ", transferErrorReason=").append(transferErrorReason)
            .append("]");
        return builder.toString();
    }
}
