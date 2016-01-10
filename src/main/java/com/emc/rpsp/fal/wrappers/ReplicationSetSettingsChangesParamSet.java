package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ReplicationSetSettingsChangesParam;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;


@XmlRootElement
@NoArgsConstructor
@Data
public class ReplicationSetSettingsChangesParamSet {
    private HashSet<ReplicationSetSettingsChangesParam> innerSet;

    public ReplicationSetSettingsChangesParamSet(
        HashSet<ReplicationSetSettingsChangesParam> replicationSetSettingsChangesParamSet) {
        this.innerSet = replicationSetSettingsChangesParamSet;
    }
}
