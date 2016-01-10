package com.emc.rpsp.fal.commons;

import lombok.*;
import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@XmlRootElement
@XmlType(name = "ConsistencyGroupCopyRecoveryActivity")
@JsonTypeName("ConsistencyGroupCopyRecoveryActivity")
public class ConsistencyGroupCopyRecoveryActivity extends BaseRecoveryActivity {

    private RecoveryActivityState activityState;
    private ConsistencyGroupCopyUID copyUID;
    private String copyName;
    private String groupName;
    private PipeState transferState;
    private Double tspUsagePercentage;
    private Long imageAccessTotalSizeInBytes;
    private Long imageAccessSizeLeftInBytes;
    private boolean transferEnabled;
    private boolean inImageAccess;
    private int numOfVmStartUpActionState;
    private boolean canBeSetAsProduction;
    private boolean canGroupResumeProduction;
    private ConsistencyGroupCopyUID activeProductionCopy;

    public ConsistencyGroupCopyRecoveryActivity(ImageAccessScenario activity,
                                                RecoveryActivityState activityState, ConsistencyGroupCopyUID copyUID,
                                                String copyName, String groupName, String clusterName,
                                                PipeState transferState, Double tspUsagePercentage,
                                                Long imageAccessTotalSizeInBytes, Long imageAccessSizeLeftInBytes,
                                                boolean isTransferEnabled, boolean isInImageAccess,
                                                int numOfVmStartUpActionState, boolean canBeSetAsProduction,
                                                boolean canGroupResumeProduction,
                                                ConsistencyGroupCopyUID activeProductionCopy) {
        super(activity, clusterName);
        this.activityState = activityState;
        this.copyUID = copyUID;
        this.copyName = copyName;
        this.groupName = groupName;
        this.transferState = transferState;
        this.tspUsagePercentage = tspUsagePercentage;
        this.imageAccessTotalSizeInBytes = imageAccessTotalSizeInBytes;
        this.imageAccessSizeLeftInBytes = imageAccessSizeLeftInBytes;
        this.transferEnabled = isTransferEnabled;
        this.inImageAccess = isInImageAccess;
        this.numOfVmStartUpActionState = numOfVmStartUpActionState;
        this.canBeSetAsProduction = canBeSetAsProduction;
        this.canGroupResumeProduction = canGroupResumeProduction;
        this.activeProductionCopy = activeProductionCopy;
    }

}
