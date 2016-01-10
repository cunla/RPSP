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
@XmlType(name = "VirtualHardwareReplicationPolicy")
public class VirtualHardwareReplicationPolicy implements Validateable {
    @XmlElement(required = true)
    private DiskProvisionPolicy provisionPolicy;
    @XmlElement(required = true)
    private HardwareChangesPolicy hwChangesPolicy;

}
