package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@JsonTypeName("ConsistencyGroupReportVMStep")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({ConsistencyGroupReportStartUpStep.class})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "JsonSubType")
@JsonSubTypes({
    @Type(value = ConsistencyGroupReportStartUpStep.class, name = "ConsistencyGroupReportStartUpStep")})
@XmlType(name = "ConsistencyGroupReportVMStep")
public class ConsistencyGroupReportVMStep extends ConsistencyGroupReportStep {

    @XmlElement(nillable = true)
    private VmUID vmUid;

    public ConsistencyGroupReportVMStep(ReportStepUID reportStepUID, GlobalCopyUID ownerCopy, ReportStepType stepType,
                                        ReportStepStatus status, Long startTime, Long endTime, List<ConsistencyGroupReportStep> subSteps, VmUID vmUid) {
        super(reportStepUID, ownerCopy, stepType, status, startTime, endTime, subSteps);
        this.vmUid = vmUid;
    }

}
