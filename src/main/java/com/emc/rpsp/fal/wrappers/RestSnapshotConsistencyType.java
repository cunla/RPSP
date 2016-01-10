package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.SnapshotConsistencyType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@NoArgsConstructor
@Data
public class RestSnapshotConsistencyType {
    private SnapshotConsistencyType restEnum;

    public RestSnapshotConsistencyType(SnapshotConsistencyType restEnum) {
        this.restEnum = restEnum;
    }
}
