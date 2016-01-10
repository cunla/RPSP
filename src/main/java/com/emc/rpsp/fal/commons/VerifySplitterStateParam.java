package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.HashSet;
import java.util.Set;

/**
 * A condition which can be used to check Splitter status.
 * This class was built to provide a condition (of a verifying query) that has similar functionality of the cli's verify_splitter command.
 * In this condition, every field that is left null will simply be ignored.
 *
 * @author dagano
 */
@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VerifySplitterStateParam")
public class VerifySplitterStateParam implements Validateable, StateCondition<SplitterState> {

    @XmlElement(nillable = true)
    private SplitterStatus splitterStatus = null;
    private HashSet<RpaUID> rpasForConnectivityCheck = null;
    private GeneralStatus rpasConnectivityStatus = null;
    private VolumeAccessState volumesAccess = null;
    private HashSet<ConsistencyGroupCopyUID> groupCopiesToCheck = null;

    public VerifySplitterStateParam() {
    }

    public VerifySplitterStateParam(SplitterStatus splitterStatus,
                                    HashSet<RpaUID> rpasForConnectivityCheck,
                                    GeneralStatus rpasConnectivityStatus,
                                    VolumeAccessState volumesAccess,
                                    HashSet<ConsistencyGroupCopyUID> groupCopiesToCheck) {
        this.splitterStatus = splitterStatus;
        this.rpasForConnectivityCheck = rpasForConnectivityCheck;
        this.rpasConnectivityStatus = rpasConnectivityStatus;
        this.volumesAccess = volumesAccess;
        this.groupCopiesToCheck = groupCopiesToCheck;
    }

    @Override
    public boolean accept(SplitterState state) throws FunctionalAPIActionFailedException, FunctionalAPIInternalError {
        // trying to find something wrong.
        if (splitterStatus != null) { // check Splitter status
            if (!splitterStatus.equals(state.getSplitterStatus())) {
                return false;
            }
        }
        HashSet<RPAConnectivityStatus> rpas = extractRelevantRPAs(state);
        StateCondition<Set<RPAConnectivityStatus>> rpasConectivityCondition =
            ConectivityCondition.getConectivityCondition(rpasConnectivityStatus);
        if (!rpasConectivityCondition.accept(rpas)) { // check connectivity to all rpas
            return false;
        }

        HashSet<AttachedUserVolumeAccessState> volumes = extractRelevantVolumes(state);
        StateCondition<Set<AttachedUserVolumeAccessState>> volumesAccessCondition =
            VolumeAccessCondition.getAccessCondition(volumesAccess);
        if (!volumesAccessCondition.accept(volumes)) { // check connectivity to all rpas
            return false;
        }

        // if we didn't find a reason to not accept - we accept.
        return true;
    }

    private HashSet<AttachedUserVolumeAccessState> extractRelevantVolumes(SplitterState state) {
        HashSet<AttachedUserVolumeAccessState> volumes = new HashSet<AttachedUserVolumeAccessState>();

        volumes.addAll(state.getVolumesAccessState());

        if (groupCopiesToCheck != null) {
            for (AttachedUserVolumeAccessState volumeAccessState : volumes) {
                if (!groupCopiesToCheck.contains(volumeAccessState.getGroupCopyUID())) { // if the volume not wanted - remove and ignore it
                    volumes.remove(volumeAccessState);
                }
            }
        }
        return volumes;
    }

    /**
     * @param state
     * @return all rpa's in the state, minus those not included in rpasConnectivity (if not null).
     * returns an empty set if rpasConnectivityStatus is null (because this mean we don't care about any of the rpa's)
     */
    private HashSet<RPAConnectivityStatus> extractRelevantRPAs(SplitterState state) {
        HashSet<RPAConnectivityStatus> rpas = new HashSet<RPAConnectivityStatus>();

        rpas.addAll(state.getRpasConnectivityStatus());

        if (rpasForConnectivityCheck != null) {
            for (RPAConnectivityStatus rpaConnectivityStatus : rpas) {
                if (!rpasForConnectivityCheck.contains(rpaConnectivityStatus.getRpaUID())) { // if the rpa not wanted - remove and ignore it
                    rpas.remove(rpaConnectivityStatus);
                }
            }
        }
        return rpas;
    }

    public SplitterStatus getSplitterStatus() {
        return splitterStatus;
    }

    public void setSplitterStatus(SplitterStatus splitterStatus) {
        this.splitterStatus = splitterStatus;
    }

    public HashSet<RpaUID> getRpasForConnectivityCheck() {
        return rpasForConnectivityCheck;
    }

    public void setRpasForConnectivityCheck(HashSet<RpaUID> rpasForConnectivityCheck) {
        this.rpasForConnectivityCheck = rpasForConnectivityCheck;
    }

    public VolumeAccessState getVolumesAccess() {
        return volumesAccess;
    }

    public void setVolumesAccess(VolumeAccessState volumesAccess) {
        this.volumesAccess = volumesAccess;
    }

    public HashSet<ConsistencyGroupCopyUID> getGroupCopiesToCheck() {
        return groupCopiesToCheck;
    }

    public void setGroupCopiesToCheck(HashSet<ConsistencyGroupCopyUID> groupCopiesToCheck) {
        this.groupCopiesToCheck = groupCopiesToCheck;
    }

    public GeneralStatus getRpasConnectivityStatus() {
        return rpasConnectivityStatus;
    }

    public void setRpasConnectivityStatus(GeneralStatus rpasConnectivityStatus) {
        this.rpasConnectivityStatus = rpasConnectivityStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((groupCopiesToCheck == null) ? 0 : groupCopiesToCheck
            .hashCode());
        result = prime
            * result
            + ((rpasConnectivityStatus == null) ? 0
            : rpasConnectivityStatus.hashCode());
        result = prime
            * result
            + ((rpasForConnectivityCheck == null) ? 0
            : rpasForConnectivityCheck.hashCode());
        result = prime * result
            + ((splitterStatus == null) ? 0 : splitterStatus.hashCode());
        result = prime * result
            + ((volumesAccess == null) ? 0 : volumesAccess.hashCode());
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
        VerifySplitterStateParam other = (VerifySplitterStateParam) obj;
        if (groupCopiesToCheck == null) {
            if (other.groupCopiesToCheck != null)
                return false;
        } else if (!groupCopiesToCheck.equals(other.groupCopiesToCheck))
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
        if (splitterStatus == null) {
            if (other.splitterStatus != null)
                return false;
        } else if (!splitterStatus.equals(other.splitterStatus))
            return false;
        if (volumesAccess == null) {
            if (other.volumesAccess != null)
                return false;
        } else if (!volumesAccess.equals(other.volumesAccess))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("VerifySplitterStateParam [groupCopiesToCheck=").append(
            groupCopiesToCheck).append(", rpasConnectivityStatus=").append(
            rpasConnectivityStatus).append(", rpasForConnectivityCheck=")
            .append(rpasForConnectivityCheck).append(", splitterStatus=")
            .append(splitterStatus).append(", volumesAccess=").append(
            volumesAccess).append("]");
        return builder.toString();
    }
}
