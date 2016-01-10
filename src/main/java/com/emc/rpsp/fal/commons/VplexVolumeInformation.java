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

@JsonTypeName("VplexVolumeInformation")
@XmlType(name = "VplexVolumeInformation")
public class VplexVolumeInformation extends VolumeInformation {

    private VplexVolumeLocality locality;
    private boolean winner;
    private String vplexConsistencyGroupName;
    private String recoverPointClusterName;
    private boolean rpEnabled;
    private Boolean isMetroCandidate;

    public VplexVolumeInformation(LinkedList<Byte> rawUid, LinkedList<Byte> naaUid, DeviceUID volumeID, String vendorName, String productName,
                                  String modelName, Long sizeInBytes, String vendorSpecificInformation, String volumeName,
                                  String arraySerialNumber, Boolean onArrayWithRepository,
                                  VplexVolumeLocality locality, boolean isWinner, String vplexConsistencyGroupName, String recoverPointClusterName, boolean isRPEnabled
        , Boolean hasLicense, Boolean isMetroCandidate) {
        super(rawUid, naaUid, volumeID, vendorName, productName, modelName, sizeInBytes, vendorSpecificInformation, volumeName,
            arraySerialNumber, onArrayWithRepository, VolumeStorageType.VPLEX, hasLicense);
        this.locality = locality;
        this.winner = isWinner;
        this.vplexConsistencyGroupName = vplexConsistencyGroupName;
        this.recoverPointClusterName = recoverPointClusterName;
        this.rpEnabled = isRPEnabled;
        this.isMetroCandidate = isMetroCandidate;
    }

    public VplexVolumeInformation(VolumeInformation volumeInformation, VplexVolumeLocality locality,
                                  boolean isWinner, String vplexConsistencyGroupName, String recoverPointClusterName, Boolean isMetroCandidate) {
        super(volumeInformation);
        this.locality = locality;
        this.winner = isWinner;
        this.vplexConsistencyGroupName = vplexConsistencyGroupName;
        this.recoverPointClusterName = recoverPointClusterName;
        this.isMetroCandidate = isMetroCandidate;
    }
}
