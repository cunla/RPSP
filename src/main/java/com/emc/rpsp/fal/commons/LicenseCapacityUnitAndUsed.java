package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;


@XmlRootElement
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LicenseCapacityUnitAndUsed")
public class LicenseCapacityUnitAndUsed {

    @XmlElement(nillable = true)
    private LicenseCapacityUnit licenseCapacityUnit;
    private long used;
}
