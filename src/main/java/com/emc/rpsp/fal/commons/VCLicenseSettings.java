package com.emc.rpsp.fal.commons;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.*;

@XmlRootElement
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@JsonTypeName("VCLicenseSettings")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VCLicenseSettings")
public class VCLicenseSettings extends LicenseSettings {
    @XmlElement(nillable = true)
    private VirtualCenterUID virtualCenterUid;


    public VCLicenseSettings(VirtualCenterUID virtualCenterUid,
                             LicenseUID licenseUID, int capacity, LicenseCapacityUnit capacityUnit,
                             RecoverPointTimeStamp expirationDate,
                             RecoverPointLicenseType licenseType, Boolean localReplicationOnly) {
        super(licenseUID, capacity, capacityUnit, expirationDate, licenseType, localReplicationOnly);
        this.virtualCenterUid = virtualCenterUid;
    }

}
