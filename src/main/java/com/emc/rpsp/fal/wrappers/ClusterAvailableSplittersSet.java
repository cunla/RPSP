package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ClusterAvailableSplitters;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement
@NoArgsConstructor
@Data
public class ClusterAvailableSplittersSet {
    private Set<ClusterAvailableSplitters> innerSet;

    public ClusterAvailableSplittersSet(Set<ClusterAvailableSplitters> clusterAvailableSplittersSet) {
        this.innerSet = clusterAvailableSplittersSet;
    }
}
