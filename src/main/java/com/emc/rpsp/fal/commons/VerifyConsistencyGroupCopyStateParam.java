package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VerifyConsistencyGroupCopyStateParam")
public class VerifyConsistencyGroupCopyStateParam implements Validateable, StateCondition<ConsistencyGroupCopyState> {

    @XmlElement(required = true)
    private ConsistencyGroupCopyUID copyUID;
    private Boolean enabled = null;
    private Integer activePrimaryRPA = null;
    private HashSet<Integer> secondaryRPAs = null;
    @XmlElement(required = true)
    private HashSet<JournalState> possibleJournalStates = null;
    private TimeFrame accessedImageTime = null;
    @XmlElement(required = true)
    private HashSet<StorageAccessState> possibleStorageAccessStates = null;

    public VerifyConsistencyGroupCopyStateParam() {
    }

    public VerifyConsistencyGroupCopyStateParam(ConsistencyGroupCopyUID copyUID, Boolean enabled,
                                                Integer activePrimaryRPA, HashSet<Integer> secondaryRPAs,
                                                HashSet<JournalState> possibleJournalStates,
                                                TimeFrame accessedImageTime,
                                                HashSet<StorageAccessState> possibleStorageAccessStates) {
        this.copyUID = copyUID;
        this.enabled = enabled;
        this.activePrimaryRPA = activePrimaryRPA;
        this.secondaryRPAs = secondaryRPAs;
        this.possibleJournalStates = possibleJournalStates;
        this.accessedImageTime = accessedImageTime;
        this.possibleStorageAccessStates = possibleStorageAccessStates;
    }

    public static VerifyConsistencyGroupCopyStateParam buildCopyCondition(ConsistencyGroupSettings groupSettings,
                                                                          ConsistencyGroupCopySettings copySettings) {
        Boolean enabled = copySettings.isEnabled();
        Integer activePrimaryRPA = groupSettings.getPolicy().getPrimaryRPANumber();
        HashSet<Integer> secondaryRPAs = new HashSet<Integer>(groupSettings.getPolicy().getSecondaryRPAsNumbers());
        HashSet<JournalState> possibleJournalStates = null;
        TimeFrame accessedImageTime = null;
        if (copySettings.getRoleInfo().getRole() != ConsistencyGroupCopyRole.REPLICA) {
            possibleJournalStates = new HashSet<JournalState>(Collections.singleton(JournalState.LOCKED));
        } else if ((copySettings.getImageAccessInformation() != null) && (copySettings.getImageAccessInformation().getImageAccessEnabled())) {
            RecoverPointTimeStamp timeStamp = copySettings.getImageAccessInformation().getImageInformation().getTimeStamp();
            accessedImageTime = new TimeFrame(timeStamp, timeStamp);
        } else {
            possibleJournalStates = new HashSet<JournalState>(Collections.singleton(JournalState.DISTRIBUTING));
        }
        HashSet<StorageAccessState> possibleStorageAccessStates = null; // TODO too complicate to calculate from settings
        return new VerifyConsistencyGroupCopyStateParam(copySettings.getCopyUID(), enabled, activePrimaryRPA, secondaryRPAs,
            possibleJournalStates, accessedImageTime, possibleStorageAccessStates);
    }



    @Override
    public boolean accept(ConsistencyGroupCopyState state) throws FunctionalAPIActionFailedException, FunctionalAPIInternalError {
        if (enabled != null) {
            if (!enabled.equals(state.isEnabled())) {
                return false;
            }
        }
        if (activePrimaryRPA != null) {
            if (!activePrimaryRPA.equals(state.getActivePrimaryRPA())) {
                return false;
            }
        }
        if (secondaryRPAs != null) {
            LinkedList<Integer> stateSecondaryRPAs = state.getActiveSecondaryRPAsList();
            if (stateSecondaryRPAs == null) {
                stateSecondaryRPAs = new LinkedList<Integer>();
            }
            for (Integer rpa : secondaryRPAs) {
                if (!stateSecondaryRPAs.contains(rpa))
                    return false;
            }
        }
        if (possibleJournalStates != null) {
            if (!possibleJournalStates.contains(state.getJournalState())) {
                return false;
            }
        }
        if (accessedImageTime != null) {
            Snapshot accessedImage = state.getAccessedImage();
            if (accessedImage == null) {
                return false;
            }
            if (!accessedImageTime.inRange(accessedImage.getClosingTimeStamp())) {
                return false;
            }
        }
        if (possibleStorageAccessStates != null) {
            if (!possibleStorageAccessStates.contains(state.getStorageAccessState())) {
                return false;
            }
        }
        return true;
    }

    public ConsistencyGroupCopyUID getCopyUID() {
        return copyUID;
    }

    public void setCopyUID(ConsistencyGroupCopyUID copyUID) {
        this.copyUID = copyUID;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Integer getActivePrimaryRPA() {
        return activePrimaryRPA;
    }

    public void setActivePrimaryRPA(Integer activePrimaryRPA) {
        this.activePrimaryRPA = activePrimaryRPA;
    }

    public HashSet<Integer> getSecondaryRPAs() {
        return secondaryRPAs;
    }

    public void setSecondaryRPAs(HashSet<Integer> secondaryRPAs) {
        this.secondaryRPAs = secondaryRPAs;
    }

    public HashSet<JournalState> getPossibleJournalStates() {
        return possibleJournalStates;
    }

    public void setPossibleJournalStates(HashSet<JournalState> possibleJournalStates) {
        this.possibleJournalStates = possibleJournalStates;
    }

    public TimeFrame getAccessedImageTime() {
        return accessedImageTime;
    }

    public void setAccessedImageTime(TimeFrame accessedImageTime) {
        this.accessedImageTime = accessedImageTime;
    }

    public HashSet<StorageAccessState> getPossibleStorageAccessStates() {
        return possibleStorageAccessStates;
    }

    public void setPossibleStorageAccessStates(
        HashSet<StorageAccessState> possibleStorageAccessStates) {
        this.possibleStorageAccessStates = possibleStorageAccessStates;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((accessedImageTime == null) ? 0 : accessedImageTime
            .hashCode());
        result = prime
            * result
            + ((activePrimaryRPA == null) ? 0 : activePrimaryRPA.hashCode());
        result = prime * result + ((copyUID == null) ? 0 : copyUID.hashCode());
        result = prime * result + ((enabled == null) ? 0 : enabled.hashCode());
        result = prime
            * result
            + ((possibleJournalStates == null) ? 0 : possibleJournalStates
            .hashCode());
        result = prime
            * result
            + ((possibleStorageAccessStates == null) ? 0
            : possibleStorageAccessStates.hashCode());
        result = prime * result
            + ((secondaryRPAs == null) ? 0 : secondaryRPAs.hashCode());
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
        VerifyConsistencyGroupCopyStateParam other = (VerifyConsistencyGroupCopyStateParam) obj;
        if (accessedImageTime == null) {
            if (other.accessedImageTime != null)
                return false;
        } else if (!accessedImageTime.equals(other.accessedImageTime))
            return false;
        if (activePrimaryRPA == null) {
            if (other.activePrimaryRPA != null)
                return false;
        } else if (!activePrimaryRPA.equals(other.activePrimaryRPA))
            return false;
        if (copyUID == null) {
            if (other.copyUID != null)
                return false;
        } else if (!copyUID.equals(other.copyUID))
            return false;
        if (enabled == null) {
            if (other.enabled != null)
                return false;
        } else if (!enabled.equals(other.enabled))
            return false;
        if (possibleJournalStates == null) {
            if (other.possibleJournalStates != null)
                return false;
        } else if (!possibleJournalStates.equals(other.possibleJournalStates))
            return false;
        if (possibleStorageAccessStates == null) {
            if (other.possibleStorageAccessStates != null)
                return false;
        } else if (!possibleStorageAccessStates
            .equals(other.possibleStorageAccessStates))
            return false;
        if (secondaryRPAs == null) {
            if (other.secondaryRPAs != null)
                return false;
        } else if (!secondaryRPAs.equals(other.secondaryRPAs))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(
            "VerifyConsistencyGroupCopyStateParam [accessedImageTime=")
            .append(accessedImageTime).append(", activePrimaryRPA=")
            .append(activePrimaryRPA).append(", copyUID=").append(copyUID)
            .append(", enabled=").append(enabled).append(
            ", possibleJournalStates=").append(
            possibleJournalStates).append(
            ", possibleStorageAccessStates=").append(
            possibleStorageAccessStates).append(", secondaryRPAs=")
            .append(secondaryRPAs).append("]");
        return builder.toString();
    }
}
