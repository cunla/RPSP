package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ClusterVCenterServerView;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement
@NoArgsConstructor
@Data
public class ClusterVCenterServerViewSet {
    private Set<ClusterVCenterServerView> innerSet;

    public ClusterVCenterServerViewSet(Set<ClusterVCenterServerView> clusterVCenterServerViewSet) {
        this.innerSet = clusterVCenterServerViewSet;
    }
}
