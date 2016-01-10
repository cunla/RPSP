package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ClusterRPAsState;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement
@NoArgsConstructor
@Data
public class ClusterRPAsStateSet {
    private Set<ClusterRPAsState> innerSet;

    public ClusterRPAsStateSet(Set<ClusterRPAsState> clusterRPAsStateSet) {
        this.innerSet = clusterRPAsStateSet;
    }
}
