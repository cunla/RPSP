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
@XmlType(name = "ConsistencyGroupCopyInformation")
public class ConsistencyGroupCopyInformation {

    @XmlElement(nillable = true)
    private ConsistencyGroupCopyUID groupCopyUID;
    private String name;
    private ConsistencyGroupCopyRole role;
    private HashSet<VmInformation> vmsInformation;
}
