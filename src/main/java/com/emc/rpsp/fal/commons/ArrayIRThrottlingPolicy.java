package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayIRThrottlingPolicy")
public class ArrayIRThrottlingPolicy implements Validateable {

    @XmlElement(required = true)
    private IRThrottleType throttleType;
    private Long customValue;

}
