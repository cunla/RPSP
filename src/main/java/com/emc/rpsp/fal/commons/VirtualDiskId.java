package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualDiskId")
public class VirtualDiskId implements Validateable {

    private int unitNumber;
    private int controller;
    @XmlElement(nillable = true)
    private ControllerType controllerType;
}
