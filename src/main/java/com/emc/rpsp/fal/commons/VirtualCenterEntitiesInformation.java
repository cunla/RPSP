package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@XmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualCenterEntitiesInformation")
public class VirtualCenterEntitiesInformation {

    @XmlElement(nillable = true)
    private VirtualCenterUID virtualCenterUID;
    private String name;
    private HashSet<DatacenterEntitiesInformation> dcEntitiesInformation;
}
