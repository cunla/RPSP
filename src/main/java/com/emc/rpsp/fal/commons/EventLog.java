package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.LinkedList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EventLog")
public class EventLog {

    private RecoverPointTimeStamp eventTime;
    @XmlElement(nillable = true)
    private SystemEventUID systemEventUID;
    @XmlElement(nillable = true)
    private ClusterUID clusterUID;
    @XmlElement(nillable = true)
    private RpaUID rpaUID;
    private int eventID;
    private LinkedList<RpaUID> roles;
    private LinkedList<ConsistencyGroupCopyInfo> groupCopies;
    private LinkedList<DeviceInfo> devices;
    private LinkedList<ReplicationSetInfo> replicationSets;
    private LinkedList<SplitterVolumeInfo> splitterVolumes;
    private LinkedList<ConsistencyGroupLinkInfo> grouplinks;
    private LinkedList<GlobalLinkUID> globalLinks;
    private LinkedList<ArrayInfo> arrays;
    private LinkedList<VMEntitiesInformation> vms;
    private LinkedList<RpaView> rpaViews;
    private LinkedList<SplitterView> splitterViews;
    private LinkedList<ClusterUID> clusterList;
    private String username;
    private String details;
    private String seDetails;
    private boolean history;
    private List<SplitterInfo> splittersInfo;
    private List<ConsistencyGroupInfo> groupsInfo;
    @XmlElement(nillable = true)
    private EventLogInfo eventLogInfo;

    private String description;
}
