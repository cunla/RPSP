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
@XmlType(name = "DatacenterEntitiesInformation")
public class DatacenterEntitiesInformation {

    @XmlElement(nillable = true)
    private DatacenterUID dcUID;
    private HashSet<VMEntitiesInformation> vmEntitiesInformation;
}
