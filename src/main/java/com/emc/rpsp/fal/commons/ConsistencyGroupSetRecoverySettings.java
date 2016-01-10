package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsistencyGroupSetRecoverySettings")
public class ConsistencyGroupSetRecoverySettings implements Validateable {

    @XmlElement(nillable = true, required = true)
    private ClusterUID clusterUID;
    @XmlElement(nillable = true)
    private ImageAccessScenario imageAccessScenario;

}
