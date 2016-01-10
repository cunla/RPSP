package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ClusterSupportedArrayManagementProviderAndArrayTypes;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement
@NoArgsConstructor
@Data
public class ClusterSupportedAMPAndArrayTypesSet {
    private Set<ClusterSupportedArrayManagementProviderAndArrayTypes> innerSet;

    public ClusterSupportedAMPAndArrayTypesSet(
        Set<ClusterSupportedArrayManagementProviderAndArrayTypes> clusterSupportedAMPAndArrayTypesSet) {
        this.innerSet = clusterSupportedAMPAndArrayTypesSet;
    }
}
