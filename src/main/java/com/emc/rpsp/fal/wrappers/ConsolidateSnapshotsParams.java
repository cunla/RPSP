package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.Snapshot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;


@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class ConsolidateSnapshotsParams {

    private Snapshot start;
    private Snapshot end;

}
