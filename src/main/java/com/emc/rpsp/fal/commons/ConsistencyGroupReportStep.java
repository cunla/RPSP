package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlSeeAlso({ConsistencyGroupReportVMStep.class})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "JsonSubType")
@JsonSubTypes({
    @Type(value = ConsistencyGroupReportVMStep.class, name = "ConsistencyGroupReportVMStep")})
@XmlType(name = "ConsistencyGroupReportStep")
public class ConsistencyGroupReportStep {

    private ReportStepUID stepUID;
    private GlobalCopyUID ownerCopy;
    private ReportStepType stepType;
    private ReportStepStatus stepStatus;
    private Long startTime;    // Optional
    private Long endTime;    // Optional
    private List<ConsistencyGroupReportStep> subSteps;
}
