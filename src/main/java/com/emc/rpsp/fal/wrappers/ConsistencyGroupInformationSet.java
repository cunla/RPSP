package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ConsistencyGroupInformation;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement
@NoArgsConstructor
@Data
public class ConsistencyGroupInformationSet {
    private Set<ConsistencyGroupInformation> innerSet;

    public ConsistencyGroupInformationSet(Set<ConsistencyGroupInformation> consistencyGroupInformationSet) {
        this.innerSet = consistencyGroupInformationSet;
    }
}
