package com.emc.rpsp.fal.commons;

import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Set;

/**
 * A condition to check a volume access state.
 * The condition takes a wantedAccessState and it makes sure all fields that are not null, are equals to the corresponding field in the state.
 *
 * @author dagano
 */
@XmlRootElement
@XmlType(name = "VolumeAccessCondition")
@NoArgsConstructor
public class VolumeAccessCondition<T extends AttachedUserVolumeAccessState> implements StateCondition<T> {

    private VolumeAccessState _wantedAccessState;

    public VolumeAccessCondition(VolumeAccessState wantedAccessState) {
        _wantedAccessState = wantedAccessState;
    }

    @Override
    public boolean accept(T state) {
        VolumeAccessState accessState = state.getAccessState();

        // try to find something wrong.
        if (_wantedAccessState.getWritable() != null) {
            if (!_wantedAccessState.getWritable().equals(accessState.getWritable())) {
                return false;
            }
        }
        if (_wantedAccessState.getSplittingToVolume() != null) {
            if (!_wantedAccessState.getSplittingToVolume().equals(accessState.getSplittingToVolume())) {
                return false;
            }
        }
        if (_wantedAccessState.getMarkingDataOnSplitter() != null) {
            if (!_wantedAccessState.getMarkingDataOnSplitter().equals(accessState.getMarkingDataOnSplitter())) {
                return false;
            }
        }
        if (_wantedAccessState.getDelayed() != null) {
            if (!_wantedAccessState.getDelayed().equals(accessState.getDelayed())) {
                return false;
            }
        }
        if (_wantedAccessState.getTargetRPA() != null) {
            if (!_wantedAccessState.getTargetRPA().equals(accessState.getTargetRPA())) {
                return false;
            }
        }
        if (_wantedAccessState.getAttachedToOtherCluster() != null) {
            if (!_wantedAccessState.getAttachedToOtherCluster().equals(accessState.getAttachedToOtherCluster())) {
                return false;
            }
        }
        if (_wantedAccessState.getInErrorState() != null) {
            if (!_wantedAccessState.getInErrorState().equals(accessState.getInErrorState())) {
                return false;
            }
        }
        if (_wantedAccessState.getBusy() != null) {
            if (!_wantedAccessState.getBusy().equals(accessState.getBusy())) {
                return false;
            }
        }
        if (_wantedAccessState.getReadOnly() != null) {
            if (!_wantedAccessState.getReadOnly().equals(accessState.getReadOnly())) {
                return false;
            }
        }

        // found nothing wrong, assuming OK.
        return true;
    }

    /**
     * @param <T>
     * @param ConnectivityStatus
     * @return a condition that will accepts sets of T's (VolumeAccessState) which all have the a status that matches accessStatus.
     */
    public static <T extends AttachedUserVolumeAccessState> StateCondition<Set<T>> getAccessCondition(VolumeAccessState accessStatus) {
        if (accessStatus == null) {
            return VerifyConsistencyGroupStateParam.acceptCondition();
        }
        StateCondition<T> condition = new VolumeAccessCondition<T>(accessStatus);
        return new ConditionAcceptsAll<T>(condition);
    }
}
