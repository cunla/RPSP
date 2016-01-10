package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AttachedUserVolumeInfo")
public class AttachedUserVolumeInfo {

    private DeviceUID volumeID;
    @XmlElement(nillable = true)
    private ReplicationSetUID replicationSetUID;
    private VolumeSANInfo sanInfo;

}
