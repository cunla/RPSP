package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ClusterArrayManagementProviderSettings;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement
@NoArgsConstructor
@Data
public class ClusterArrayManagementProviderSettingsSet {
    private Set<ClusterArrayManagementProviderSettings> innerSet;

    public ClusterArrayManagementProviderSettingsSet(
        Set<ClusterArrayManagementProviderSettings> clusterAMPSettingsSet) {
        this.innerSet = clusterAMPSettingsSet;
    }
}
