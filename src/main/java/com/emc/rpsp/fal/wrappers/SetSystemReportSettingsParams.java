package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.SystemReportSettings;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SetSystemReportSettingsParams {

    @XmlElement(nillable = true)
    private SystemReportSettings systemReportSettings;
    private String requestedSmtpServerAddress;

}
