package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ConsistencyGroupVolumesState;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement
@NoArgsConstructor
@Data
public class ConsistencyGroupVolumesStateSet {
    private Set<ConsistencyGroupVolumesState> innerSet;

    public ConsistencyGroupVolumesStateSet(Set<ConsistencyGroupVolumesState> consistencyGroupVolumesStateSet) {
        this.innerSet = consistencyGroupVolumesStateSet;
    }
}
