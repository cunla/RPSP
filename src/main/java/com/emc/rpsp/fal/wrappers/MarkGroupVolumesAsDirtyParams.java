package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ReplicationSetUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;


@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class MarkGroupVolumesAsDirtyParams {

    private HashSet<ReplicationSetUID> replicationSets;

}
