package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddArrayParams")
public class AddArrayParams implements Validateable {

    @XmlElement(required = true)
    private String arrayName;
    private String serialNumber;
    @XmlElement(nillable = true, required = true)
    private ClusterUID clusterUID;
    @XmlElement(nillable = true, required = true)
    private ArrayType arrayType;
    private ArrayManagementProviderUID ampUID;
    @XmlElement(nillable = true)
    private ArrayUID arrayUID;
    @XmlElement(required = true)
    private ConfigurationParams arrayConfiguration;
    private boolean force;


}
