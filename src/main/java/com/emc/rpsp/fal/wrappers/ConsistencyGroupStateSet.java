package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ConsistencyGroupState;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement
@NoArgsConstructor
@Data
public class ConsistencyGroupStateSet {
    private Set<ConsistencyGroupState> innerSet;

    public ConsistencyGroupStateSet(Set<ConsistencyGroupState> consistencyGroupStateSet) {
        this.innerSet = consistencyGroupStateSet;
    }
}
