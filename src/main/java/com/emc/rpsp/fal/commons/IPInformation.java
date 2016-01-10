package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IPInformation")
public class IPInformation implements Validateable {

    @XmlElement(nillable = true)
    private IPVersion ipVersion;
    @XmlElement(required = true)
    private String ip;

}
