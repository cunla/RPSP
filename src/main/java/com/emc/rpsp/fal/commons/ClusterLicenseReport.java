package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlType(name = "ClusterLicenseReport")
public class ClusterLicenseReport {
    private HashSet<ClusterUID> clusters;
    private Set<LicenseSettings> activeLicenses;
    private Set<LicenseSettings> inactiveLicenes;
    private Set<LicenseSettings> expiredLicenes;
}
