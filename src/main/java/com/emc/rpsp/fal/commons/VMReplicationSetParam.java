package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VMReplicationSetParam")
public class VMReplicationSetParam implements Validateable {

    @XmlElement(required = true)
    private HashSet<ReplicatedVMParams> replicationSetVms;
    @XmlElement(required = true, nillable = true)
    private VirtualHardwareReplicationPolicy virtualHardwareReplicationPolicy;
    @XmlElement(required = true, nillable = true)
    private VirtualDisksReplicationPolicy virtualDisksReplicationPolicy;

    public VMReplicationSetParam(List<ReplicatedVMParams> replicatedVmParams,
                                 VirtualHardwareReplicationPolicy virtualHardwareReplicationPolicy,
                                 VirtualDisksReplicationPolicy virtualDisksReplicationPolicy) {
        this.replicationSetVms=new HashSet<>(replicatedVmParams);
        this.virtualHardwareReplicationPolicy=virtualHardwareReplicationPolicy;
        this.virtualDisksReplicationPolicy=virtualDisksReplicationPolicy;
    }
}
