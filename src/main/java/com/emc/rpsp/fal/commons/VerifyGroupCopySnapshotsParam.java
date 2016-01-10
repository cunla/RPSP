package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;
import java.util.LinkedList;

/**
 * Verify the snapshots includes a specific snapshot (identified by it's description)
 *
 * @author dagano
 */
@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VerifyGroupCopySnapshotsParam")
public class VerifyGroupCopySnapshotsParam implements Validateable, StateCondition<ConsistencyGroupCopySnapshots> {

    @XmlElement(required = true)
    private String snapshotDescription = null;

    public VerifyGroupCopySnapshotsParam() {
    }

    public VerifyGroupCopySnapshotsParam(String snapshotDescription) {
        this.snapshotDescription = snapshotDescription;
    }

    public String getSnapshotDescription() {
        return snapshotDescription;
    }

    public void setSnapshotDescription(String snapshotDescription) {
        this.snapshotDescription = snapshotDescription;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((snapshotDescription == null) ? 0 : snapshotDescription
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
        VerifyGroupCopySnapshotsParam other = (VerifyGroupCopySnapshotsParam) obj;
        if (snapshotDescription == null) {
            if (other.snapshotDescription != null)
                return false;
        } else if (!snapshotDescription.equals(other.snapshotDescription))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "VerifyGroupCopySnapshotsParam [snapshotDescription="
            + snapshotDescription + "]";
    }

    @Override
    public boolean accept(ConsistencyGroupCopySnapshots state) {
        // checks if a snapshot with the desired description exists
        LinkedList<Snapshot> snapshots = state.getSnapshots();
        if (snapshots == null) {
            return false;
        }

        for (Snapshot snapshot : snapshots) {
            String description = snapshot.getDescription();
            if ((description != null) && description.equals(snapshotDescription))
                return true; // we found one
        }
        return false; // we didn't find any matching snapshot
    }

}
