package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VCenterServer")
public class VCenterServer {

    @XmlElement(nillable = true)
    private VCenterServerUID vcenterServerUID;
    private String userName;
    private int port;
    private boolean certificateConfigured;

}
