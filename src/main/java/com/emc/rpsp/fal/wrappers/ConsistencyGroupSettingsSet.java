package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ConsistencyGroupSettings;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement
@NoArgsConstructor
@Data
public class ConsistencyGroupSettingsSet {
    private Set<ConsistencyGroupSettings> innerSet;

    public ConsistencyGroupSettingsSet(Set<ConsistencyGroupSettings> consistencyGroupSettingsSet) {
        this.innerSet = consistencyGroupSettingsSet;
    }
}
