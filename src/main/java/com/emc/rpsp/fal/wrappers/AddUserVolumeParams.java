package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.DeviceUID;
import com.emc.rpsp.fal.commons.ReplicationSetUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;


@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class AddUserVolumeParams {

    private DeviceUID volumeID;
    private ReplicationSetUID replicationSet;

}
