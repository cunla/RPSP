package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FullVmReplicationPolicy")
public class FullVmReplicationPolicy implements Validateable {

    @XmlElement(nillable = true, required = true)
    private VmUID vmUID;
    @XmlElement(nillable = true, required = true)
    private VmReplicationPolicy vmReplicationPolicy;

}
