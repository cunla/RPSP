package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayResourcePoolInfo")
public class ArrayResourcePoolInfo {

    @XmlElement(nillable = true)
    private ResourcePoolUID resourcePoolUID;
    private String name;
    private ArrayResourcePoolType resourcePoolType;
    private ArrayResourcePoolAllocationParams allocationParams;
    private ResourcePoolUsageStats usageStats;

}
