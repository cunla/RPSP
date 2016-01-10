package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@SuppressWarnings("serial")
@XmlRootElement
@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsistencyGroupSetSettings")
public class ConsistencyGroupSetSettings implements Validateable {

    @XmlElement(required = true)
    private ConsistencyGroupSetUID setUID;
    @XmlElement(required = true)
    private String name;
    private HashSet<ConsistencyGroupUID> groupsUIDs;
    private HashSet<ConsistencyGroupSetRecoverySettings> recoverySettings;
    private ConsistentGroupSetConsistencyPolicy consistencyPolicy;

}
