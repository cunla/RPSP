package com.emc.rpsp.fal.commons;

import lombok.*;
import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsistencyGroupSetRecoveryActivity")
@JsonTypeName("ConsistencyGroupSetRecoveryActivity")
public class ConsistencyGroupSetRecoveryActivity extends BaseRecoveryActivity {

    @XmlElement(nillable = true)
    private ConsistencyGroupSetUID consistencyGroupSetUID;
    private String groupSetName;
    @XmlElement(nillable = true)
    private ClusterUID clusterUID;
    private int numOfGroupsInImageAccess;
    private int numOfGroups;
    private GroupSetTransferState consistencyGroupSetTransferState;
    private HashSet<ConsistencyGroupCopyRecoveryActivity> copiesRecoveryActivities;
    private ConsistencyGroupCopyUID copyToResumeProduction;


    public ConsistencyGroupSetRecoveryActivity(
        ImageAccessScenario activity,
        ConsistencyGroupSetUID consistencyGroupSetUID,
        String groupSetName,
        ClusterUID clusterUID,
        String clusterName,
        int numOfGroups,
        int numOfGroupsInImageAccess,
        GroupSetTransferState consistencyGroupSetTransferState,
        ConsistencyGroupCopyUID copyToResumeProduction,
        HashSet<ConsistencyGroupCopyRecoveryActivity> copiesRecoveryActivities) {

        super(activity, clusterName);
        this.consistencyGroupSetUID = consistencyGroupSetUID;
        this.groupSetName = groupSetName;
        this.clusterUID = clusterUID;
        this.numOfGroupsInImageAccess = numOfGroupsInImageAccess;
        this.numOfGroups = numOfGroups;
        this.consistencyGroupSetTransferState = consistencyGroupSetTransferState;
        this.copyToResumeProduction = copyToResumeProduction;
        this.copiesRecoveryActivities = copiesRecoveryActivities;
    }

}
