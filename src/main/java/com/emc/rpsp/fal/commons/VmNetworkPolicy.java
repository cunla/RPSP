package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmNetworkPolicy")
public class VmNetworkPolicy implements Validateable {

    @XmlElement(required = true)
    private ConsistencyGroupUID group;
    @XmlElement(nillable = true, required = true)
    private VmUID vmUID;
    @XmlElement(nillable = true, required = true)
    private VmNetworkCustomizationPolicy vmNetworkCustomizationPolicy;

}
