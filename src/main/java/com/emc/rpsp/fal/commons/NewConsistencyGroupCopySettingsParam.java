package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@SuppressWarnings("serial")
@XmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NewConsistencyGroupCopySettingsParam")
public class NewConsistencyGroupCopySettingsParam implements Validateable {

    @XmlElement(required = true)
    private ConsistencyGroupCopyUID groupCopy;
    private HashSet<ConsistencyGroupLinkSettings> groupLinksSettings;
    private boolean transferEnabled;
    private boolean productionCopy;
    private ConsistencyGroupCopyPolicy copyPolicy;
    @XmlElement(required = true)
    private String copyName;
    private boolean enabled;
    private boolean allowAutomaticEnable;
    private HashSet<DeviceUID> newJournalVolumes;
    private ConsistencyGroupCopyVolumeCreationParams volumeCreationParams;

}
