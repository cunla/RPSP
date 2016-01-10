package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ReplicationSetSettings;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement
@NoArgsConstructor
@Data
public class ReplicationSetSettingsSet {
    private Set<ReplicationSetSettings> innerSet;

    public ReplicationSetSettingsSet(Set<ReplicationSetSettings> replicationSetSettingsSet) {
        this.innerSet = replicationSetSettingsSet;
    }
}
