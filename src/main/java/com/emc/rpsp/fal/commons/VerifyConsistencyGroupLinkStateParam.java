package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VerifyConsistencyGroupLinkStateParam")
public class VerifyConsistencyGroupLinkStateParam implements Validateable, StateCondition<ConsistencyGroupLinkState> {

    @XmlElement(required = true)
    private ConsistencyGroupLinkUID linkUID;
    @XmlElement(nillable = true)
    private PipeState pipeState = null;

    public VerifyConsistencyGroupLinkStateParam() {
    }

    public VerifyConsistencyGroupLinkStateParam(ConsistencyGroupLinkUID linkUID, PipeState pipeState) {
        this.linkUID = linkUID;
        this.pipeState = pipeState;
    }

    public static VerifyConsistencyGroupLinkStateParam buildLinkCondition(ConsistencyGroupSettings groupSettings,
                                                                          ConsistencyGroupLinkSettings linkSettings) {
        PipeState settingsPipeState = null;
        ConsistencyGroupCopySettings targetCopy = getTargetCopy(linkSettings, groupSettings);
        if (targetCopy.getRoleInfo().getRole() == ConsistencyGroupCopyRole.REPLICA) {
            if (linkSettings.isTransferEnabled()) {
                settingsPipeState = PipeState.ACTIVE;
            }
        }
        return new VerifyConsistencyGroupLinkStateParam(linkSettings.getGroupLinkUID(), settingsPipeState);
    }

    private static ConsistencyGroupCopySettings getTargetCopy(ConsistencyGroupLinkSettings linkSettings, ConsistencyGroupSettings groupSettings) {
        GlobalCopyUID secondCopyUID = linkSettings.getGroupLinkUID().getSecondCopy();
        HashSet<ConsistencyGroupCopySettings> groupCopiesSettings = groupSettings.getGroupCopiesSettings();
        for (ConsistencyGroupCopySettings consistencyGroupCopySettings : groupCopiesSettings) {
            if (consistencyGroupCopySettings.getCopyUID().getGlobalCopyUID().equals(secondCopyUID))
                return consistencyGroupCopySettings;
        }
        return null;
    }

    @Override
    public boolean accept(ConsistencyGroupLinkState state) throws FunctionalAPIActionFailedException, FunctionalAPIInternalError {
        if (pipeState != null) {
            if (!pipeState.equals(state.getPipeState())) {
                return false;
            }
        }
        return true;
    }

    public ConsistencyGroupLinkUID getLinkUID() {
        return linkUID;
    }

    public void setLinkUID(ConsistencyGroupLinkUID linkUID) {
        this.linkUID = linkUID;
    }

    public PipeState getPipeState() {
        return pipeState;
    }

    public void setPipeState(PipeState pipeState) {
        this.pipeState = pipeState;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((linkUID == null) ? 0 : linkUID.hashCode());
        result = prime * result
            + ((pipeState == null) ? 0 : pipeState.hashCode());
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
        VerifyConsistencyGroupLinkStateParam other = (VerifyConsistencyGroupLinkStateParam) obj;
        if (linkUID == null) {
            if (other.linkUID != null)
                return false;
        } else if (!linkUID.equals(other.linkUID))
            return false;
        if (pipeState == null) {
            if (other.pipeState != null)
                return false;
        } else if (!pipeState.equals(other.pipeState))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("VerifyConsistencyGroupLinkStateParam [linkUID=")
            .append(linkUID).append(", pipeState=").append(pipeState)
            .append("]");
        return builder.toString();
    }
}
