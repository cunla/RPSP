package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@XmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsistencyGroupInformation")
public class ConsistencyGroupInformation {

    @XmlElement(nillable = true)
    private ConsistencyGroupUID groupUID;
    private String name;
    private boolean enabled;
    private HashSet<ConsistencyGroupCopyUID> productionCopiesUID;
    private HashSet<ConsistencyGroupCopyInformation> groupCopiesInformation;
}
