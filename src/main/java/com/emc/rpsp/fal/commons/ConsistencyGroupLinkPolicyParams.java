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
@XmlType(name = "ConsistencyGroupLinkPolicyParams")
public class ConsistencyGroupLinkPolicyParams implements Validateable {
    @XmlElement(required = true)
    private ConsistencyGroupLinkUID linkUid;
    @XmlElement(required = true)
    private ConsistencyGroupLinkPolicy policy;

}
