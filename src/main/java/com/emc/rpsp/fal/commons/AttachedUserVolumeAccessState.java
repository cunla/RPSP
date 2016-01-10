package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlType(name = "AttachedUserVolumeAccessState")
public class AttachedUserVolumeAccessState {

    private DeviceUID volumeID;
    private ConsistencyGroupCopyUID groupCopyUID;
    @XmlElement(nillable = true)
    private ReplicationSetUID replicationSetUID;
    private VolumeAccessState accessState;
    private Boolean visible;
    private int currentDelayExpiryTimeoutInSeconds;
}
