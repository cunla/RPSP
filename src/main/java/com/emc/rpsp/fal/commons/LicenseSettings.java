package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@AllArgsConstructor
@NoArgsConstructor

@XmlSeeAlso({ArrayLicenseSettings.class, ClusterLicenseSettings.class, VCLicenseSettings.class})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "JsonSubType")
@JsonSubTypes({
    @Type(value = ArrayLicenseSettings.class, name = "ArrayLicenseSettings"),
    @Type(value = ClusterLicenseSettings.class, name = "ClusterLicenseSettings"),
    @Type(value = VCLicenseSettings.class, name = "VCLicenseSettings")})
@XmlType(name = "LicenseSettings")
public abstract class LicenseSettings {

    @XmlElement(nillable = true)
    private LicenseUID licenseUID; //get value from map in MgmtState

    private int capacity;
    private LicenseCapacityUnit capacityUnit;
    private RecoverPointTimeStamp expirationDate;
    private RecoverPointLicenseType licenseType;
    private Boolean localReplicationOnly;
}
