package com.emc.rpsp.fal.commons;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.LinkedList;

@XmlRootElement
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

@JsonTypeName("VirtualVolumeInformation")
@XmlType(name = "VirtualVolumeInformation")
public class VirtualVolumeInformation extends VolumeInformation {

    private String fileName;
    private VirtualVolumeType volumeType;

    public VirtualVolumeInformation(LinkedList<Byte> rawUid, LinkedList<Byte> naaUid, DeviceUID volumeID, String vendorName, String productName,
                                    String modelName, Long sizeInBytes, String vendorSpecificInformation, String volumeName,
                                    String serialNumber, Boolean onArrayWithRepository,
                                    Boolean hasLicense, String fileName, VirtualVolumeType volumeType) {
        super(rawUid, naaUid, volumeID, vendorName, productName, modelName, sizeInBytes, vendorSpecificInformation, volumeName,
            serialNumber, onArrayWithRepository, VolumeStorageType.VIRTUAL, hasLicense);
        this.fileName = fileName;
        this.volumeType = volumeType;
    }
}
