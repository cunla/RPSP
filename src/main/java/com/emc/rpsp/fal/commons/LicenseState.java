package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.HashSet;


@XmlRootElement
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LicenseState")
public class LicenseState {

    @XmlElement(nillable = true)
    private LicenseUID licenseUID;
    @XmlElement(nillable = true)
    private LicenseStatus licenseStatus;
    private Integer daysUntilExpiration;
    private HashSet<ClusterUID> clustersUID;
    @XmlElement(nillable = true)
    private LicenseCapacityUnitAndUsed licenseCapacityUnitAndUsed;
}
