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
@XmlType(name = "EsxClusterConfiguration")
public class EsxClusterConfiguration {

    @XmlElement(nillable = true)
    private EsxClusterUID esxClusterUID;
    private String name;
    private HashSet<EsxConfiguration> esxsConfiguration;
    @XmlElement(nillable = true)
    private ResourcePoolConfiguration resourcePoolConfiguration;
    private EsxClusterAbilities abilities;
}
