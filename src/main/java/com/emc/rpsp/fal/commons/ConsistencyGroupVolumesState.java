package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@XmlRootElement
@XmlType(name = "ConsistencyGroupVolumesState")
////@LargeObject
public class ConsistencyGroupVolumesState {

    private ConsistencyGroupUID groupUID;
    private HashSet<ConsistencyGroupCopyVolumesState> copiesVolumesState;
    private HashSet<ReplicationSetVolumesState> replicationSetsVolumesState;

    public ConsistencyGroupVolumesState() {
    }

    public ConsistencyGroupVolumesState(ConsistencyGroupUID groupUID, HashSet<ConsistencyGroupCopyVolumesState> copiesVolumesState,
                                        HashSet<ReplicationSetVolumesState> replicationSetsVolumesState) {
        this.groupUID = groupUID;
        this.copiesVolumesState = copiesVolumesState;
        this.replicationSetsVolumesState = replicationSetsVolumesState;
    }

    public ConsistencyGroupUID getGroupUID() {
        return groupUID;
    }

    public void setGroupUID(ConsistencyGroupUID groupUID) {
        this.groupUID = groupUID;
    }

    public HashSet<ConsistencyGroupCopyVolumesState> getCopiesVolumesState() {
        return copiesVolumesState;
    }

    public void setCopiesVolumesState(
        HashSet<ConsistencyGroupCopyVolumesState> copiesVolumesState) {
        this.copiesVolumesState = copiesVolumesState;
    }

    public HashSet<ReplicationSetVolumesState> getReplicationSetsVolumesState() {
        return replicationSetsVolumesState;
    }

    public void setReplicationSetsVolumesState(
        HashSet<ReplicationSetVolumesState> replicationSetsVolumesState) {
        this.replicationSetsVolumesState = replicationSetsVolumesState;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((copiesVolumesState == null) ? 0 : copiesVolumesState
            .hashCode());
        result = prime * result
            + ((groupUID == null) ? 0 : groupUID.hashCode());
        result = prime
            * result
            + ((replicationSetsVolumesState == null) ? 0
            : replicationSetsVolumesState.hashCode());
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
        ConsistencyGroupVolumesState other = (ConsistencyGroupVolumesState) obj;
        if (copiesVolumesState == null) {
            if (other.copiesVolumesState != null)
                return false;
        } else if (!copiesVolumesState.equals(other.copiesVolumesState))
            return false;
        if (groupUID == null) {
            if (other.groupUID != null)
                return false;
        } else if (!groupUID.equals(other.groupUID))
            return false;
        if (replicationSetsVolumesState == null) {
            if (other.replicationSetsVolumesState != null)
                return false;
        } else if (!replicationSetsVolumesState
            .equals(other.replicationSetsVolumesState))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ConsistencyGroupVolumesState [copiesVolumesState=")
            .append(copiesVolumesState).append(", groupUID=").append(
            groupUID).append(", replicationSetsVolumesState=")
            .append(replicationSetsVolumesState).append("]");
        return builder.toString();
    }
}
