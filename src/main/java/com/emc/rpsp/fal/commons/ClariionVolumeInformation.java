package com.emc.rpsp.fal.commons;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;
import java.util.LinkedList;

@XmlRootElement
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

@JsonTypeName("ClariionVolumeInformation")
@XmlType(name = "ClariionVolumeInformation")
public class ClariionVolumeInformation extends VolumeInformation {

    private HashSet<String> groupSets;

    public ClariionVolumeInformation(LinkedList<Byte> rawUid, LinkedList<Byte> naaUid, DeviceUID volumeID, String vendorName, String productName,
                                     String modelName, Long sizeInBytes, String vendorSpecificInformation, String volumeName,
                                     String arraySerialNumber, Boolean onArrayWithRepository,
                                     HashSet<String> groupSets, Boolean hasLicense) {
        super(rawUid, naaUid, volumeID, vendorName, productName, modelName, sizeInBytes, vendorSpecificInformation, volumeName,
            arraySerialNumber, onArrayWithRepository, VolumeStorageType.VNX_OR_CLARIION, hasLicense);
        this.groupSets = groupSets;
    }

    public ClariionVolumeInformation(VolumeInformation volumeInformation, HashSet<String> groupSets) {
        super(volumeInformation);
        this.groupSets = groupSets;
    }
}
