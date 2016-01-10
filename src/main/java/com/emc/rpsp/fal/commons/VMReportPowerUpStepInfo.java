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
@XmlType(name = "VMReportPowerUpStepInfo")
public class VMReportPowerUpStepInfo {

    @XmlElement(nillable = true)
    private VmStartUpActionUID vmStartUpActionUID;
    private String title; // Optional

}
