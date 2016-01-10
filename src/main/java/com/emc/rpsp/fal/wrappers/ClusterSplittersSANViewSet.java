package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ClusterSplittersSANView;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement
@NoArgsConstructor
@Data
public class ClusterSplittersSANViewSet {
    private Set<ClusterSplittersSANView> innerSet;

    public ClusterSplittersSANViewSet(Set<ClusterSplittersSANView> clusterSplittersSANViewSet) {
        this.innerSet = clusterSplittersSANViewSet;
    }
}
