package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterSettings")
public class ClusterSettings {

    private String clusterName;
    @XmlElement(nillable = true)
    private ClusterUID clusterUID;
    private HashSet<RpaUID> rpasUIDs;
    private HashSet<VCenterServer> vcenterServers;
    private HashSet<VCenterServerFilters> vcenterServersFilters;
    private RepositoryVolumeSettings repositoryVolume;
    private String attachedPhoenixClusterName;
    private HashSet<ArrayIRThrottlingPolicyInfo> throttlePolicy;
    private int clusterIndex;
    private ClusterMaintenanceMode maintenanceMode;
    private String locationID;
    private String softwareSerialId;
    private HashSet<ArrayManagementProviderSettings> ampsSettings;
    private ClusterAutoRegistrationInformation autoRegistrationInfo;
    private HashSet<ExternalHostSettings> externalHostsSettings;

}
