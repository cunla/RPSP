package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashSet;

@XmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RPAState")
////@LargeObject
public class RPAState {

    @XmlElement(nillable = true)
    private RpaUID rpaUID;
    private RPAStatus status;
    private VolumeStatus repositoryConnectivityStatus;
    private HashSet<RPAConnectivityStatus> remoteRPAsDataLinkStatus;
    private boolean runningClusterControl;
    private HashSet<RPAConnectivityStatus> remoteRPAsConnectivityStatus;
    private HashSet<RPAConnectivityStatus> localRPAsFiberConnectivityStatus;
    private HashSet<VolumeConnectivityStatus> volumesConnectivityStatus;
    private HashSet<RPAInterfaceStatus> interfacesStatus;
    private HashSet<SplitterConnectivityStatus> splittersConnectivityStatus;
    private GlobalSystemConfiguration globalSystemConfiguation;
    private RecoverPointVersion version;
    private String hardwareSerialID;
    private String wanIP;
    private String managementIPv4;
    private String managementIPv6;
    private ArrayList<InitiatorInformation> initiatorsState;
    private String vendor;
    private String hardwarePlatform;
    private long hbaType;
    private long systemMemory;
    private long numberOfCores;
    private RPAType type;

}
