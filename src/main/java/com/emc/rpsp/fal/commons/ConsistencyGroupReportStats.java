package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsistencyGroupReportStats")
public class ConsistencyGroupReportStats {

    @XmlElement(nillable = true)
    private ReportUID reportUID;
    private ReportType type;
    private ReportStatus status;
    private Long startTime;
    private Long endTime;
    private GlobalCopyUID mainGlobalCopy;
    private String username; // Optional
}
