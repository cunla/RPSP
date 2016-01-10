package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@XmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualDiskInformation")
public class VirtualDiskInformation {

    private long capacity;
    @XmlElement(nillable = true)
    private VirtualDiskId virtualDiskId;
    private VirtualDiskReplicationCapabilities replicationCapabilities;
}
