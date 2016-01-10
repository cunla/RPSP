package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MonitoredParameterKey")
public class MonitoredParameterKey {

    @XmlElement(nillable = true)
    private RpaUID rpaUID;
    private String context;
    @XmlElement(nillable = true)
    private ConsistencyGroupCopyUID consistencyGroupCopyUID;
    @XmlElement(nillable = true)
    private ArrayUID arrayUID;
    @XmlElement(nillable = true)
    private SplitterUID splitterUID;
    @XmlElement(nillable = true)
    private ClusterUID clusterUID;
    private MonitoredParameterType parameterType;
    private GlobalLinkUID globalLink;
    private VirtualCenterUID vcUID;
    private ConsistencyGroupUID groupUID;
}
