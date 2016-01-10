package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmReplicationSetPolicy")
public class VmReplicationSetPolicy implements Validateable {

    @XmlElement(required = true)
    private int powerUpSequenceNumber;
    @XmlElement(required = true)
    private boolean critical;
    @XmlElement(nillable = true)
    private VirtualHardwareReplicationPolicy virtualHardwareReplicationPolicy;
    private VmStartUpActionsPolicy startUpActionsPolicy;

}
