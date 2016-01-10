package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(name = "VmPowerUpSequenceParam")
public class VmPowerUpSequenceParam implements Validateable {

    @XmlElement(nillable = true, required = true)
    private VmReplicationSetUID vmReplicationSetUID;
    private int powerUpSequenceNumber;
    private Boolean isCritical;

}
