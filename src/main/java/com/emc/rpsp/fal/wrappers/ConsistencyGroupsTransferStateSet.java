package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ConsistencyGroupTransferState;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement
@NoArgsConstructor
@Data
public class ConsistencyGroupsTransferStateSet {

    private Set<ConsistencyGroupTransferState> innerSet;

    public ConsistencyGroupsTransferStateSet(Set<ConsistencyGroupTransferState> consistencyGroupTransferState) {
        this.innerSet = consistencyGroupTransferState;
    }

}
