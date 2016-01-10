package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import javax.xml.bind.annotation.*;
import java.util.LinkedList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

@XmlSeeAlso({ClariionVolumeInformation.class, VirtualVolumeInformation.class, SymmetrixVolumeInformation.class, VplexVolumeInformation.class})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "JsonSubType")
@JsonSubTypes({
    @Type(value = ClariionVolumeInformation.class, name = "ClariionVolumeInformation"),
    @Type(value = VirtualVolumeInformation.class, name = "VirtualVolumeInformation"),
    @Type(value = SymmetrixVolumeInformation.class, name = "SymmetrixVolumeInformation"),
    @Type(value = VplexVolumeInformation.class, name = "VplexVolumeInformation")})
@XmlType(name = "VolumeInformation")
////@LargeObject
public class VolumeInformation {

    private LinkedList<Byte> rawUid;
    private LinkedList<Byte> naaUid;
    private DeviceUID volumeID;
    private String vendorName;
    private String productName;
    private String modelName;
    private Long sizeInBytes;
    private String vendorSpecificInformation;
    private String volumeName;
    private String arraySerialNumber;
    private Boolean onArrayWithRepository;
    @XmlElement(nillable = true)
    private VolumeStorageType volumeStorageType;
    private Boolean hasLicense;

    public VolumeInformation(DeviceUID volumeID) {
        this.volumeID = volumeID;
    }

    public VolumeInformation(VolumeInformation other) {
        this(other.rawUid, other.naaUid, other.volumeID, other.vendorName, other.productName, other.modelName, other.sizeInBytes, other.vendorSpecificInformation,
            other.volumeName, other.arraySerialNumber, other.onArrayWithRepository/*, other.fileSystemInformation*/,
            other.volumeStorageType, other.hasLicense);
    }
}
