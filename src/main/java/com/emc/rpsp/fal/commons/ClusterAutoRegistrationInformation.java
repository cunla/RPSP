package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlType(name = "ClusterAutoRegistrationInformation")
public class ClusterAutoRegistrationInformation implements Validateable {
    private String sitePartyId;
    private String companyName;
    private String location;
    private InstallationPerformingResource installationResource;
    private InstallationActivityType installatoinType;
    private String salesOrderNumber;
    private ConnectHomeMethod connectHome;
    private ConnectInMethod connectInMethodSoftware;
    private ConnectInMethod connectInMethodHardware;
    private Boolean vce;

}
