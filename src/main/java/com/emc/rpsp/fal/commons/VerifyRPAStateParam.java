package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.HashSet;
import java.util.Set;

/**
 * A condition which can be used to check RPA status.
 * This class was built to provide a condition (of a verifying query) that has similar functionality of the cli's verify_box command.
 * In this condition, every field that is left null will be ignored.
 * volumesConnectivityStatus - if not null, it means we want all volumes in RPAState to have this connectivity status.
 * rpasConnectivityStatus - if not null, it means we want all rpa's in RPAState to have this connectivity status.
 * rpasForConnectivityCheck - if not null, it means we only want these rpa's to have a connectivity status of rpasConnectivityStatus.
 *
 * @author dagano
 */
@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VerifyRPAStateParam")
public class VerifyRPAStateParam implements Validateable, StateCondition<RPAState> {

    @XmlElement(nillable = true)
    private RPAStatus rpaStatus = null;
    private VolumeStatus repositoryStatus = null;
    private Boolean hasClusterControl = null;
    private GeneralStatus volumesConnectivityStatus = null;
    private HashSet<RpaUID> rpasForConnectivityCheck = null;
    private GeneralStatus rpasConnectivityStatus = null;

    public VerifyRPAStateParam() {
    }

    public VerifyRPAStateParam(RPAStatus rpaStatus, VolumeStatus kvolStatus, HashSet<RpaUID> rpasForConnectivityCheck,
                               Boolean hasClusterControl, GeneralStatus rpasConnectivityStatus, GeneralStatus volumesConnectivityStatus) {
        this.rpaStatus = rpaStatus;
        this.repositoryStatus = kvolStatus;
        this.hasClusterControl = hasClusterControl;
        this.volumesConnectivityStatus = volumesConnectivityStatus;
        this.rpasForConnectivityCheck = rpasForConnectivityCheck;
        this.rpasConnectivityStatus = rpasConnectivityStatus;
    }

    @Override
    public boolean accept(RPAState state) throws FunctionalAPIActionFailedException, FunctionalAPIInternalError {
        // trying to find something wrong.
        if (rpaStatus != null) { // check RPA status
            if (!rpaStatus.equals(state.getStatus())) {
                return false;
            }
        }
        if (repositoryStatus != null) { // check kvol status
            if (!repositoryStatus.equals(state.getRepositoryConnectivityStatus())) {
                return false;
            }
        }
        if (hasClusterControl != null) { // check if the rpa is running cluster control
            if (!hasClusterControl.equals(state.isRunningClusterControl())) {
                return false;
            }
        }

        HashSet<VolumeConnectivityStatus> volumes = state.getVolumesConnectivityStatus();
        StateCondition<Set<VolumeConnectivityStatus>> volumesConectivityCondition =
            ConectivityCondition.getConectivityCondition(volumesConnectivityStatus);
        if (!volumesConectivityCondition.accept(volumes)) { // check connectivity to relevant rpa's
            return false;
        }

        HashSet<RPAConnectivityStatus> rpas = extractRelevantRPAs(state);
        StateCondition<Set<RPAConnectivityStatus>> rpasConectivityCondition =
            ConectivityCondition.getConectivityCondition(rpasConnectivityStatus);
        if (!rpasConectivityCondition.accept(rpas)) { // check connectivity to all volumes
            return false;
        }

        // if we didn't find a reason to not accept - we accept.
        return true;
    }

    /**
     * @param state
     * @return all rpa's local and remote, minus those not included in rpasConnectivity (if not null).
     */
    private HashSet<RPAConnectivityStatus> extractRelevantRPAs(RPAState state) {
        HashSet<RPAConnectivityStatus> rpas = new HashSet<RPAConnectivityStatus>();

        rpas.addAll(state.getLocalRPAsFiberConnectivityStatus());
        rpas.addAll(state.getRemoteRPAsConnectivityStatus());

        if (rpasForConnectivityCheck != null) {
            for (RPAConnectivityStatus rpaConnectivityStatus : rpas) {
                if (!rpasForConnectivityCheck.contains(rpaConnectivityStatus.getRpaUID())) { // if the rpa not wanted - remove and ignore it
                    rpas.remove(rpaConnectivityStatus);
                }
            }
        }
        return rpas;
    }

    public RPAStatus getRpaStatus() {
        return rpaStatus;
    }

    public void setRpaStatus(RPAStatus rpaStatus) {
        this.rpaStatus = rpaStatus;
    }

    public VolumeStatus getRepositoryStatus() {
        return repositoryStatus;
    }

    public void setRepositoryStatus(VolumeStatus repositoryStatus) {
        this.repositoryStatus = repositoryStatus;
    }

    public HashSet<RpaUID> getRpasForConnectivityCheck() {
        return rpasForConnectivityCheck;
    }

    public void setRpasForConnectivityCheck(HashSet<RpaUID> rpasForConnectivityCheck) {
        this.rpasForConnectivityCheck = rpasForConnectivityCheck;
    }

    public Boolean getHasClusterControl() {
        return hasClusterControl;
    }

    public void setHasClusterControl(Boolean hasClusterControl) {
        this.hasClusterControl = hasClusterControl;
    }

    public GeneralStatus getRpasConnectivityStatus() {
        return rpasConnectivityStatus;
    }

    public void setRpasConnectivityStatus(GeneralStatus rpasConnectivityStatus) {
        this.rpasConnectivityStatus = rpasConnectivityStatus;
    }

    public void setVolumesConnectivityStatus(GeneralStatus volumesConnectivityStatus) {
        this.volumesConnectivityStatus = volumesConnectivityStatus;
    }

    public GeneralStatus getVolumesConnectivityStatus() {
        return volumesConnectivityStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((hasClusterControl == null) ? 0 : hasClusterControl.hashCode());
        result = prime
            * result
            + ((repositoryStatus == null) ? 0 : repositoryStatus.hashCode());
        result = prime * result
            + ((rpaStatus == null) ? 0 : rpaStatus.hashCode());
        result = prime
            * result
            + ((rpasConnectivityStatus == null) ? 0
            : rpasConnectivityStatus.hashCode());
        result = prime
            * result
            + ((rpasForConnectivityCheck == null) ? 0
            : rpasForConnectivityCheck.hashCode());
        result = prime
            * result
            + ((volumesConnectivityStatus == null) ? 0
            : volumesConnectivityStatus.hashCode());
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
        VerifyRPAStateParam other = (VerifyRPAStateParam) obj;
        if (hasClusterControl == null) {
            if (other.hasClusterControl != null)
                return false;
        } else if (!hasClusterControl.equals(other.hasClusterControl))
            return false;
        if (repositoryStatus == null) {
            if (other.repositoryStatus != null)
                return false;
        } else if (!repositoryStatus.equals(other.repositoryStatus))
            return false;
        if (rpaStatus == null) {
            if (other.rpaStatus != null)
                return false;
        } else if (!rpaStatus.equals(other.rpaStatus))
            return false;
        if (rpasConnectivityStatus == null) {
            if (other.rpasConnectivityStatus != null)
                return false;
        } else if (!rpasConnectivityStatus.equals(other.rpasConnectivityStatus))
            return false;
        if (rpasForConnectivityCheck == null) {
            if (other.rpasForConnectivityCheck != null)
                return false;
        } else if (!rpasForConnectivityCheck
            .equals(other.rpasForConnectivityCheck))
            return false;
        if (volumesConnectivityStatus == null) {
            if (other.volumesConnectivityStatus != null)
                return false;
        } else if (!volumesConnectivityStatus
            .equals(other.volumesConnectivityStatus))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "VerifyRPAStateParam [hasClusterControl=" + hasClusterControl
            + ", repositoryStatus=" + repositoryStatus + ", rpaStatus="
            + rpaStatus + ", rpasConnectivityStatus="
            + rpasConnectivityStatus + ", rpasForConnectivityCheck="
            + rpasForConnectivityCheck + ", volumesConnectivityStatus="
            + volumesConnectivityStatus + "]";
    }
}
