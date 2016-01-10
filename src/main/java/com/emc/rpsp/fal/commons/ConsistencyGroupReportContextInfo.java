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
@XmlType(name = "ConsistencyGroupReportContextInfo")
public class ConsistencyGroupReportContextInfo {

    @XmlElement(nillable = true)
    private ReportUID reportUID;
    private long context;
    private boolean inProgress;
    @XmlElement(nillable = true)
    private ReportStatus reportStatus;
}
