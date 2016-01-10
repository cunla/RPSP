package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FullConsistencyGroupCopyPolicy")
public class FullConsistencyGroupCopyPolicy implements Validateable {

    @XmlElement(required = true)
    private ConsistencyGroupCopyUID copyUID;
    @XmlElement(required = true)
    private String copyName;
    @XmlElement(required = true)
    private ConsistencyGroupCopyPolicy copyPolicy;

}
