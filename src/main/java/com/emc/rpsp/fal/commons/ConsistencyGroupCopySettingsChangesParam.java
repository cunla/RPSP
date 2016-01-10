package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.Collections;
import java.util.HashSet;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsistencyGroupCopySettingsChangesParam")
public class ConsistencyGroupCopySettingsChangesParam implements Validateable {

    @XmlElement(required = true)
    private ConsistencyGroupCopyUID copyUID;
    private HashSet<DeviceUID> newJournalVolumes;
    private HashSet<DeviceUID> removedJournalVolumes;
    private ConsistencyGroupCopyVolumeCreationParams volumeCreationParams;
    private ActivationSettingsChangesParams activationParams;

}
