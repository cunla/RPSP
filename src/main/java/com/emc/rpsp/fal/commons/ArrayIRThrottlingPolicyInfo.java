package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayIRThrottlingPolicyInfo")
public class ArrayIRThrottlingPolicyInfo implements Validateable {
    @XmlElement(nillable = true, required = true)
    private ArrayIRThrottlingPolicy arrayThrottlePolicy;
    private String arraySerialNumber;

}
