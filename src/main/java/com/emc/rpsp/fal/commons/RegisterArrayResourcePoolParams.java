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
@XmlType(name = "RegisterArrayResourcePoolParams")
public class RegisterArrayResourcePoolParams implements Validateable {

    @XmlElement(nillable = true, required = true)
    private ResourcePoolUID resourcePoolUID;

    @XmlElement(required = true)
    private ArrayResourcePoolType resourcePoolType;

}
