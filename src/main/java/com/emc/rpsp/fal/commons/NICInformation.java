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
@XmlType(name = "NICInformation")
public class NICInformation {
    @XmlElement(nillable = true)
    private IPInformation ipInformation;
    @XmlElement(nillable = true)
    private NetworkInterface networkInterface;
    private String networkMask;
    @XmlElement(nillable = true)
    private AutoNegotiationInformation autoNegotiationInformation;
}
