package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterAvailableArrays")
public class ClusterAvailableArrays {

    @XmlElement(nillable = true)
    private ClusterUID clusterUID;
    private HashSet<ArrayInfo> availableArrays;
}
