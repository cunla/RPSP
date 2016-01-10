package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserVolumeSettingsChangesParam")
public class UserVolumeSettingsChangesParam implements Validateable {

    private DeviceUID newVolumeID;
    private DeviceUID removedVolumeID;
    @XmlElement(required = true)
    private ConsistencyGroupCopyUID copyUID;
    /*private FileSystemVolumeCreationParam fileSystemCreationInfo;*/ //XXX Vnx

}
