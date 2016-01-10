package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ClusterVirtualEntitiesInformation;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement
@NoArgsConstructor
@Data
public class ClusterVirtualEntitiesInformationSet {
    private Set<ClusterVirtualEntitiesInformation> innerSet;

    public ClusterVirtualEntitiesInformationSet(
        Set<ClusterVirtualEntitiesInformation> clusterVirtualEntitiesInformationSet) {
        this.innerSet = clusterVirtualEntitiesInformationSet;
    }
}
