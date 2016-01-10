package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ClusterArrayManagementProvidersState;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement
@NoArgsConstructor
@Data
public class ClusterArrayManagementProvidersStateSet {
    private Set<ClusterArrayManagementProvidersState> innerSet;

    public ClusterArrayManagementProvidersStateSet(
        Set<ClusterArrayManagementProvidersState> clusterAMPStateSet) {
        this.innerSet = clusterAMPStateSet;
    }
}
