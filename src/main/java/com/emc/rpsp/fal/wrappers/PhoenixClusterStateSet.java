package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.PhoenixClusterState;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement
@NoArgsConstructor
@Data
public class PhoenixClusterStateSet {
    private Set<PhoenixClusterState> innerSet;

    public PhoenixClusterStateSet(Set<PhoenixClusterState> phoenixClusterStateSet) {
        this.innerSet = phoenixClusterStateSet;
    }
}
