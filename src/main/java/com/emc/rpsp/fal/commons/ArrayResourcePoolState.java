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
@XmlType(name = "ArrayResourcePoolState")
public class ArrayResourcePoolState {

    @XmlElement(nillable = true)
    private ResourcePoolUID resourcePoolUID;

    @XmlElement(nillable = true)
    private ResourcePoolUsageStats resourcePoolUsageStats;

}
