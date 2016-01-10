package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ClusterSplittersSettings;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement
@NoArgsConstructor
@Data
public class ClusterSplittersSettingsSet {
    private Set<ClusterSplittersSettings> innerSet;

    public ClusterSplittersSettingsSet(Set<ClusterSplittersSettings> clusterSplittersSettingsSet) {
        this.innerSet = clusterSplittersSettingsSet;
    }
}
