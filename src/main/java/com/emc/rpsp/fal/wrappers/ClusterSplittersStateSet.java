package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ClusterSplittersState;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement
@NoArgsConstructor
@Data
public class ClusterSplittersStateSet {
    private Set<ClusterSplittersState> innerSet;

    public ClusterSplittersStateSet(Set<ClusterSplittersState> clusterSplittersStateSet) {
        this.innerSet = clusterSplittersStateSet;
    }
}
