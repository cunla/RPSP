package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@XmlRootElement
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DefaultArrayResourcePoolParams")
public class DefaultArrayResourcePoolParams implements Validateable {
    @XmlElement(required = true)
    private Long requiredSizeInBytes;
    @XmlElement(nillable = true)
    private ArrayUID arrayUid;
    private ArrayResourcePoolTieringPolicy tieringPolicy;
    private ArrayResourcePoolType poolType;

}
