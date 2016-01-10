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
@XmlType(name = "EsxConfiguration")
public class EsxConfiguration {

    @XmlElement(nillable = true)
    private EsxUID esxUID;
    private String name;
    private String version;
    private HashSet<VmUID> nonRelevantVMs;
}
