package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;

@XmlRootElement
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlType(name = "ConsistencyGroupTopologyParams")
public class ConsistencyGroupTopologyParams implements Validateable {

    private HashSet<ConsistencyGroupLinkSettings> linksToAdd;
    private HashSet<ConsistencyGroupCopyUID> copiesToRemove;
    private HashSet<ConsistencyGroupCopyUID> copiesToDisable;

}
