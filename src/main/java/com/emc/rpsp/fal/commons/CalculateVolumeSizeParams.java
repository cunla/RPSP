package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlType(name = "CalculateVolumeSizeParams")
public class CalculateVolumeSizeParams implements Validateable {
    private long requiredProtectionWindow;
    private long incomingDataRatePerSecond;

}
