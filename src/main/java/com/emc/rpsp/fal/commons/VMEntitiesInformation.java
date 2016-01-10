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
@XmlType(name = "VMEntitiesInformation")
public class VMEntitiesInformation {

    @XmlElement(nillable = true)
    private VmUID vmUID;
    private String name;
    private HashSet<VirtualDiskInformation> disksSet;
}
