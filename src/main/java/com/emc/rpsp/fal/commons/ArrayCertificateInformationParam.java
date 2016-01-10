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
@XmlType(name = "ArrayCertificateInformationParam")
public class ArrayCertificateInformationParam implements Validateable {

    @XmlElement(required = true)
    private String ip;
    @XmlElement(nillable = true, required = true)
    private ClusterUID clusterUID;
    @XmlElement(nillable = true)
    private ArrayType arrayType;

}
