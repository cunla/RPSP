package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@SuppressWarnings("serial")
@XmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlType(name = "ConsistencyGroupCopyVolumeCreationParams")
public class ConsistencyGroupCopyVolumeCreationParams implements Validateable {

    private HashSet<BaseVolumeParams> volumeParams;

}
