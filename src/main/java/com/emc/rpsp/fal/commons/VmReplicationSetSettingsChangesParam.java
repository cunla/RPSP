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
@XmlType(name = "VmReplicationSetSettingsChangesParam")
public class VmReplicationSetSettingsChangesParam implements Validateable {

    @XmlElement(nillable = true, required = true)
    private VmReplicationSetUID vmReplicationSetUID; // cannot be null
    @XmlElement(required = true)
    private HashSet<VmReplicationSettingsChangesParam> vmReplicationChanges;

}
