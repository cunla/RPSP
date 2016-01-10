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
@XmlType(name = "ClusterVirtualInfrastructuresState")

public class ClusterVirtualInfrastructuresState {

    @XmlElement(nillable = true)
    private ClusterUID clusterUID;
    @XmlElement(nillable = true)
    private VirtualInfrastructuresState virtualInfrastructuresState;
}
