package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("serial")
@XmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlType(name = "SystemReportSettings")
public class SystemReportSettings implements Validateable {

    private boolean includeSystemReports;
    private boolean includeSystemAlerts;
    private boolean usingCompression;
    private boolean usingEncryption;
    private SystemReportTransferMethod transferMethod;
    private String esrsGatewayAddress;
    private String senderEmail;

}
