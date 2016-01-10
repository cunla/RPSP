package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ClusterLicenseReport;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement
@NoArgsConstructor
@Data
public class ClusterLicenseReportSet {
    private Set<ClusterLicenseReport> innerSet;

    public ClusterLicenseReportSet(Set<ClusterLicenseReport> clusterLicenseReportSet) {
        this.innerSet = clusterLicenseReportSet;
    }
}
