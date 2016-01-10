package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.LinkedList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RpaView")
public
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
class RpaView {
    @XmlElement(nillable = true)
    private RpaUID rpaUID;
    private LinkedList<DeviceInfo> volumes;
    private LinkedList<ConsistencyGroupCopyInfo> groupCopies;
    private LinkedList<ConsistencyGroupCopyInfo> jvolGroupCopies;
    private LinkedList<ConsistencyGroupCopyInfo> uvolGroupCopies;
    private LinkedList<SplitterInfo> splitters;
    private LinkedList<RpaUID> peerRPAs;
    private LinkedList<ClusterUID> peerClusterList;
}
