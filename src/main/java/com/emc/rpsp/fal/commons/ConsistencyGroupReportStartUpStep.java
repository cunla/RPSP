package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@JsonTypeName("ConsistencyGroupReportStartUpStep")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsistencyGroupReportStartUpStep")
public class ConsistencyGroupReportStartUpStep extends ConsistencyGroupReportVMStep {

    @XmlElement(nillable = true)
    private VmStartUpActionUID vmStartUpActionUID;

    public ConsistencyGroupReportStartUpStep(ReportStepUID reportStepUID, GlobalCopyUID ownerCopy, ReportStepType stepType,
                                             ReportStepStatus status, Long startTime, Long endTime, List<ConsistencyGroupReportStep> subSteps, VmUID vmUid, VmStartUpActionUID vmStartUpActionUID) {
        super(reportStepUID, ownerCopy, stepType, status, startTime, endTime, subSteps, vmUid);
        this.vmStartUpActionUID = vmStartUpActionUID;
    }

}
