package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsistencyGroupVMReplicationParams")
public class ConsistencyGroupVMReplicationParams implements Validateable {
    @XmlElement(required = true)
    private ConsistencyGroupUID groupUID;
    @XmlElement(required = true)
    HashSet<VirtualDisksReplicationPolicyParam> virtualDisksReplicationPolicyParams;


}
