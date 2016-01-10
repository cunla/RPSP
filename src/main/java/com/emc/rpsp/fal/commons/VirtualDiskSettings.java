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
@XmlType(name = "VirtualDiskSettings")
public class VirtualDiskSettings implements Validateable {
    @XmlElement(required = true)
    private VirtualDiskId diskId;
    @XmlElement(required = true)
    private boolean included;

}
