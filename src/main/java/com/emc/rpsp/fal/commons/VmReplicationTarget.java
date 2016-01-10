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
@XmlType(name = "VmReplicationTarget")
public class VmReplicationTarget implements Validateable {

    @XmlElement(required = true)
    private ClusterUID targetClusterUID;
    @XmlElement(required = true)
    private VirtualCenterUID targetVirtualCenterUID;
    @XmlElement(required = true)
    private DatacenterUID targetDatacenterUID;
    @XmlElement(required = true)
    private EsxClusterUID targetEsxClusterUID;

}
