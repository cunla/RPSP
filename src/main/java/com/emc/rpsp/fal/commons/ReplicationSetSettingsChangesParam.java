package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReplicationSetSettingsChangesParam")
public class ReplicationSetSettingsChangesParam implements Validateable {

    @XmlElement(required = true)
    private String name;
    @XmlElement(nillable = true)
    private ReplicationSetUID replicationSetUID; // will be null when this is a newly created set
    private boolean shouldAttachAsClean;
    private HashSet<UserVolumeSettingsChangesParam> volumesChanges;
    @XmlElement(nillable = true)
    private ResizeReplicationSetParam resizeReplicationSetParam;

}
