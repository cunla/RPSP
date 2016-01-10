package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.HashSet;
import java.util.LinkedList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterConfiguration")
public class ClusterConfiguration {
    private ClusterUID cluster;
    private HashSet<RPAConfiguration> rpasConfiguration;
    private HashSet<IPInformation> managementIPs;
    private String internalClusterName;
    private HashSet<RemoteISCSIPortsConfiguration> remoteISCSITargetsPortsConfiguration;
    private HashSet<RemoteClusterConnectionInformation> remoteClustersConnectionInformation;
    private HashSet<GatewayInformation> gateways;
    @XmlElement(nillable = true)
    private TimeZoneInfo timeZoneInfo;
    private String clusterName;
    private String domain;
    private LinkedList<String> dnsIPs;
    @XmlElement(nillable = true)
    private ProductType productType;
    private int numberOfExposedLUNs;
    private boolean initiatorOnlyMode;
    private int numberOfVirtualPorts;
    private int numberOfInitiatorIQNs;
}
