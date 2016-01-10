package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsistencyGroupState")
//@LargeObject
public class ConsistencyGroupState {

    private ConsistencyGroupUID groupUID;
    private boolean enabled;
    private HashSet<ConsistencyGroupCopyUID> sourceCopiesUIDs;
    private HashSet<ConsistencyGroupCopyState> groupCopiesState;
    private HashSet<ConsistencyGroupLinkState> linksState;
    private boolean runningAsDistributedGroup;
    private boolean stateUnknown;
    @XmlElement(nillable = true)
    private VplexMetroLinkState vplexMetroLinkState;

}
