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
@XmlType(name = "ReplicatedVMParams")
public class ReplicatedVMParams implements Validateable {

    @XmlElement(required = true)
    private GlobalCopyUID copyUID;
    @XmlElement(nillable = true, required = true)
    private VMParam vmParam;

}
