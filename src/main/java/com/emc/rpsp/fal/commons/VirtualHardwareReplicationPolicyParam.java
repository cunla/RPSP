package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualHardwareReplicationPolicyParam")
public class VirtualHardwareReplicationPolicyParam implements Validateable {

    @XmlElement(required = true, nillable = true)
    private VmReplicationSetUID vmReplicationSetUID;
    @XmlElement(required = true, nillable = true)
    private VirtualHardwareReplicationPolicy virtualDisksReplicationPolicy;

}
