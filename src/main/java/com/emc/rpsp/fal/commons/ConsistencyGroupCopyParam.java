package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(name = "ConsistencyGroupCopyParam")
public class ConsistencyGroupCopyParam implements Validateable {

    @XmlElement(required = true)
    private GlobalCopyUID copyUID;
    @XmlElement(required = true)
    private String copyName;
    @XmlElement(required = true)
    private ConsistencyGroupCopyVolumeCreationParams volumeCreationParams;

}
