package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VMReportStepInfo")
public class VMReportStepInfo {

    @XmlElement(nillable = true)
    VmUID vmUid;
    String vmName;
    Integer priority;
    Boolean critical;
}
