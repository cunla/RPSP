package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ClusterVCenterServers;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement
@NoArgsConstructor
@Data
public class ClusterVCenterServersSet {
    private Set<ClusterVCenterServers> innerSet;

    public ClusterVCenterServersSet(Set<ClusterVCenterServers> clusterVCenterServersSet) {
        this.innerSet = clusterVCenterServersSet;
    }
}
