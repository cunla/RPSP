package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayResourcePoolAllocationParams")
public class ArrayResourcePoolAllocationParams implements Validateable {

    @XmlElement(required = true)
    private ArrayResourcePoolSupportedTiers supportedTiers;
    @XmlElement(required = true)
    private ArrayResourcePoolTieringPolicies tieringPolicies;

}
