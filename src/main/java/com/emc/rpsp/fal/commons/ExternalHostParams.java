package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExternalHostParams")
public class ExternalHostParams implements Validateable {

    @XmlElement(required = true, nillable = true)
    private ClusterUID clusterUID;
    @XmlElement(required = true)
    private String hostNiceName;
    @XmlElement(required = true)
    private ConfigurationParams configParams;

}
