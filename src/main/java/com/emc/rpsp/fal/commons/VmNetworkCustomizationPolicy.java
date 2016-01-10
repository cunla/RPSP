package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmNetworkCustomizationPolicy")
public class VmNetworkCustomizationPolicy implements Validateable {

    @XmlElement(nillable = true)
    private GlobalNetworkPolicy globalNetworkPolicy;
    private HashSet<NicCustomizationPolicy> nicsPolicies;

}
