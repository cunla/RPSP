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

@JsonTypeName("SymmetrixVolumeInformation")
@XmlType(name = "SymmetrixVolumeInformation")
public class SymmetrixVolumeInformation extends VolumeInformation {

    private boolean tagged;

    public SymmetrixVolumeInformation(LinkedList<Byte> rawUid, LinkedList<Byte> naaUid, DeviceUID volumeID, String vendorName, String productName,
                                      String modelName, Long sizeInBytes, String vendorSpecificInformation, String volumeName,
                                      String arraySerialNumber, Boolean onArrayWithRepository,
                                      boolean tagged, Boolean hasLicense) {
        super(rawUid, naaUid, volumeID, vendorName, productName, modelName, sizeInBytes, vendorSpecificInformation, volumeName,
            arraySerialNumber, onArrayWithRepository, VolumeStorageType.SYMMETRIX, hasLicense);
        this.tagged = tagged;
    }
}
