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
@XmlType(name = "ClusterSplittersSettings")
//@LargeObject
public class ClusterSplittersSettings {

    @XmlElement(nillable = true)
    private ClusterUID clusterUID;
    private HashSet<SplitterSettings> splittersSettings;

}
