package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsistencyGroupReport")
public class ConsistencyGroupReport {

    @XmlElement(nillable = true)
    private ReportUID reportUID;
    private ReportType type;
    private ReportStatus status;
    private GlobalCopyUID mainGlobalCopy;
    private Long startTime;
    private Long endTime; // Optional
    private String username; // Optional

    private List<ConsistencyGroupReportStep> reportSteps; //All the report steps with info combined from settings and state
    @XmlElement(nillable = true)
    private VMPersistentReportInfo vmPersistentReportInfo;
    private long context;
    private Integer progressPercentage; //null means this info is unavailable

}
