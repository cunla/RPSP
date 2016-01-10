package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(name = "ConsistencyGroupCopyPolicyParams")
public class ConsistencyGroupCopyPolicyParams implements Validateable {
    @XmlElement(required = true)
    private ConsistencyGroupCopyUID copyUid;
    @XmlElement(required = true)
    private ConsistencyGroupCopyPolicy policy;

}
