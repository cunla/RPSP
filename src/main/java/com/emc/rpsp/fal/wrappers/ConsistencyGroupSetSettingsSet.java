package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ConsistencyGroupSetSettings;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement
@NoArgsConstructor
@Data
public class ConsistencyGroupSetSettingsSet {
    private Set<ConsistencyGroupSetSettings> innerSet;

    public ConsistencyGroupSetSettingsSet(Set<ConsistencyGroupSetSettings> consistencyGroupSetSettingsSet) {
        this.innerSet = consistencyGroupSetSettingsSet;
    }
}
