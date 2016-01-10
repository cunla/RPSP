package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlType(name = "ManagementSettings")
public class ManagementSettings {

    @XmlElement(nillable = true)
    private UsersSettings usersSettings;
    private SystemAlertsSettings alertsSettings;
    private SystemReportSettings reportSettings;
    @XmlElement(nillable = true)
    private SNMPSettings snmpSettings;
    private SystemMiscellaneousSettings miscSettings;
    @XmlElement(nillable = true)
    private SyslogSettings syslogSettings;
    @XmlElement(nillable = true)
    private VCenterServersViewSettings vcenterServersViewSettings;
    @XmlElement(nillable = true)
    private TimeSettings timeSettings;
    private boolean showFirstTimeWizard;
    private CallHomeEvents callHomeEventsSettings;
    private HashSet<SystemEventLogsFilter> systemEventLogsFilters;
    @XmlElement(nillable = true)
    private UserDefinedProperties userDefinedProperties;
    private String smtpServerAddress;
    @XmlElement(nillable = true)
    private PolicyTemplates policyTemplates;

}
