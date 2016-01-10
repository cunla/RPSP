package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlType(name = "VMPersistentReportInfo")
public class VMPersistentReportInfo {

    private Set<VMReportStepInfo> vmReportStepInfoSet;
    private Set<VMReportPowerUpStepInfo> vmReportPowerUpStepInfoSet;
}
